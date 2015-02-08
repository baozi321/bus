package com.cy.service.bus;

import java.util.List;

import com.cy.bean.bus.Station;
import com.cy.service.base.DAO;

/**
 * 车站Service接口
 * @author CY
 *
 */
public interface StationService extends DAO<Station> {

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
	@SuppressWarnings("rawtypes")
	public List searchStationsByHot();
}
