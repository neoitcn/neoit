package com.qixin.neoit.biz;

import java.util.List;
import java.util.Map;
import com.qixin.neoit.entity.Sys_user;

public interface UserBiz {
	
	    //1.�����û����ֺ������ѯ�û�
	    Sys_user selectUserByNameAndPwd(Map map);
	    //2.�����û�����ѯ�û�
	    Sys_user selectByName(String name);
	  
	    //3..��ѯ�û���ҳ��
		int  selectUserPages()throws Exception;
		 //4..����ҳ����ѯ�û�
		List<Sys_user> selectUserBypage(Integer page)throws Exception;
		//5.����id��ѯ�û���
		Sys_user selectUserNameById(Integer id);
	    
	    int deleteByPrimaryKey(Integer id);
	
	    int insertSelective(Sys_user record);

	    Sys_user selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Sys_user record);
	
	
}
