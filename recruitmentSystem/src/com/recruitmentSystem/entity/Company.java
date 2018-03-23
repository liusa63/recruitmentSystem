/**
 * 
 */
package com.recruitmentSystem.entity;

/**
 * @author Administrator
 *
 */
public class Company {
	private int cid;
	private int uid;
	private String cname;
	private String caddress;
	private String cintroduce;
	private String cphone;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCintroduce() {
		return cintroduce;
	}
	public void setCintroduce(String cintroduce) {
		this.cintroduce = cintroduce;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

}
