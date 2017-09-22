package com.qixin.neoit.biz.impl;

import java.util.List;

import com.qixin.neoit.biz.StudentBiz;
import com.qixin.neoit.entity.Edu_student_job;
import com.qixin.neoit.mapper.Edu_student_jobMapper;


public class StudentBizImpl implements StudentBiz {
	Edu_student_jobMapper edu_student_jobMapper;
	@Override
	public int selectStuPages() throws Exception {
		int pages=edu_student_jobMapper.selectStuPages();
		System.out.println("总条数:"+pages);
		if(pages!=0){
			if(pages%10==0){
				return pages/10;}
			 else{
				 return pages/10 +1;}
			
		};
		return 0;
	}

	@Override
	public List<Edu_student_job> selectStuBypage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.selectStuBypage(page);
	}

	@Override
	public int insertSelective(Edu_student_job record) throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.insertSelective(record);
	}

	@Override
	public Edu_student_job selectByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Edu_student_job selectStuByhtmurl(String htmlurl) throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.selectStuByhtmurl(htmlurl);
	}
	@Override
	public List<Edu_student_job> findRecomStus(Integer stuid) throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.findRecomStus(stuid);
	}
	@Override
	public int selectStusWorkPages() throws Exception {
		// TODO Auto-generated method stub
		int pages=edu_student_jobMapper.selectStusWorkPages();
		if(pages!=0){
			if(pages%8==0){
				return pages/8;}
			 else{
				 return pages/8 +1;}
			
		};
		return 0;
		
	}

	@Override
	public List<Edu_student_job> selectStusWorkBypage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.selectStusWorkBypage(page);
	}

	@Override
	public int updateByPrimaryKeySelective(Edu_student_job record) throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public List<Edu_student_job> selectZDstuNews() throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.selectZDstuNews();
	}
	@Override
	public List<Edu_student_job> selectLev1StusNews() throws Exception {
		// TODO Auto-generated method stub
		return edu_student_jobMapper.selectLev1StusNews();
	}
	
	public Edu_student_jobMapper getEdu_student_jobMapper() {
		return edu_student_jobMapper;
	}

	public void setEdu_student_jobMapper(Edu_student_jobMapper edu_student_jobMapper) {
		this.edu_student_jobMapper = edu_student_jobMapper;
	}

	

}
