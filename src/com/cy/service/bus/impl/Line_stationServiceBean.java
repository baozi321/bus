package com.cy.service.bus.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cy.bean.bus.Line_Station;
import com.cy.service.base.DAOSupport;
import com.cy.service.bus.Line_stationService;

/**
 * Bus_stationService接口实现类
 * @author CY
 *
 */
@Service
@Transactional
public class Line_stationServiceBean extends DAOSupport<Line_Station> implements Line_stationService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Line_Station> findByBusLineId(Integer busLineId) {
		Query query = em.createQuery("select o from Line_Station o where o.busLine.id = ?1");
		query.setParameter(1, busLineId);
		return query.getResultList();
	}
}
