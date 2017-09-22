package com.qixin.neoit.biz.impl;

import java.util.List;
import java.util.Map;

import com.qixin.neoit.biz.UserBiz;
import com.qixin.neoit.entity.Sys_user;
import com.qixin.neoit.mapper.Sys_userMapper;

public class UserBizImpl implements UserBiz {
	Sys_userMapper sys_userMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sys_userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Sys_user record) {
		// TODO Auto-generated method stub
		return sys_userMapper.insertSelective(record);
	}

	@Override
	public Sys_user selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sys_userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Sys_user record) {
		// TODO Auto-generated method stub
		return sys_userMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public Sys_user selectUserByNameAndPwd(Map map) {
		// TODO Auto-generated method stub
		return sys_userMapper.selectUserByNameAndPwd(map);
	}
	@Override
	public Sys_user selectByName(String name) {
		// TODO Auto-generated method stub
		return sys_userMapper.selectByName(name);
	}
	@Override
	public int selectUserPages() throws Exception {
		// TODO Auto-generated method stub
		int pages=sys_userMapper.selectUserPages();
		if(pages!=0){
			if(pages%10==0){
				return pages/10;}
			 else{
				 return pages/10 +1;}
			
		};
		return 0;
	}
	@Override
	public Sys_user selectUserNameById(Integer id) {
		// TODO Auto-generated method stub
		return sys_userMapper.selectUserNameById(id);
	}
	@Override
	public List<Sys_user> selectUserBypage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return sys_userMapper.selectUserBypage(page);
	}
	
	public Sys_userMapper getSys_userMapper() {
		return sys_userMapper;
	}

	public void setSys_userMapper(Sys_userMapper sys_userMapper) {
		this.sys_userMapper = sys_userMapper;
	}


}
