package com.cy.web.action.bus;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.bus.BusLine;
import com.cy.service.bus.BusLineService;
import com.cy.utils.SysParam;
import com.cy.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 公交路线管理控制器
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class BusLineManageAction extends BaseAction {

	
	@Resource
	private BusLineService busLineService;
	private BusLine busLine;
	
	/**
	 * 添加公交路线
	 */
	public String add() {
		try {
			busLineService.save(busLine);
			ActionContext.getContext().put("message", "公交路线添加成功");
		} catch(Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("message", "公交路线添加失败");
		}
		ActionContext.getContext().put("url", SysParam.read("addBusLineUI"));
		return "message";
	}
	
	/**
	 * 删除公交路线
	 */
	public String del() {
		if(getIds() != null && getIds().length>0) {
			busLineService.delete((Serializable[])getIds());
			ActionContext.getContext().put("message", "公交路线删除成功");
		} else {
			ActionContext.getContext().put("message", "请选择要删除的公交路线");
		}
		ActionContext.getContext().put("url", SysParam.read("busLineList"));
		return "message";
	}

	public BusLine getBusLine() {
		return busLine;
	}

	public void setBusLine(BusLine busLine) {
		this.busLine = busLine;
	}
	
}
