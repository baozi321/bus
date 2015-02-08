package com.cy.web.action.bus;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.Paging;
import com.cy.bean.bus.Station;
import com.cy.service.bus.StationService;
import com.cy.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class StationAction extends BaseAction {

	@Resource
	private StationService stationService;
	/* 用来选择车站的 */
	private String type;
	
	/**
	 * 后台车站列表
	 * @return
	 */
	public String execute() {
		Paging<Station> paging = new Paging<>(getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
		orderby.put("id", "desc");
		paging.setQueryResult(stationService.getScrollData(paging.getfirstResult(),paging.getMaxResult(),orderby));
		ActionContext.getContext().put("paging", paging);
		if(!"select".equals(type)) {
			return "success";
		} else {
			return "select";
		}
	}
	
	/**
	 * 前台车站列表
	 * @return
	 */
	public String fore() {
		//所有公交站，按热度排序
		ActionContext.getContext().put("hotStations", stationService.searchStationsByHot());
		return "success";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}