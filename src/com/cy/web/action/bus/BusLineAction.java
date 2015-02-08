package com.cy.web.action.bus;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.Paging;
import com.cy.bean.bus.BusLine;
import com.cy.service.bus.BusLineService;
import com.cy.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class BusLineAction extends BaseAction {

	@Resource
	private BusLineService busLineService;
	
	/**
	 * 后台公交列表
	 * @return
	 */
	public String execute() {
		Paging<BusLine> paging = new Paging<>(getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
		orderby.put("id", "desc");
		paging.setQueryResult(busLineService.getScrollData(paging.getfirstResult(),paging.getMaxResult(),orderby));
		ActionContext.getContext().put("paging", paging);
		return "success";
	}
	
	/**
	 * 前台公交列表
	 * @return
	 */
	public String fore() {
		//所有的公交路线
		ActionContext.getContext().put("qr", busLineService.getScrollData());
		return "success";
	}
}
