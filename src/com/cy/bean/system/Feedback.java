package com.cy.bean.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 反馈实体
 * 
 * @author CY
 * 
 */
@Entity
public class Feedback implements Serializable {

	private static final long serialVersionUID = -1421011281218955057L;

	/**
	 * 反馈id
	 */
	@Id
	@GeneratedValue
	private Integer feedback_id;

	/**
	 * 反馈者的名字
	 */
	@Column(nullable = false, length = 10)
	private String feedback_name;

	/**
	 * 反馈者的email
	 */
	@Column(nullable = false, length = 20)
	private String feedback_email;

	/**
	 * 反馈者的电话
	 */
	@Column(nullable = false, length = 11)
	private String feedback_tel;

	/**
	 * 反馈的内容
	 */
	@Column(nullable = false, length = 200)
	private String feedback_content;

	/**
	 * 反馈的时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date feedback_time = new Date();

	/**
	 * 是否审核该反馈
	 */
	@Column(nullable = false)
	private Boolean feedback_check = false;

	public Integer getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(Integer feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getFeedback_name() {
		return feedback_name;
	}

	public void setFeedback_name(String feedback_name) {
		this.feedback_name = feedback_name;
	}

	public String getFeedback_email() {
		return feedback_email;
	}

	public void setFeedback_email(String feedback_email) {
		this.feedback_email = feedback_email;
	}

	public String getFeedback_tel() {
		return feedback_tel;
	}

	public void setFeedback_tel(String feedback_tel) {
		this.feedback_tel = feedback_tel;
	}

	public String getFeedback_content() {
		return feedback_content;
	}

	public void setFeedback_content(String feedback_content) {
		this.feedback_content = feedback_content;
	}

	public Date getFeedback_time() {
		return feedback_time;
	}

	public void setFeedback_time(Date feedback_time) {
		this.feedback_time = feedback_time;
	}

	public Boolean getFeedback_check() {
		return feedback_check;
	}

	public void setFeedback_check(Boolean feedback_check) {
		this.feedback_check = feedback_check;
	}

}
