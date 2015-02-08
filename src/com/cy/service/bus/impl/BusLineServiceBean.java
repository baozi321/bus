package com.cy.service.bus.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cy.bean.bus.BusLine;
import com.cy.service.base.DAOSupport;
import com.cy.service.bus.BusLineService;

/**
 * 公交路线Service接口实现类
 * @author CY
 *
 */
@Service
@Transactional
public class BusLineServiceBean extends DAOSupport<BusLine> implements BusLineService {

	@SuppressWarnings("unchecked")
	@Override
	public List<BusLine> getBusLinesByName(String name) {
		String jql = "select o from BusLine o where o.name like ?1 ";
		Query query = em.createQuery(jql);
		query.setParameter(1, "%"+name+"%");
		return query.getResultList();
	}

}
