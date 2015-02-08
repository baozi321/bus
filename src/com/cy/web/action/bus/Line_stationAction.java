package com.cy.web.action.bus;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.bus.BusLine;
import com.cy.bean.bus.Line_Station;
import com.cy.service.bus.BusLineService;
import com.cy.service.bus.Line_stationService;
import com.cy.utils.SysParam;
import com.opensymphony.xwork2.ActionContext;

/**
 * 公交路线的站点列表
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class Line_stationAction {

	@Resource
	private Line_stationService line_stationService;
	@Resource
	private BusLineService busLineService;
	/* 公交路线id */
	private Integer busLineId;
	
	public String execute() {
		BusLine busLine = busLineService.find(busLineId);
		if(busLine != null) {
			ActionContext.getContext().put("busLine", busLine);
			List<Line_Station> bus_Stations = line_stationService.findByBusLineId(busLineId);
			ActionContext.getContext().put("line_Stations", bus_Stations);
			return "success";
		} else {
			ActionContext.getContext().put("message", "请选择正确的公交路线");
			ActionContext.getContext().put("url", SysParam.read("busLineList"));
			return "message";
		}
	}
	
	public Integer getBusLineId() {
		return busLineId;
	}
	
	public void setBusLineId(Integer busLineId) {
		this.busLineId = busLineId;
	}
	
}
