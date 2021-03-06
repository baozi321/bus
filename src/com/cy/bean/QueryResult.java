package com.cy.bean;

import java.util.List;

/**
 * 查询结果
 * 
 * @author CY
 * 
 * @param <T>
 */
public class QueryResult<T> {

	/* 结果集 */
	private List<T> resultList;
	/* 总� 录数 */
	private long totalRecord;

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

}
