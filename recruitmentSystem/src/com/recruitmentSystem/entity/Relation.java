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
	private int pid;//��λ����
	private int cid;// ��ҵ����
	private String rpost;// ��λ
	private String rask;// Ҫ��
	private double rsalary;// н��
	private Date rtimes;// ʱ��
	
	
	
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
