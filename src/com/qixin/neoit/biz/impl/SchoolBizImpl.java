package com.qixin.neoit.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.qixin.neoit.biz.AdminBiz;
import com.qixin.neoit.entity.Edu_news;
import com.qixin.neoit.mapper.Edu_newsMapper;



public class SchoolBizImpl  implements  AdminBiz{
	@Autowired
	Edu_newsMapper edu_newsMapper;
    @Override
	public int selectNewsPages(Integer newstype) throws Exception {
		// TODO Auto-generated method stub
		Integer aa=edu_newsMapper.selectNewsPages(newstype);
		
		if(aa!=null){
			if(aa%10==0){
				return aa/10;}
			 else{
				 return aa/10 +1;}
			
		};
		return 0;
	}

	@Override
	public List<Edu_news> selectNewsByTyeAndPage(Map<String,Object>  map) throws Exception {
		// TODO Auto-generated method stub
		if(edu_newsMapper.selectNewsByTyeAndPage(map)!=null&&
		   edu_newsMapper.selectNewsByTyeAndPage(map).size()>0){	
				
			return edu_newsMapper.selectNewsByTyeAndPage(map);
		  }
		return null;
	}

	@Override
	public int insertSelective(Edu_news record) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Edu_news record) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.deleteByPrimaryKey(id);
	}

	
	@Override
	public Edu_news selectByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.selectByPrimaryKey(id);
	}
	

	
	
	


}