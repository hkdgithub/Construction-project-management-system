package com.how2java.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.how2java.springboot.mapper.t_userMapper;


@Controller
public class loginController {
	@Autowired t_userMapper tM1;
	
	@RequestMapping(value="/login" ,method=RequestMethod.GET)
	public String login(Model m,@RequestParam("userName") String name,@RequestParam("passWord") String pwd) {
			
		System.out.println("开始进行登录");

        //判断用户是否存在，如果存在的话，跳转到主窗口，否则，返会原页面,并显示出错信息
		if(tM1.seek(name, pwd)!=null) {
			
		System.out.println("完成登录");
		
			return "mainWindow";	
		}
		else {
			System.out.println("登录出错");
			m.addAttribute("error","无此用户信息！请重新输入信息");
			return "login";
		} 
		
			
	
	}
}