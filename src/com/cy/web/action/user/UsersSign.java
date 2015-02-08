package com.cy.web.action.user;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.user.Users;
import com.cy.service.user.UsersService;
import com.cy.utils.SysParam;
import com.cy.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户登录注册注销控制器
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class UsersSign extends BaseAction {

	@Resource
	private UsersService usersService;
	private Users users;
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login() {
		try {
			//验证码正确
			if(validateCode()) {
				Users user = usersService.login(users);
				if(user != null) {
					ActionContext.getContext().getSession().put("user",user);
					ActionContext.getContext().put("url", SysParam.read("backIndex"));
					return "redirect";
				} else {
					ActionContext.getContext().put("message", "用户名或密码错误");
				}
			} else {
				ActionContext.getContext().put("message", "验证码错误");
			}
		} catch (Exception e) {
			ActionContext.getContext().put("message", "用户名或密码错误");
		}
		return "error";
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
}
