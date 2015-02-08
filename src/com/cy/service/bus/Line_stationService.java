package com.cy.service.bus;

import java.util.List;

import com.cy.bean.bus.Line_Station;
import com.cy.service.base.DAO;

/**
 * Bus_stationService接口
 * @author CY
 *
 */
public interface Line_stationService extends DAO<Line_Station> {

	/**
	 * 通过公交路线id来查找
	 * @param entityID 公交路线id
	 * @return
	 */
	public List<Line_Station> findByBusLineId(Integer busLineId);
	
}
