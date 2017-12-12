package com.qixin.neoit.mapper;

import java.util.List;
import java.util.Map;

import com.qixin.neoit.entity.Sys_user;

public interface Sys_userMapper {
   
	 //1.�����û����������ѯ�û�
    Sys_user selectUserByNameAndPwd(Map map);
    //2.�����û�����ѯ�û��Ƿ����
    Sys_user selectByName(String name);
    //3..��ѯ�û���ҳ��
  	int  selectUserPages()throws Exception;
     //4..����ҳ����ѯ�û�
  	List<Sys_user> selectUserBypage(Integer page)throws Exception;
    //5.����id��ѯ�û���
    Sys_user selectUserNameById(Integer id);
   
    int deleteByPrimaryKey(Integer id);

    int insert(Sys_user record);

    int insertSelective(Sys_user record);

    Sys_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sys_user record);

    int updateByPrimaryKey(Sys_user record);
    
    
    
    
   
}