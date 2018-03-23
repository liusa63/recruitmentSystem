/**
 * 
 */
package com.recruitmentSystem.entity;

/**
 * @author Administrator
 *
 */
public class Experience {
	private int eid;
	private int rid;//简历主键
	private String ecompany;//任职公司
	private String etimes;//任职时间
	private String epost;//任职岗位
	private String edes;//描述
	
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getEcompany() {
		return ecompany;
	}
	public void setEcompany(String ecompany) {
		this.ecompany = ecompany;
	}
	public String getEtimes() {
		return etimes;
	}
	public void setEtimes(String etimes) {
		this.etimes = etimes;
	}
	public String getEpost() {
		return epost;
	}
	public void setEpost(String epost) {
		this.epost = epost;
	}
	public String getEdes() {
		return edes;
	}
	public void setEdes(String edes) {
		this.edes = edes;
	}

	

	

}
