package com.cy.service.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.bean.QueryResult;
import com.cy.utils.GenericsUtils;

/**
 * DAO 接口实现类
 * @author CY
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
@Transactional
public abstract class DAOSupport<T> implements DAO<T> {

	/* 实体类 */
	protected Class<T> entityClass = GenericsUtils
			.getSuperClassGenricType(getClass());
	@PersistenceContext
	protected EntityManager em;

	@Override
	public void setBooleanFiled(String booleanFiled, boolean state, String entityIDName,
			Serializable... entityID) {
		if (entityID != null && entityID.length > 0) {
			Query query = em.createQuery("update " + getEntityName(entityClass)
					+ " o set o." + booleanFiled + " = ?1 where " + entityIDName + " in ("
					+ getParameterString(2, entityID.length) + ")");
			query.setParameter(1, state);
			setQueryParameter(entityID, query, 2);
			query.executeUpdate();
		}
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData() {
		return getScrollData(-1, -1, null, null, null);
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstResult, int maxResult) {
		return getScrollData(firstResult, maxResult, null, null, null);
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			LinkedHashMap<String, String> orderby) {
		return getScrollData(firstResult, maxResult, null, null, orderby);
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			String where, Object[] params) {
		return getScrollData(firstResult, maxResult, where, params, null);
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			String where, Object[] params, LinkedHashMap<String, String> orderby) {
		String entityName = getEntityName(entityClass);
		String whereql = where != null && !where.trim().equals("") ? " where "
				+ where : "";
		Query query = em.createQuery("select o from " + entityName + " o "
				+ whereql + buildOrderBy(orderby));
		if (firstResult != -1 && maxResult != -1)
			query.setFirstResult(firstResult).setMaxResults(maxResult);
		setQueryParameter(params, query, 1);
		QueryResult<T> qr = new QueryResult<T>();
		qr.setResultList(query.getResultList());
		query = em.createQuery("select count(o) from " + entityName + " o "
				+ whereql);
		setQueryParameter(params, query, 1);
		qr.setTotalRecord((long) query.getSingleResult());
		return qr;
	}

	/**
	 * 得到类似于?1,?2,?3...这样的字符串
	 * @param start ?start ?start+1...
	 * @param entityID 
	 * @return ?start ?start+1...
	 */
	protected static String getParameterString(int start, int length) {
		StringBuilder whereql = new StringBuilder();
		for(int i = 0; i < length; i++){
			whereql.append("?").append((i+start)).append(',');
		}
		whereql.deleteCharAt(whereql.length()-1);
		return whereql.toString();
	}
	
	/**
	 * 设置查询参数
	 * 
	 * @param params
	 *            参数值
	 * @param query
	 *            查询对象
	 * @param start
	 * 			  从第几个开始设置
	 */
	protected static void setQueryParameter(Object[] params, Query query, int start) {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + start, params[i]);
			}
		}
	}

	/**
	 * 构建排序语句
	 * 
	 * @param orderby
	 *            排序属性与asc/desc,Key为属性，Value为acs/desc
	 * @return
	 */
	private static String buildOrderBy(LinkedHashMap<String, String> orderby) {
		StringBuilder sb = new StringBuilder();
		if (orderby != null && !orderby.isEmpty()) {
			sb.append(" order by ");
			for (Map.Entry<String, String> entry : orderby.entrySet()) {
				sb.append("o.").append(entry.getKey()).append(" ")
						.append(entry.getValue()).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	@Override
	public void save(T entity) {
		em.persist(entity);
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Serializable... entityID) {
		for (Serializable id : entityID)
			em.remove(em.getReference(entityClass, id));
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public T find(Serializable entityID) {
		return em.find(entityClass, entityID);
	}
	
	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public T getReference(Serializable entityID) {
		return em.getReference(entityClass, entityID);
	}
	
	/**
	 * 获取实体类名
	 * 
	 * @return
	 */
	protected static <E> String getEntityName(Class<E> clazz) {
		Entity entity = clazz.getAnnotation(Entity.class);
		if (entity.name() != null && !"".equals(entity.name())) {
			return entity.name();
		} else {
			return clazz.getSimpleName();
		}
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public long getCount() {
		return (long) em.createQuery(
				"select count(o) from " + getEntityName(entityClass) + " o")
				.getSingleResult();
	}

}
