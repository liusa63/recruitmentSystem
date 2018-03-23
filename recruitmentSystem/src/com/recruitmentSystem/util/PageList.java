package com.recruitmentSystem.util;

import java.util.List;
import java.util.Date;

public class PageList<T> {
	private List<T> list;
	private int currentPage; //当前页
	private int countPage;   //总页数
	private int totalNum;  //总条数
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	

}
