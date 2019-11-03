package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.how2java.springboot.pojo.t_ent_info;
import com.how2java.springboot.pojo.t_ent_proj_info;

public interface bidManageMapper {

	//投标信息添加
	@Insert("insert into t_ent_proj_info (prid,qyid,ysbj,tbbj,degq,tbgq) values (#{prid},#{qyid},#{ysbj},#{tbbj},#{degq},#{tbgq})")
	 public int add(@Param("prid") String prid,@Param("qyid") String qyid,@Param("ysbj") int ysbj,@Param("tbbj") int tbbj,@Param("degq") int degq,@Param("tbgq") int tbgq);

    //投标信息修改
	@Update("update t_ent_proj_info set qyid=#{qyid},ysbj=#{ysbj},tbbj=#{tbbj},degq=#{degq},tbgq=#{tbgq} where prid=#{prid}")
	 public int modify(@Param("qyid") String qyid,@Param("ysbj") String ysbj,@Param("tbbj") String tbbj,@Param("degq") String degq,@Param("tbgq") String tbjq,@Param("prid") String prid);
	
	//投标信息删除
	@Delete("delete from t_ent_proj_info where prid=#{prid}")
	 public int remove(@Param("prid") String prid);
	
	//投标信息查询
	@Select("select  * from t_ent_proj_info")
	List<t_ent_proj_info> seek();
}
