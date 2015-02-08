package com.cy.web.action.bus;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.bus.Station;
import com.cy.service.bus.StationService;
import com.cy.utils.SysParam;
import com.cy.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 车站管理控制器
 * 
 * @author CY
 * 
 */
@Controller
@Scope("prototype")
public class StationManageAction extends BaseAction {

	@Resource
	private StationService stationService;
	/* 车站名 */
	private String name;

	/**
	 * 添加车站
	 * @return
	 */
	public String add() {
		stationService.save(new Station(name));
		ActionContext.getContext().put("url", SysParam.read("addStationUI"));
		ActionContext.getContext().put("message", "车站添加成功");
		return "message";
	}
	
	/**
	 * 删除车站
	 * @return
	 */
	public String del() {
		if(getIds() != null && getIds().length > 0) {
			stationService.delete((Serializable[])getIds());
			ActionContext.getContext().put("message", "车站删除成功");
		} else {
			ActionContext.getContext().put("message", "请选择要删除的车站");
		}
		ActionContext.getContext().put("url", SysParam.read("stationList"));
		return "message";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

}
