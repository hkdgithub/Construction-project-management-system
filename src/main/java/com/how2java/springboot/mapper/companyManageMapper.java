package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.how2java.springboot.pojo.t_ent_info;

public interface companyManageMapper {

	//添加企业
    @Insert("insert into t_ent_info (qyid,qymc) values (#{qyid},#{qymc})")
    public int add(@Param("qyid") String qyid,@Param("qymc") String qymc);
    
    //删除企业
    @Delete("delete from t_ent_info where qyid=#{qyid}")
    public int remove(@Param("qyid") String qyid);
    
    //修改企业
    @Update("update t_ent_info set qymc=#{qymc} where qyid=#{qyid}")
    public int modify(@Param("qymc") String qymc,@Param("qyid") String qyid);
    
    //查询企业
    @Select("select * from t_ent_info")
    List<t_ent_info> seek();
}
