package com.qixin.neoit.biz;

import java.util.List;
import java.util.Map;
import com.qixin.neoit.entity.Sys_user;

public interface UserBiz {
	
	    //1.根据用户名字和密码查询用户
	    Sys_user selectUserByNameAndPwd(Map map);
	    //2.根据用户名查询用户
	    Sys_user selectByName(String name);
	  
	    //3..查询用户总页数
		int  selectUserPages()throws Exception;
		 //4..根据页数查询用户
		List<Sys_user> selectUserBypage(Integer page)throws Exception;
		//5.根据id查询用户名
		Sys_user selectUserNameById(Integer id);
	    
	    int deleteByPrimaryKey(Integer id);
	
	    int insertSelective(Sys_user record);

	    Sys_user selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Sys_user record);
	
	
}
