package com.cy.web.action.news;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.Paging;
import com.cy.bean.news.News;
import com.cy.service.news.NewsService;
import com.cy.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 前台新闻控制器
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class ForeNewsAction extends BaseAction {

	@Resource
	private NewsService newsService;

	/**
	 * 新闻列表
	 * @return
	 */
	public String list() {
		// 分页
		Paging<News> paging = new Paging<>(getPage());
		// 用于存放排序的条件
		LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
		// 按照id降序排列
		orderby.put("id", "desc");
		// 查询条件where，查询允许显示的新闻
		String where = "o.news_visible=?1";
		Object[] params = {true};
		// 将查询的结果放到分页类中
		paging.setQueryResult(newsService.getScrollData(paging.getfirstResult(), paging.getMaxResult(), where, params, orderby));
		// 将分页对象存放到request域对象中
		ActionContext.getContext().put("paging", paging);
		return "list";
	}
	
	/**
	 * 查看一条新闻
	 * @return
	 */
	public String detail() {
		News news = newsService.find(getId());
		ActionContext.getContext().put("news", news);
		return "detail";
	}
	
}
