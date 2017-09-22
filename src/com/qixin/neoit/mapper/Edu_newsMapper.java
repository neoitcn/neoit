package com.qixin.neoit.mapper;

import java.util.List;
import java.util.Map;

import com.qixin.neoit.entity.Edu_news;

public interface Edu_newsMapper {

	// 1根据新闻类型和等级查询新闻
	List<Edu_news> findNewsByTypeAndLevel(Map<String, Object> map) throws Exception;

	// 2根据类型查询总页码
	int selectNewsPages(Integer newstype) throws Exception;

	// 3通过页码和类型查询新闻(后台)
	List<Edu_news> selectNewsByTyeAndPage(Map<String, Object> map) throws Exception;
	// 4查出最后一条学院新闻

	Edu_news selectLastNews() throws Exception;

	// 5根据newid查询上一篇和下一篇的新闻
	List<Edu_news> findNeBaNews(Integer newid) throws Exception;

	// 6根据新闻地址查询新闻
	Edu_news selectByhtmurl(String htmlurl) throws Exception;

	// 7.相关推荐新闻查询(查四条)
	List<Edu_news> findRecomNews(Integer newid) throws Exception;
	//9.根据页数和新闻类型查询(前端功能)
    List<Edu_news> selectqdNewsByTyeAndPage(Map<String,Object>  map)throws Exception;
     //10.查询置顶的学院新闻
    List<Edu_news> selectZDNews()throws Exception;

	int deleteByPrimaryKey(Integer id);

	int insert(Edu_news record);

	int insertSelective(Edu_news record);

	Edu_news selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Edu_news record);

	int updateByPrimaryKey(Edu_news record);
}