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
 * 新闻列表控制器<br/>
 * 用于处理后台的新闻列表查询
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class NewsAction extends BaseAction {

	@Resource
	private NewsService newsService;

	/**
	 * 新闻列表
	 * @return
	 */
	public String execute() {
		// 分页
		Paging<News> paging = new Paging<>(getPage());
		// 用于存放排序的条件
		LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
		// 按照id降序排列
		orderby.put("id", "desc");
		// 将查询的结果放到分页类中
		paging.setQueryResult(newsService.getScrollData(paging.getfirstResult(),paging.getMaxResult(),orderby));
		// 将分页对象存放到request域对象中
		ActionContext.getContext().put("paging", paging);
		return "success";
	}
	
}
