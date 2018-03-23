/**
 * 
 */
package com.recruitmentSystem.entity;

import java.sql.Date;

/**
 * @author Administrator
 *
 */
public class Relation {
	private int pid;//岗位主键
	private int cid;// 企业主键
	private String rpost;// 岗位
	private String rask;// 要求
	private double rsalary;// 薪资
	private Date rtimes;// 时间
	
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getRpost() {
		return rpost;
	}
	public void setRpost(String rpost) {
		this.rpost = rpost;
	}
	public String getRask() {
		return rask;
	}
	public void setRask(String rask) {
		this.rask = rask;
	}
	public double getRsalary() {
		return rsalary;
	}
	public void setRsalary(double rsalary) {
		this.rsalary = rsalary;
	}
	public Date getRtimes() {
		return rtimes;
	}
	public void setRtimes(Date rtimes) {
		this.rtimes = rtimes;
	}
	
	

}
