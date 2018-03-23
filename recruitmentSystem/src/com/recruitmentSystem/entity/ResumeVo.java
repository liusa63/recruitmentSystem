/**
 * 
 */
package com.recruitmentSystem.entity;

/**
 * @author Administrator
 *
 */
public class ResumeVo {
	private int rid;//简历主键
	private int uid;//用户主键
	private String rname;//姓名
	private String rpic;//照片
	private String rage;//年龄
	private String rsex;//性别
	private String rphone;//手机号
	private String remail;//邮箱
	private String reducation;//学历
	private String rwant;//求职意向
	private String rup;//简历更新时间
	private Integer dstatus;//简历状态
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRpic() {
		return rpic;
	}
	public void setRpic(String rpic) {
		this.rpic = rpic;
	}
	public String getRage() {
		return rage;
	}
	public void setRage(String rage) {
		this.rage = rage;
	}
	public String getRsex() {
		return rsex;
	}
	public void setRsex(String rsex) {
		this.rsex = rsex;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public String getReducation() {
		return reducation;
	}
	public void setReducation(String reducation) {
		this.reducation = reducation;
	}
	public String getRwant() {
		return rwant;
	}
	public void setRwant(String rwant) {
		this.rwant = rwant;
	}
	public String getRup() {
		return rup;
	}
	public void setRup(String rup) {
		this.rup = rup;
	}

	public Integer getDstatus() {
		return dstatus;
	}
	public void setDstatus(Integer dstatus) {
		this.dstatus = dstatus;
	}
	
	

}
