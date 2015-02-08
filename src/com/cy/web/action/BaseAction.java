package com.cy.web.action;

import com.opensymphony.xwork2.ActionContext;

/**
 * 基本的Action
 * @author CY
 *
 */
public class BaseAction {

	/* 当前页 */
	private Integer page;
	/* id */
	private Integer id;
	/* id集合 */
	private Integer[] ids;
	/* 验证码 */
	private String validateCode;
	
	/**
	 * 判断验证码是否正确
	 * @return
	 */
	public boolean validateCode() {
		if(validateCode != null && validateCode.toUpperCase().equals(((String)ActionContext.getContext().getSession().get("validateCode")).toUpperCase())) {
			return true;
		}
		return false;
	}
	
	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public Integer getPage() {
		if(page == null || page <= 0) {
			page = 1;
			return 1;
		} else {
			return page;
		}
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
}
