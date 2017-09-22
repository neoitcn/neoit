package com.qixin.neoit.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qixin.neoit.biz.OfficeManageBiz;
import com.qixin.neoit.entity.Sys_office;
import com.qixin.neoit.mapper.Sys_officeMapper;
@Service
public class OfficeMBizImpl implements OfficeManageBiz {
	
	@Autowired
	private Sys_officeMapper officeDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return officeDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Sys_office record) {
		// TODO Auto-generated method stub
		return officeDao.insert(record);
	}

	@Override
	public Sys_office selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return officeDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Sys_office record) {
		// TODO Auto-generated method stub
		return officeDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Sys_office> officeShow() {
		// TODO Auto-generated method stub
		return null;
	}


}
