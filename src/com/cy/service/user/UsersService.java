package com.cy.service.user;

import com.cy.bean.user.Users;
import com.cy.service.base.DAO;

/**
 * UsersService接口
 * @author CY
 *
 */
public interface UsersService extends DAO<Users> {

	/**
	 * 登录验证
	 * @param users
	 * @return
	 */
	public Users login(Users users);
}
