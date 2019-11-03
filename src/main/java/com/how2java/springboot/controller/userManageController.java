package com.how2java.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.userManageMapper;
import com.how2java.springboot.pojo.t_user;


@Controller
public class userManageController {
	
@Autowired 
private userManageMapper uMM;

//...................................用户管理信息的增删改查..................................
   //查询用户信息
	@RequestMapping(value="/userQuery")
	public String userManageQuery(Model m,@RequestParam(value="start",
defaultValue="0") Integer start,@RequestParam(value="size",defaultValue="8") Integer size)throws Exception {
		
		System.out.println("开始查询。。。");
		
		//设置分页信息
		PageHelper.startPage(start,size);		
		//查询用户信息
		List<t_user> tu=uMM.seek();
		//将信息进行分页
		PageInfo<t_user> page= new PageInfo<>(tu);			
		m.addAttribute("page",page);  
		m.addAttribute("list",tu);
		
		System.out.println("查询成功。。。");
		
		return "userManageQuery";
	}

    //添加用户信息
	@RequestMapping(value="/userAdd")
		public String userAdd(@RequestParam("userName") String name,@RequestParam("userPassword") String pwd,
				@RequestParam("dept") String dept) {
		
		System.out.println("正在添加用户"+name);
		
		uMM.add(name, pwd, dept);
		
		System.out.println("用户"+name+"添加完毕");
			return "userManageAdd";
		}
	
	//修改用户信息
	@RequestMapping(value="/userUpdate")
	public String userManageUpdate(@RequestParam("userName") String name,@RequestParam("userPassword") String pwd,
			@RequestParam("dept") String dept) {
		
		System.out.println("正在修改用户"+name);
		
		uMM.update(name, pwd, dept);
		
		System.out.println("修改"+name+"完成");
		
		return "userManage";
	}

	//用户删除界面
	@RequestMapping(value="/userDelete")
	public String userDelete(@RequestParam("userName") String name) {
		
		System.out.println("开始删除"+name);
		
		uMM.delete(name);
		
		System.out.println("删除"+name+"完成");
		
		return "userManage";
	}
	//...........................界面之间的跳转..................................
	
	/*
	//跳转到用户查询界面
	@RequestMapping(value="/userManageQuery")
	public String userManageQuery() {
		return "userManageQuery";
	}
	*/
	
	//跳转到用户添加界面
	@RequestMapping(value="/userManageAdd")
	public String userManageAdd() {
		return "userManageAdd";
	}
	
	//跳转到用户修改界面
	@RequestMapping(value="/userManageUpdate")
	public String userManageUpdate() {
		return "userManageUpdate";
	}
	
	//跳转到用户删除界面
	@RequestMapping(value="/userManageDelete")
	public String userMangeDelete() {
		return "userManageDelete";
	}
	}

