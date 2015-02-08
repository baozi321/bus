package com.cy.service.bus;

import java.util.List;

import com.cy.bean.bus.BusLine;
import com.cy.service.base.DAO;

/**
 * 公交路线Service接口
 * @author CY
 *
 */
public interface BusLineService extends DAO<BusLine> {

	/**
	 * 通过公交路线名，获取公交路线
	 * @param name
	 * @return
	 */
	public List<BusLine> getBusLinesByName(String name);
	
}
