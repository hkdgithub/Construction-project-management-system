package com.how2java.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class pageController {
	
@RequestMapping(value="/userManage")
public String userManage() {
	return "userManage";
}

@RequestMapping(value="/projectManage")
public String projectManage() {
	return "projectManage";	
}

@RequestMapping(value="/companyManage")
public String companyManage() {
	return "companyManage";
}

@RequestMapping(value="/bidManage")
public String bidManage() {
	return "bidManage";
}

//用户登录通过超链接跳转的控制器
@RequestMapping(value="/register")
public String register() {
			return "register";
		}

@RequestMapping(value="/returnMainWindow")
public String returnMainWindow() {
	return "mainWindow";
}

//返回到登录界面
@RequestMapping(value="/returnLogin")
public String returnLogin() {
	return "login";
}

}
