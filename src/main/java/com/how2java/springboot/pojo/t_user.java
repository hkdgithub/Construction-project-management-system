package com.how2java.springboot.pojo;

public class t_user {
    //用户编号
	// int id;
	//用户密码
	public String pwd;
	//部门名称
	public String name;
	//部门
	public String dept;
	
	//get 和 set 方法
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}*/
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
