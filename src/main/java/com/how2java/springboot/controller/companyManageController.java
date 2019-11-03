package com.how2java.springboot.controller;

import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.config.ExportExcelUtils;
import com.how2java.springboot.mapper.companyManageMapper;
import com.how2java.springboot.pojo.t_ent_info;


@Controller
public class companyManageController {
	
	@Autowired
	private companyManageMapper cMM;
	
	private t_ent_info tei;
	
//............................企业信息管理的增删改查.......................

	//企业添加
	@RequestMapping(value="/companyAdd")
	public String companyAdd(@RequestParam("companyName") String qymc,@RequestParam("companyId") String qyid) {
		
		System.out.println("开始添加企业"+qyid);
		
		cMM.add(qyid, qymc);
		
		System.out.println("企业"+qyid+"添加成功");
		
		return "companyManageAdd";
	}
	
	//企业修改
	@RequestMapping(value="/companyUpdate")
	public String companyUpdate(@RequestParam("companyName") String qymc,@RequestParam("companyId") String qyid) {
		
		System.out.println("开始修改企业"+qyid);
		
		cMM.modify(qymc, qyid);
		
		System.out.println("修改企业"+qyid+"完成");
		
		return "companyManageUpdate";		
	}
	
	//企业删除
	@RequestMapping(value="/companyDelete")
	public String companyDelete(@RequestParam("companyId") String qyid) {
		
	    System.out.println("开始删除企业"+qyid);
	    
	    cMM.remove(qyid);
	    
	    System.out.println("删除企业"+qyid+"完成");
	    
	    return "companyManageDelete";
	}
	
	//企业信息查询
		@RequestMapping(value="/companyQuery")
		public String userManageQuery(Model m,@RequestParam(value="start",
	defaultValue="0") Integer start,@RequestParam(value="size",defaultValue="8") Integer size)throws Exception {
			
			System.out.println("开始查询企业信息。。。");
			
			//设置分页信息
			PageHelper.startPage(start,size);		
			//查询用户信息
			List<t_ent_info> tei=cMM.seek();
			//将信息进行分页
			PageInfo<t_ent_info> page= new PageInfo<>(tei);	
			
			m.addAttribute("page",page);  
			m.addAttribute("list",tei);
			
			System.out.println("企业信息查询成功。。。");
			
			return "companyManageQuery";
		}
		
		//企业导出
		@RequestMapping("/companyExport")
		public String companyExport(HttpServletResponse response, HttpServletRequest request) {
			
			System.out.println("开始企业导出");	
			
			//查询数据
		    List<t_ent_info> list =cMM.seek();
		    String excelName = "用户表";
		    
	        //获取需要转出的excel表头的map字段
	        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
	        fieldMap.put("qyid","企业编号");
	        fieldMap.put("qymc","企业名称");
	        
	 
	        //导出用户相关信息
	        new ExportExcelUtils().export(excelName,list,fieldMap,response);

			System.out.println("企业导出完成");
			return "companyManageExport";
		}
		
//............................企业管理子页面之间的跳转......................
	
	//企业添加
	@RequestMapping(value="/companyManageAdd")
	public String companyManageAdd() {
		return "companyManageAdd";
	}
	
	//企业删除
	@RequestMapping(value="/companyManageDelete")
	public String companyManageDelete() {
		return "companyManageDelete";
	}
	
	//企业修改
	@RequestMapping(value="/companyManageUpdate")
	public String companyManageUpdate() {
		return "companyManageUpdate";
	}
	
	//返回企业管理界面
	@RequestMapping("/returnCompanyManage")
	public String returnCompanyManage() {
		return "companyManage";
	}
	
	//企业导出
	@RequestMapping("/companyManageExport")
	public String companyManageExport() {
		return "companyManageExport";
	}
}

