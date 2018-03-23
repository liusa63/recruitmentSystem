/**
 * 
 */
package com.recruitmentSystem.entity;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class News {
	private int nid;
	private String ntitle;
	private String ncontent;
	private Date ntimes;
	private String nimg;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNtimes() {
		return ntimes;
	}
	public void setNtimes(Date ntimes) {
		this.ntimes = ntimes;
	}
	public String getNimg() {
		return nimg;
	}
	public void setNimg(String nimg) {
		this.nimg = nimg;
	}
	
	

}
