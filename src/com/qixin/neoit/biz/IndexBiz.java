package com.qixin.neoit.biz;
import java.util.List;
import java.util.Map;
import com.qixin.neoit.entity.Edu_news;
public interface IndexBiz {
    //1.根据类型和等级查询新闻
	List<Edu_news> findNewsByTypeAndLevel(Map<String, Object> map)throws Exception;
	
	//2.查询新闻总页数
    int selectNewsPages(Integer newstype)throws Exception;
    //3.根据页数和新闻类型查询(后台功能)
    List<Edu_news> selectNewsByTyeAndPage(Map<String,Object>  map)throws Exception;
    //4.根据id查询
    Edu_news selectByPrimaryKey(Integer id)throws Exception;
    //5.根据newid查询上一篇和下一篇的新闻
    List<Edu_news> findNeBaNews(Integer newid)throws Exception;
    //6.根据新闻地址查询新闻
    Edu_news selectByhtmurl(String htmlurl )throws Exception;
    //7.相关推荐新闻查询(查四条)
    List<Edu_news> findRecomNews(Integer newid)throws Exception;
    //8.查出最后一条学院新闻
    Edu_news selectLastNews()throws Exception;
    
    //9.根据页数和新闻类型查询(前端功能)
    List<Edu_news> selectqdNewsByTyeAndPage(Map<String,Object>  map)throws Exception;
   //10.查询置顶的学院新闻
    List<Edu_news> selectZDNews()throws Exception;



}
