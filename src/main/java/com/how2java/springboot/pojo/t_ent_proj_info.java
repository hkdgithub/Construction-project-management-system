package com.how2java.springboot.pojo;

public class t_ent_proj_info {
	
	//工程编号
	public String prid;
	//工程名称
	public String qyid;
	//预算报价
	public int ysbj;
	//投标报价
	public int tbbj;
	//定额工期
	public int degq;
	//投标工期
	public int tbgq;
	//记录ID
	public int reid;
	
	
	//get 和 set
	public String getPrid() {
		return prid;
	}
	public void setPrid(String prid) {
		this.prid = prid;
	}
	public String getQyid() {
		return qyid;
	}
	public void setQyid(String qyid) {
		this.qyid = qyid;
	}
	public int getYsbj() {
		return ysbj;
	}
	public void setYsbj(int ysbj) {
		this.ysbj = ysbj;
	}
	public int getTbbj() {
		return tbbj;
	}
	public void setTbbj(int tbbj) {
		this.tbbj = tbbj;
	}
	public int getDegq() {
		return degq;
	}
	public void setDegq(int degq) {
		this.degq = degq;
	}
	public int getTbgq() {
		return tbgq;
	}
	public void setTbgq(int tbgq) {
		this.tbgq = tbgq;
	}
	public int getReid() {
		return reid;
	}
	public void setReid(int reid) {
		this.reid = reid;
	}

}
