package com.how2java.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.projectManageMapper;
import com.how2java.springboot.pojo.t_proj_info;
import com.how2java.springboot.pojo.t_user;

@Controller
public class projectManageController {

	@Autowired 
	private projectManageMapper pmc;
//...................................工程管理界面的增删改查....................................	
	
	//工程添加
	@RequestMapping(value="/projectAdd")
	public String projectAdd(@RequestParam("projectId") String prid,@RequestParam("projectName") String prmc,@RequestParam("applicantUnit") String sqdw,
			@RequestParam("natureOfOwnership") String ssxz,@RequestParam("unitPhone") String phone,@RequestParam("projectState") String przt ) {
		
		System.out.println("开始添加工程"+prmc);
		
		pmc.add(prid, prmc, sqdw, ssxz, phone, przt);
		
		System.out.println("添加工程"+prmc+"完成");
		
		return "projectManageAdd";
	}
	
	//工程删除
	@RequestMapping(value="/projectDelete")
	public String projectDelete(@RequestParam("projectId") String prid) {
		
		System.out.println("开始删除工程"+prid);
		
		pmc.modify(prid);
		
		System.out.println("删除工程"+prid+"完成");
		
		return "projectManageDelete";
	}
	
	//工程修改
	@RequestMapping(value="/projectUpdate")
	public String projectUpdate(@RequestParam("projectName") String prmc,@RequestParam("applicantUnit") String sqdw,
			@RequestParam("natureOfOwnership") String ssxz,@RequestParam("unitPhone") String phone,@RequestParam("projectState") String przt,@RequestParam("projectId") String prid ) {
		
		System.out.println("开始修改工程"+prid);
		
		pmc.remove( prmc, sqdw, ssxz, phone, przt,prid);
		
		System.out.println("修改工程"+prid+"完成");
		
		return "projectManageUpdate";
	}
	
	//工程查询
	@RequestMapping(value="/projectQuery")
	public String userManageQuery(Model m,@RequestParam(value="start",
defaultValue="0") Integer start,@RequestParam(value="size",defaultValue="8") Integer size)throws Exception {
		
		System.out.println("开始查询。。。");
		
		//设置分页信息
		PageHelper.startPage(start,size);		
		//查询用户信息
		List<t_proj_info> tu=pmc.seek();
		//将信息进行分页
		PageInfo<t_proj_info> page= new PageInfo<>(tu);			
		m.addAttribute("page",page);  
		m.addAttribute("list",tu);
		
		System.out.println("查询成功。。。");
		
		return "projectManageQuery";
	}
	
//.......................工程管理页面之间的跳转.........................
	/*
	//工程查询
	@RequestMapping(value="/projectManageQuery")
	public String projectManageQuery() {
		return "projectManageQuery";
	}
	*/
	
	//工程添加
	@RequestMapping(value="/projectManageAdd")
	public String projectManageAdd() {
		return "projectManageAdd";
	}
	
	//工程删除
	@RequestMapping(value="/projectManageDelete")
	public String projectManageDelete() {
		return "projectManageDelete";
	}
	
	//工程修改
	@RequestMapping(value="/projectManageUpdate")
	public String projectManageUpdate() {
		return "projectManageUpdate";
	}
	
	//返回用户管理
	@RequestMapping(value="/returnprojectManage")
	public String returnprojectManage() {
		return "projectManage";
	}
}
