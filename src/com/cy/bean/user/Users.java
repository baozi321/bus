package com.cy.bean.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Users {

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue
	private Integer users_id;

	/**
	 * 用户名
	 */
	@Column(length = 10, nullable = false, unique=true)
	private String username;

	/**
	 * 密码
	 */
	@Column(length = 32, nullable = false)
	private String password;

	/**
	 * 注册日期
	 */
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date user_time = new Date();
	
	public Users() {
		super();
	}

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Integer getUsers_id() {
		return users_id;
	}

	public void setUsers_id(Integer users_id) {
		this.users_id = users_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUser_time() {
		return user_time;
	}

	public void setUser_time(Date user_time) {
		this.user_time = user_time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((users_id == null) ? 0 : users_id.hashCode());
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
		Users other = (Users) obj;
		if (users_id == null) {
			if (other.users_id != null)
				return false;
		} else if (!users_id.equals(other.users_id))
			return false;
		return true;
	}

}
