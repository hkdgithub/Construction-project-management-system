package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.how2java.springboot.pojo.t_proj_info;


public interface projectManageMapper {

	//添加工程信息
	@Insert("insert into t_proj_info (prid,prmc,sqdw,ssxz,phone,przt) values(#{prid},#{prmc},#{sqdw},#{ssxz},#{phone},#{przt})")
    public int add(@Param("prid") String prid,@Param("prmc") String prmc,@Param("sqdw") String sqdw,@Param("ssxz") String ssxz,
    		@Param("phone") String phone,@Param("przt") String przt);
	
	//删除工程信息
	@Delete("delete from t_proj_info where prid=#{prid}")
	public void modify(@Param("prid") String prid);
	
	//修改工程信息
	@Update("update t_proj_info set prmc=#{prmc},sqdw=#{sqdw},ssxz=#{ssxz},phone=#{phone},przt=#{przt} where prid=#{prid}")
	public int remove(@Param("prmc") String prmc,@Param("sqdw") String sqdw,@Param("ssxz") String ssxz,
    		@Param("phone") String phone,@Param("przt") String przt,@Param("prid") String prid);
	
	//查询工程信息
	@Select("select * from t_proj_info")
	List<t_proj_info> seek();
}
