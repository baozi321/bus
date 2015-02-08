package com.cy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.cy.bean.user.Users;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsp = (HttpServletRequest)request;
		Users user = (Users) hsp.getSession().getAttribute("user");
		if(user != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("message", "请先登录");
			hsp.getRequestDispatcher("/WEB-INF/page/user/login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
