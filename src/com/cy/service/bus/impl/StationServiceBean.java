package com.cy.service.bus.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cy.bean.bus.Station;
import com.cy.service.base.DAOSupport;
import com.cy.service.bus.StationService;

/**
 * 车站Service接口实现类
 * @author CY
 *
 */
@Service
@Transactional
public class StationServiceBean extends DAOSupport<Station> implements StationService {

	@SuppressWarnings("rawtypes")
	@Override
	public List searchStationsByHot() {
		String sql = "select ls.stationid,s.name,count(ls.stationid)"
				+ " from line_station ls,station s"
				+ " where s.id = ls.stationid"
				+ " group by ls.stationid"
				+ " order by count(ls.stationid) desc";
		Query query = em.createNativeQuery(sql);
		return query.getResultList();
	}
	
}
