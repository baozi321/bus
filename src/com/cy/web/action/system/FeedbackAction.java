package com.cy.web.action.system;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.system.Feedback;
import com.cy.service.system.FeedbackService;
import com.cy.utils.SysParam;
import com.cy.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 反馈控制器
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class FeedbackAction extends BaseAction {

	@Resource
	private FeedbackService feedbackService;
	private Feedback feedback;

	/**
	 * 反馈
	 * 
	 * @return
	 */
	public String add() {
		try {
			//判断验证码
			if(validateCode()) {
				feedbackService.save(feedback);
				ActionContext.getContext().put("message", "反馈成功！");
			} else {
				ActionContext.getContext().put("message", "验证码错误！");
			}
		} catch(Exception e) {
			ActionContext.getContext().put("message", "反馈失败！");
		}
		ActionContext.getContext().put("url", SysParam.read("feedback"));
		return "dialog";
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

}
