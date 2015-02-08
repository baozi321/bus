package com.cy.web.action.bus;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.bus.Line_Station;
import com.cy.service.bus.Line_stationService;
import com.cy.utils.SysParam;
import com.opensymphony.xwork2.ActionContext;

/**
 * 公交路线对应的公交站控制器
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class Line_stationManageAction {

	@Resource
	private Line_stationService line_stationService;
	private Integer busLineId;
	private Integer stationId;
	private Integer num;
	private String direction;
	
	/**
	 * 添加公交路线对应的公交站点
	 * @return
	 */
	public String add() {
		try {
			Line_Station bus_Station = new Line_Station(busLineId, stationId, num);
			line_stationService.save(bus_Station);
			ActionContext.getContext().put("message", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("message", "添加失败");
		}
		ActionContext.getContext().put("url", SysParam.read("bus_stationList")+"?busLineId="+busLineId);
		return "message";
	}

	public Integer getBusLineId() {
		return busLineId;
	}

	public void setBusLineId(Integer busLineId) {
		this.busLineId = busLineId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
