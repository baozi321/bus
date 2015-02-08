package com.cy.web.action.search;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.service.search.SearchService;
import com.cy.service.search.impl.SearchServiceBean;
import com.cy.utils.SysParam;
import com.opensymphony.xwork2.ActionContext;

/**
 * 搜索
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class SearchAction {

	@Resource
	private SearchService searchService;
	/* 查询条件 */
	private String q;
	
	public String execute() {
		if(q != null && !"".equals(q)) {
			if(q.length() > 15) {
				q = q.substring(0,Integer.parseInt(SysParam.read("limitNum")));
				ActionContext.getContext().put("message", "查询条件不能大于"+SysParam.read("limitNum")+"个字符,已经自动截取");
			}
			String[] query = new String[2];
			// 公交路线查询
			if((query[0] = SearchServiceBean.isLine(q)) != null) {
				ActionContext.getContext().put("buslines", searchService.searchBusLines(query[0]));
			} else if ((query = SearchServiceBean.isTransfer(q)) != null) {// 公交换乘查询
				@SuppressWarnings("rawtypes")
				Collection result = null;
				if(!(result = searchService.searchTransfer(query)).isEmpty()) {
					ActionContext.getContext().put("message", "亲，只需要乘坐以下的公交车即可到达目的地！");
					ActionContext.getContext().put("mark", 1);
				} else if (!(result = searchService.searchTransfer2(query)).isEmpty()) {
					ActionContext.getContext().put("message", "亲，需要换乘公交即可到达目的地！");
					ActionContext.getContext().put("mark", 2);
				} else {
					ActionContext.getContext().put("message", "没有查询到对应的公交路线！");
					ActionContext.getContext().put("mark", 0);
				}
				ActionContext.getContext().put("result", result);
			} else { // 公交车站查询
				ActionContext.getContext().put("stations", searchService.searchStations(q));
			}
		} else {
			ActionContext.getContext().put("message", "查询条件不能为空");
		}
		return "result";
	}
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		// 处理中文乱码
		String temp = null;
		try {
			temp = new String(q.trim().getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		this.q = temp;
	}
	
}
