package org.j2eeframework.commons.pager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pager<T> {
	private int pageNumLength = 5;// 页面显示可见页码的长度(上一页,1,2,3,4……10,下一页)
	private int pageNo = 1;// 当前页面
	private int countOfTotalItem;// 记录总数
	private int pageSize = 10;// 一页显示记录条数
	private ParamCondition paramCondition = new ParamCondition();// 参数包装类
	private List<T> items;// 查询结果集

	/**
	 * 将Request的参数转化成自己的包装类
	 * 
	 * @param requestParameter
	 * @author william
	 */
	public void putAllParameter(Map<String, String[]> requestParameter) {
		paramCondition.putAll(requestParameter);
	}

	/**
	 * 取得参数包装类
	 * 
	 * @return
	 * @author william
	 */
	public ParamCondition getParamCondition() {
		return paramCondition;
	}

	public List<Integer> getPageNoList() {
		List<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= getCountOfPager(); i++) {
			arr.add(i);
		}
		return arr;

	}

	/**
	 * 查询结果总页数
	 * 
	 * @return
	 */
	public int getCountOfPager() {
		int maxPageNum = countOfTotalItem / pageSize;
		int m = countOfTotalItem % pageSize;
		if (m != 0) {
			maxPageNum++;
		}
		return maxPageNum;
	}

	/**
	 * 用于分页查询指明查询起始点
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return pageSize * (pageNo - 1);
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public int getPageNumLength() {
		return pageNumLength;
	}

	public void setPageNumLength(int pageNumLength) {
		this.pageNumLength = pageNumLength;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getCountOfTotalItem() {
		return countOfTotalItem;
	}

	public void setCountOfTotalItem(int countOfTotalItem) {
		this.countOfTotalItem = countOfTotalItem;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
