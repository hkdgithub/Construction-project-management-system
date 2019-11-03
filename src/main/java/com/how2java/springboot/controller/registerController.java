package com.how2java.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.how2java.springboot.mapper.t_userMapper;



@Controller
public class registerController {	

@Autowired  
private t_userMapper tM;
//注册用户
@RequestMapping(value="/registerAdd",method=RequestMethod.GET)
public String registerAdd(@RequestParam("userName") String name,@RequestParam("passWord") String passWord
		,@RequestParam("dept") String dept) {	
	
	System.out.println("开始进行注册");
	
	//将用户的信息传到数据库中去	
	tM.add(name, passWord, dept);
	
	System.out.println("用户"+name+"注册成功");
	
	//注册成功，跳转到主界面
	return "login";
}
//返回主界面
@RequestMapping(value="/returnLogin",method=RequestMethod.GET)
public String returnLogin() {
	return "login";
}
}

