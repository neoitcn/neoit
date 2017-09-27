package com.qixin.neoit.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.qixin.neoit.biz.IndexBiz;
import com.qixin.neoit.entity.Edu_news;
import com.qixin.neoit.mapper.Edu_newsMapper;

public class IndexBizImpl implements IndexBiz {
	@Autowired
	Edu_newsMapper edu_newsMapper;
    //1.根据类型和等级查询新闻
	@Override
	public List<Edu_news> findNewsByTypeAndLevel(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.findNewsByTypeAndLevel(map);
	}
	@Override
	public int selectNewsPages(Integer newstype) throws Exception {
		// TODO Auto-generated method stub
		Integer aa=edu_newsMapper.selectNewsPages(newstype);
			if(aa!=null){
			if(aa%5==0){
				return aa/5;}
			 else{
				 return aa/5 +1;}
			
		};
		return 0;
	}
	@Override
	public List<Edu_news> selectqdNewsByTyeAndPage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.selectqdNewsByTyeAndPage(map);
	}

	@Override
	public List<Edu_news> selectNewsByTyeAndPage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.selectNewsByTyeAndPage(map);
	}
	@Override
	public Edu_news selectByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Edu_news> findNeBaNews(Integer newid) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.findNeBaNews(newid);
	}
	@Override
	public Edu_news selectByhtmurl(String htmlurl) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.selectByhtmurl(htmlurl);
	}
	
	@Override
	public List<Edu_news> findRecomNews(Integer newid) throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.findRecomNews(newid);
	}
	@Override
	public Edu_news selectLastNews() throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.selectLastNews();
	}
	@Override
	public List<Edu_news> selectZDNews() throws Exception {
		// TODO Auto-generated method stub
		return edu_newsMapper.selectZDNews();
	}
	
	

}
