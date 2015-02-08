package com.cy.web.action.fore;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.service.bus.BusLineService;
import com.cy.service.search.SearchService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 首页控制器
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class IndexAction {

	@Resource
	private BusLineService busLineService;
	@Resource
	private SearchService searchService;
	
	public String execute() {
		//所有的公交路线
		ActionContext.getContext().put("qr", busLineService.getScrollData());
		//热门公交站
		ActionContext.getContext().put("hotStations", searchService.searchHotStations());
		return "index";
	}
}
