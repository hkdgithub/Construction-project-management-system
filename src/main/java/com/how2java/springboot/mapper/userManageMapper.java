package com.how2java.springboot.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.how2java.springboot.pojo.t_user;

public interface userManageMapper {

	//查询所有用户
		@Select("select * from t_user ")
	    List<t_user> seek();
	    
	//添加用户
	    @Insert("insert into t_user (name,pwd,dept) values(#{name},#{pwd},#{dept})")
	    public int add(@Param("name") String name,@Param("pwd") String pwd,@Param("dept") String dept);
	    
	//删除用户
	    @Delete("delete from t_user where name=#{name}")
	    public void delete(@Param("name")String name);
	    
	//修改用户信息
	    @Update("update t_user set pwd=#{pwd},dept=#{dept} where name=#{name}")
	    public int update(@Param("name") String name,@Param("pwd") String pwd,@Param("dept") String dept);
}
