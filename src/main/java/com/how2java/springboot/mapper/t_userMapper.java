package com.how2java.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.how2java.springboot.pojo.t_user;


public interface t_userMapper {
   
	//添加用户	
	@Insert("insert into t_user (name,pwd,dept) values(#{name},#{pwd},#{dept})")
	public int add(@Param("name") String name,@Param("pwd") String pwd,@Param("dept") String dept);

	//查询是否有该用户的信息
	@Select("select * from t_user where name=#{name} and pwd=#{pwd}")
	public t_user seek(@Param("name") String name,@Param("pwd") String pwd);
}
