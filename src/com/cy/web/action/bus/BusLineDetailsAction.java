package com.cy.web.action.bus;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.service.bus.BusLineService;
import com.cy.service.bus.Line_stationService;
import com.cy.utils.SysParam;
import com.opensymphony.xwork2.ActionContext;

/**
 * 公交路线详细信息
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class BusLineDetailsAction {

	@Resource
	private BusLineService busLineService;
	@Resource
	private Line_stationService line_stationService;
	/* 路线id */
	private Integer busline;
	
	public String execute() {
		if(busline != null && busline > 0) {
			//某条公交线路的详细信息
			ActionContext.getContext().put("busLine", busLineService.find(busline));
			//所有的公交线路
			ActionContext.getContext().put("qr", busLineService.getScrollData());
			return "details";
		} else {
			ActionContext.getContext().put("url", SysParam.read("index"));
			ActionContext.getContext().put("message", "该路线不存在");
			return "message";
		}
	}
	
	public Integer getBusline() {
		return busline;
	}

	public void setBusline(Integer busline) {
		this.busline = busline;
	}
	
}
