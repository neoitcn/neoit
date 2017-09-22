package com.qixin.neoit.mapper;

import java.util.List;
import java.util.Map;

import com.qixin.neoit.entity.Page;
import com.qixin.neoit.entity.Sys_user;

public interface Sys_userMapper {
   
	 //1.根据用户名和密码查询用户
    Sys_user selectUserByNameAndPwd(Map map);
    //2.根据用户名查询用户是否存在
    Sys_user selectByName(String name);
    //3..查询用户总页数
  	int  selectUserPages()throws Exception;
     //4..根据页数查询用户
  	List<Sys_user> selectUserBypage(Integer page)throws Exception;
    //5.根据id查询用户名
    Sys_user selectUserNameById(Integer id);
   
    int deleteByPrimaryKey(Integer id);

    int insert(Sys_user record);

    int insertSelective(Sys_user record);

    Sys_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sys_user record);

    int updateByPrimaryKey(Sys_user record);
    
    
    
    
    List<Sys_user> getPagingList(Page page);
    Long getPagingTotalRecord(Page page);
	
}