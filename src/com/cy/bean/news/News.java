package com.cy.bean.news;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 新闻实体
 * 
 * @author CY
 * 
 */
@Entity
public class News implements Serializable {

	private static final long serialVersionUID = 6297004091924691749L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private Integer news_id;

	/**
	 * 新闻标题
	 */
	@Column(length = 50, nullable = false)
	private String news_title;

	/**
	 * 新闻发布时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date news_time = new Date();

	/**
	 * 新闻作者
	 */
	@Column(length = 10, nullable = false)
	private String news_author = "佚名";

	/**
	 * 是否显示
	 */
	@Column(nullable = false)
	private Boolean news_visible = false;

	/**
	 * 新闻内容
	 */
	@Lob
	@Column(nullable=false)
	private String news_content;

	public Integer getNews_id() {
		return news_id;
	}

	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}

	public String getNews_title() {
		return news_title;
	}

	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}

	public Date getNews_time() {
		return news_time;
	}

	public void setNews_time(Date news_time) {
		this.news_time = news_time;
	}

	public String getNews_author() {
		return news_author;
	}

	public void setNews_author(String news_author) {
		this.news_author = news_author;
	}

	public Boolean getNews_visible() {
		return news_visible;
	}

	public void setNews_visible(Boolean news_visible) {
		this.news_visible = news_visible;
	}

	public String getNews_content() {
		return news_content;
	}

	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((news_id == null) ? 0 : news_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (news_id == null) {
			if (other.news_id != null)
				return false;
		} else if (!news_id.equals(other.news_id))
			return false;
		return true;
	}

}
