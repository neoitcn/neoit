package com.qixin.neoit.biz;
import java.util.List;
import java.util.Map;

import com.qixin.neoit.entity.Edu_news;
public interface AdminBiz { 

	//添加新闻
	int insertSelective(Edu_news record)throws Exception;
	//更新新闻
	int updateByPrimaryKeySelective(Edu_news record)throws Exception;
	//删除新闻
	int deleteByPrimaryKey(Integer id)throws Exception;

    //根据新闻类型查询一共可分为多少页(每页10条)
    int selectNewsPages(Integer newstype)throws Exception;
    //根据新闻类型 和页码 查询新闻
    List<Edu_news> selectNewsByTyeAndPage(Map<String,Object>  map)throws Exception;
  
    Edu_news selectByPrimaryKey(Integer id)throws Exception;
	
    
 
}