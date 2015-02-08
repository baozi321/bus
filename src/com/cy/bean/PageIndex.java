package com.cy.bean;

/**
 * 分页导航
 * @author CY
 *
 */
public class PageIndex {

	/** 开始 **/
	private int startIndex;
	/** 结束 **/
	private int endIndex;

	/**
	 * 该对象通过getPageIndex方法来创建
	 * 
	 * @param startindex
	 *            索引的开始值
	 * @param endindex
	 *            索引的结束值
	 */
	public PageIndex(int startindex, int endindex) {
		this.startIndex = startindex;
		this.endIndex = endindex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	/**
	 * 返回一个PageIndex
	 * 
	 * @param indexLength
	 *            索引的长度 ，要大于0，没有做容错处理
	 * @param currentIndex
	 *            当前第几页,要小于totalIndex,没有做容错处理
	 * @param totalIndex
	 *            共多少页
	 * @return
	 */
	public static PageIndex getPageIndex(int indexLength, int currentIndex,
			int totalIndex) {
		// 起始索引=当前页面-索引长度的/2
		int startIndex = currentIndex - indexLength / 2;
		// 结束索引=起始索引+索引长度-1
		int endIndex = startIndex + indexLength - 1;
		// 起始索引必须>=1
		if (startIndex < 1) {
			startIndex = 1;
			if (totalIndex >= indexLength)
				endIndex = indexLength;
			else
				endIndex = totalIndex;
		}
		// 结束索引必须<=总索索引
		else if (endIndex > totalIndex) {
			endIndex = totalIndex;
			if (totalIndex >= indexLength)
				startIndex = endIndex - indexLength + 1;
			else
				startIndex = 1;
		}
		return new PageIndex(startIndex, endIndex);
	}

}
