package com.qixin.neoit.biz.impl;

import java.util.List;

import com.qixin.neoit.biz.TeacherBiz;
import com.qixin.neoit.entity.Edu_teachers;
import com.qixin.neoit.mapper.Edu_teachersMapper;

public class TeacherBizImpl implements TeacherBiz {
	Edu_teachersMapper edu_teachersMapper;
	
	@Override   //��ѯ��ʦ��ҳ��
	public int selectTeacherPages() throws Exception {
		// TODO Auto-generated method stub
		int pages=edu_teachersMapper.selectTeacherPages();
		System.out.println("������:"+pages);
		if(pages!=0){
			if(pages%10==0){
				return pages/10;}
			 else{
				 return pages/10 +1;}
			
		};
		return 0;
	
	}
	@Override    //����ҳ����ѯ��ʦ
	public List<Edu_teachers> selectTeacherByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return edu_teachersMapper.selectTeacherByPage(page);
	}

	@Override
	public int selectQianTeacherPages() throws Exception {
		// TODO Auto-generated method stub
		int pages=edu_teachersMapper.selectQianTeacherPages();
		if(pages!=0){
			if(pages%8==0){
				return pages/8;}
			 else{
				 return pages/8 +1;}
			
		};
		return 0;
	
	}

	@Override
	public List<Edu_teachers> selectQianTeacherByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return edu_teachersMapper.selectQianTeacherByPage(page);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return edu_teachersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Edu_teachers record) {
		// TODO Auto-generated method stub
		return edu_teachersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertSelective(Edu_teachers record) {
		// TODO Auto-generated method stub
		return edu_teachersMapper.insertSelective(record);
	}

	@Override
	public Edu_teachers selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return edu_teachersMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Edu_teachers> selectZDteaList() throws Exception {
		// TODO Auto-generated method stub
		return edu_teachersMapper.selectZDteaList();
	}
	@Override
	public List<Edu_teachers> selectLev1TeaNews() throws Exception {
		// TODO Auto-generated method stub
		return edu_teachersMapper.selectLev1TeaNews();
	}
	@Override
	public List<Edu_teachers> selectQianTaiZDteaList() throws Exception {
		// TODO Auto-generated method stub
		return edu_teachersMapper.selectQianTaiZDteaList();
	}

	public Edu_teachersMapper getEdu_teachersMapper() {
		return edu_teachersMapper;
	}

	public void setEdu_teachersMapper(Edu_teachersMapper edu_teachersMapper) {
		this.edu_teachersMapper = edu_teachersMapper;
	}


}
