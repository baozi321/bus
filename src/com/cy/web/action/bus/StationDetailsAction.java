package com.cy.web.action.bus;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.service.bus.StationService;
import com.cy.utils.SysParam;
import com.opensymphony.xwork2.ActionContext;

/**
 * 公交站相信信息
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class StationDetailsAction {

	@Resource
	private StationService stationService;
	/* 公交站点id */
	private Integer stationId;
	
	public String execute() {
		if(stationId != null && stationId > 0) {
			ActionContext.getContext().put("station", stationService.find(stationId));
			return "details";
		} else {
			ActionContext.getContext().put("url", SysParam.read("index"));
			ActionContext.getContext().put("message","该公交站不存在");
			return "message";
		}
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	
}
