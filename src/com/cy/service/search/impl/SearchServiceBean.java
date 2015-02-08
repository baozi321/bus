package com.cy.service.search.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.cy.bean.bus.BusLine;
import com.cy.bean.bus.Station;
import com.cy.bean.search.Transfer;
import com.cy.service.base.DAOSupport;
import com.cy.service.search.SearchService;
import com.cy.utils.SysParam;

/**
 * 搜索引擎Service接口实现类
 * @author CY
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class SearchServiceBean extends DAOSupport implements SearchService {

	@Override
	public List searchStations(String q) {
		String jql = "select o from Station o,Line_Station ls where o.id=ls.station.id and o.name like ?1 group by ls.station.id order by count(ls.station.id) desc";
		Query query = em.createQuery(jql);
		query.setParameter(1, "%"+q+"%");
		return query.getResultList();
	}
	
	@Override
	public List searchBusLines(String q) {
		String jql = "select o from BusLine o where o.name like ?1 order by name asc";
		Query query = em.createQuery(jql);
		query.setParameter(1, "%"+q+"%");
		return query.getResultList();
	}
	
	/**
	 * 是否为换乘
	 * @param q 查询条件
	 * @return
	 */
	public static String[] isTransfer(String q) {
		String[] query = null;
		if(q != null && !"".equals(q.trim())) {
			query = q.split(" ");
			if(query.length > 1) {
				String[] str = {query[0],query[1]};
				return str;
			}
		}
		return null;
	}
	
	/**
	 * 是否为公交路线
	 * @param q 查询条件
	 * @return
	 */
	public static String isLine(String q) {
		// 查询公交路线
		String[] lineRegexs = {"^\\d+$","\\d+路","\\d+路公交","\\d+公交"};
		for(String lineRegex : lineRegexs) {
			Pattern p = Pattern.compile(lineRegex);
			Matcher m = p.matcher(q);
			if(m.find()) {
				Pattern p_ = Pattern.compile("\\d+");
				Matcher m_ = p_.matcher(m.group());
				if(m_.find()) {
					return m_.group();
				}
			}
		}
		return null;
	}
	
	@Override
	public List searchHotStations() {
		String sql = "select ls.stationid,s.name,count(ls.stationid)"
				+ " from line_station ls,station s"
				+ " where s.id = ls.stationid"
				+ " group by ls.stationid"
				+ " having count(ls.stationid)>" + SysParam.read("hotNum")
				+ " order by count(ls.stationid) desc";
		Query query = em.createNativeQuery(sql);
		return query.getResultList();
	}

	@Override
	public List searchTransfer(String[] q) {
		/*
		 * 换乘查询sql语句(只需要做一辆公交车即可)
		 * 假如：从  重大城市科技学院  到  渝西广场
		 * 查询到 重大城市科技学院 且到 渝西广场 的公交车
		 * 首先查询出到重大城市科技学院 的公交车 ， 然后在查询出到 渝西广场 的公交车，最后找出这两组公交车中id相同的公交车。
		 */
		String jql = "select o.busLine "
				+ "from Line_Station o,Line_Station o1 "
				+ "where o.station.name like ?1 and o1.station.name like ?2 and o.busLine.id = o1.busLine.id "
				+ "order by o.busLine.id asc";
		Query query = em.createQuery(jql);
		query.setParameter(1, "%"+q[0]+"%").setParameter(2, "%"+q[1]+"%");
		return query.getResultList();
	}
	
	@Override
	public Set<Transfer> searchTransfer2(String[] q) {
		/* 
		 * 换乘查询的sql语句(需要座两次公交车)
		 * 假如：从  重大城市科技学院  到  茶山竹海
		 * 先查询出到重大城市科技学院的公交车 
		 * select ls.busLine from Line_Station ls where ls.station.name like '重大城市科技学院';
		 * 
		 * 在查询出到茶山竹海的公交车 
		 * select ls.busLine from Line_Station ls where ls.station.name like '茶山竹海';
		 * 
		 * 然后在查询出到 重大城市科技学院 和 茶山竹海 的公交车 是否有到相同的车站即可 
		 * select distinct ls1.busLine,ls2.busLine from Line_Station ls1, Line_Station ls2 where ls1.busLine in (到重大城市科技学院的公交车) and ls2.busLine in(到茶山竹海的公交车) and ls1.station=ls2.station;
		 * 
		 */
		String jql = "select ls1.busLine,ls2.busLine,ls1.station from Line_Station ls1, Line_Station ls2 where ls1.busLine in ("
				+ "select ls.busLine from Line_Station ls where ls.station.name like ?1) and "
				+ "ls2.busLine in(select ls.busLine from Line_Station ls where ls.station.name like ?2) and "
				+ "ls1.station=ls2.station";
		Query query = em.createQuery(jql);
		query.setParameter(1, "%"+q[0]+"%").setParameter(2, "%"+q[1]+"%");
		//查询出的结果
		@SuppressWarnings("unchecked")
		List<Object[]> res = query.getResultList();
		//最后返回的结果
		Set<Transfer> transfers = new HashSet<>();
		for(Object[] obj : res) {
			Transfer transfer = new Transfer((BusLine)obj[0], (BusLine)obj[1], (Station)obj[2]);
			transfers.add(transfer);
		}
		return transfers;
	}
	
	@Deprecated
	public List searchTransfer2_(String[] q) {
		/* 
		 * 换乘查询的sql语句(需要座两次公交车)
		 * 假如：从  重大城市科技学院  到  茶山竹海
		 * 先查询出到重大城市科技学院的公交车 
		 * select ls.busLine from Line_Station ls where ls.station.name like '重大城市科技学院';
		 * 
		 * 在查询出到茶山竹海的公交车 
		 * select ls.busLine from Line_Station ls where ls.station.name like '茶山竹海';
		 * 
		 * 然后在查询出到 重大城市科技学院 和 茶山竹海 的公交车 是否有到相同的车站即可 
		 * select distinct ls1.busLine,ls2.busLine from Line_Station ls1, Line_Station ls2 where ls1.busLine in (到重大城市科技学院的公交车) and ls2.busLine in(到茶山竹海的公交车) and ls1.station=ls2.station;
		 * 
		 */
		String jql = "select distinct ls1.busLine,ls2.busLine from Line_Station ls1, Line_Station ls2 where ls1.busLine in ("
				+ "select ls.busLine from Line_Station ls where ls.station.name like ?1) and "
				+ "ls2.busLine in(select ls.busLine from Line_Station ls where ls.station.name like ?2) and "
				+ "ls1.station=ls2.station";
		
		/* 以下这个sql语句， 不仅实现了上述的功能，而已还可以查询出这2两符合要求的公交车，所经过的相同车站 */
//		String jql = "select ls1.busLine,ls2.busLine,ls1.station from Line_Station ls1, Line_Station ls2 where ls1.busLine in ("
//				+ "select ls.busLine from Line_Station ls where ls.station.name like ?1) and "
//				+ "ls2.busLine in(select ls.busLine from Line_Station ls where ls.station.name like ?2) and "
//				+ "ls1.station=ls2.station";
		Query query = em.createQuery(jql);
		query.setParameter(1, "%"+q[0]+"%").setParameter(2, "%"+q[1]+"%");
		return query.getResultList();
	}

}