package com.cy.service.search;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import com.cy.bean.QueryResult;
import com.cy.bean.search.Transfer;
import com.cy.service.base.DAO;
/**
 * 搜索引擎Service接口
 * @author CY
 *
 */
@SuppressWarnings("rawtypes")
public interface SearchService extends DAO {
	
	/**
	 * 换乘查询，需要做两次公交车
	 * @param q
	 * @return
	 */
	public Set<Transfer> searchTransfer2(String[] q);
	
	/**
	 * 换乘查询
	 * @param q
	 * @return
	 */
	public List searchTransfer(String[] q);
	
	/**
	 * 搜索公交站
	 * @param q 查询条件
	 * @return
	 */
	public List searchStations(String q);
	
	/**
	 * 搜索公交路线
	 * @param q 查询条件
	 * @return
	 */
	public List searchBusLines(String q);
	
	/**
	 * 搜索热点车站<br/>
	 * 按热度排序<br/>
	 * 公交车经常路过的车站
	 * select ls.stationid,s.name,count(ls.stationid) 
	 * from line_station ls,station s 
	 * where s.id = ls.stationid  
	 * group by ls.stationid 
	 * having count(ls.stationid)>3 
	 * order by count(ls.stationid) desc;
	 * @return
	 */
	public List searchHotStations();
	

	@Override
	@Deprecated
	public void setBooleanFiled(String booleanFiled, boolean state,
			String entityIDName, Serializable... entityID);

	@Override
	@Deprecated
	public QueryResult getScrollData();

	@Override
	@Deprecated
	public QueryResult getScrollData(int firstResult, int maxResult);

	@Override
	@Deprecated
	public QueryResult getScrollData(int firstResult, int maxResult,
			LinkedHashMap orderby);

	@Override
	@Deprecated
	public QueryResult getScrollData(int firstResult, int maxResult,
			String where, Object[] params);

	@Override
	@Deprecated
	public QueryResult getScrollData(int firstResult, int maxResult,
			String where, Object[] params, LinkedHashMap orderby);

	@Override
	@Deprecated
	public void save(Object entity);

	@Override
	@Deprecated
	public void update(Object entity);

	@Override
	@Deprecated
	public void delete(Serializable... entityID);

	@Override
	@Deprecated
	public Object find(Serializable entityID);

	@Override
	@Deprecated
	public Object getReference(Serializable entityID);

	@Override
	@Deprecated
	public long getCount();

}
