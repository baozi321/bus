package com.cy.web.action.news;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.news.News;
import com.cy.service.news.NewsService;
import com.cy.utils.SysParam;
import com.opensymphony.xwork2.ActionContext;

/**
 * 新闻管理控制器
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class NewsManageAction {

	@Resource
	private NewsService newsService;
	private News news;
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	/**
	 * 添加新闻
	 * @return
	 */
	public String add() {
		try {
			newsService.save(news);
			ActionContext.getContext().put("message", "新闻发布成功");
		} catch(Exception e) {
			ActionContext.getContext().put("message", "新闻发布失败");
			e.printStackTrace();
		}
		ActionContext.getContext().put("url", SysParam.read("addNewsUI"));
		return "dialog";
	}
	
}
