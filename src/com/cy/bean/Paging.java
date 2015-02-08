package com.cy.bean;

import java.util.List;

import com.cy.utils.SysParam;

/**
 * 分页
 * @author CY
 *
 * @param <T>
 */
public class Paging<T> {

	/** 分页数据 **/
	private List<T> records;
	/** 总记录数 **/
	private long totalRecord;
	/** 当前页，创建对象时传入 **/
	private int currentPage;
	/** 每页显示记录数，创建对象时传入 **/
	private int maxResult = Integer.parseInt(SysParam.read("maxResult"));
	/** 总页数，计算得出(totalrecord-1)/maxresult +1 **/
	private int totalPage;
	/** 索引长度，创建对象时传入 **/
	private int indexLength =  Integer.parseInt(SysParam.read("indexLength"));
	/** 页码开始索引和结束索引,会自动生成 **/
	private PageIndex pageIndex;
	
	/**
	 * 构造函数<br/>
	 * 其它参数选择配置文件设置的参数
	 * @param currentPage 当前页
	 */
	public Paging(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 构造函数
	 * 
	 * @param currentPage
	 *            当前第几页
	 * @param maxResult
	 *            每页显示几条记录
	 */
	public Paging(int currentPage, int maxResult, int indexLength) {
		this.currentPage = currentPage;
		this.maxResult = maxResult;
		this.indexLength = indexLength;
	}

	/**
	 * 计算出 firstResult
	 * 
	 * @return
	 */
	public int getfirstResult() {
		return (currentPage - 1) * maxResult;
	}
	
	/**
	 * 设置查询结果集
	 * @param qr
	 */
	public void setQueryResult(QueryResult<T> qr) {
		this.setRecords(qr.getResultList());
		this.setTotalRecord(qr.getTotalRecord());
		this.totalPage = (int) ((totalRecord - 1) / maxResult + 1);
		this.pageIndex = PageIndex.getPageIndex(indexLength, currentPage, totalPage);
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public PageIndex getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(PageIndex pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getIndexLength() {
		return indexLength;
	}

	public void setIndexLength(int indexLength) {
		this.indexLength = indexLength;
	}

}
