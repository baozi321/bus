package com.cy.service.user.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cy.bean.user.Users;
import com.cy.service.base.DAOSupport;
import com.cy.service.user.UsersService;
import com.cy.utils.MD5;

/**
 * Users接口实现类
 * @author CY
 *
 */
@Service
@Transactional
public class UsersServiceBean extends DAOSupport<Users> implements UsersService {

	@Override
	public Users login(Users users) {
		String jql = "select o from Users o where o.username = ?1";
		Query query = em.createQuery(jql);
		query.setParameter(1, users.getUsername());
		Users user = (Users) query.getSingleResult();
		if(user != null && user.getPassword().equals(MD5.MD5Encode(users.getPassword()))) {
			return user;
		}
		return null;
	}

}
