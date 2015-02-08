package com.cy.service.base;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.cy.bean.QueryResult;

/**
 * 实体操作通用接口
 * 
 * @author CY
 * 
 * @param <T>
 */
public interface DAO<T> {
	
	/**
	 * 设置实体的visible属性<br/>
	 * 前提是你的实体中有visible属性
	 * 
	 * @param booleanFiled boolean值字段
	 * @param state 属性值
	 * @param entityIDName 主键名 
	 * @param entityID 实体的主键
	 */
	public void setBooleanFiled(String booleanFiled, boolean state, String entityIDName,
			Serializable... entityID);

	/**
	 * 获取所有记录
	 * 
	 * @return
	 */
	public QueryResult<T> getScrollData();

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引 ，如果输入值为-1，即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数，如果输入值为-1，即获取全部数据
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引 ，如果输入值为-1，即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数，如果输入值为-1，即获取全部数据
	 * @param orderby
	 *            排序，key为排序属性，value为asc/desc。如： LinkedHashMap<String, String>
	 *            orderby = new LinkedHashMap<String, String>();
	 *            orderby.put("username", "asc");
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			LinkedHashMap<String, String> orderby);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引 ，如果输入值为-1，即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数，如果输入值为-1，即获取全部数据
	 * @param where
	 *            条件语句，不带where关键字，条件语句只能使用位置参数，位置参数的索引值以1开始，如：o.username=?1 and
	 *            o.password=?2
	 * @param params
	 *            条件语句出现的位置参数值
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			String where, Object[] params);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引 ，如果输入值为-1，即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数，如果输入值为-1，即获取全部数据
	 * @param where
	 *            条件语句，不带where关键字，条件语句只能使用位置参数，位置参数的索引值以1开始，如：o.username=?1 and
	 *            o.password=?2
	 * @param params
	 *            条件语句出现的位置参数值
	 * @param orderby
	 *            排序，key为排序属性，value为asc/desc。如： LinkedHashMap<String, String>
	 *            orderby = new LinkedHashMap<String, String>();
	 *            orderby.put("username", "asc");
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			String where, Object[] params, LinkedHashMap<String, String> orderby);

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体对象
	 */
	public void save(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 *            实体对象
	 */
	public void update(T entity);

	/**
	 * 删除实体
	 * 
	 * @param entityID
	 *            实体标识
	 */
	public void delete(Serializable... entityID);

	/**
	 * 获取实体<br/>
	 * 同jpa的EntityManager的find方法
	 * @param entityID
	 *            实体标识
	 * @return 实体对象
	 */
	public T find(Serializable entityID);
	
	/**
	 * 获取实体<br/>
	 * 同jpa的EntityManager的getReference方法
	 * @param entityID
	 *            实体标识
	 * @return 实体对象
	 */
	public T getReference(Serializable entityID);

	/**
	 * 获取实体数
	 * 
	 * @return 实体个数
	 */
	public long getCount();

}
