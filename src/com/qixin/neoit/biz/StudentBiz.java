package com.qixin.neoit.biz;

import java.util.List;

import com.qixin.neoit.entity.Edu_news;
import com.qixin.neoit.entity.Edu_student_job;

public interface StudentBiz {

	 //1.查询学员总页数
	 int  selectStuPages()throws Exception;
	 //2.根据页数查询学员(和下方第8个方法查询的条数不同)
	 List<Edu_student_job> selectStuBypage(Integer page)throws Exception;
	 //3.添加学员
	 int insertSelective(Edu_student_job record)throws Exception;
	 //4.根据主键查询学员
	 Edu_student_job selectByPrimaryKey(Integer id)throws Exception;
	 //5.删除学员
	 int deleteByPrimaryKey(Integer id)throws Exception;
	  //6.根据新闻地址查询学员
	 Edu_student_job selectStuByhtmurl(String htmlurl )throws Exception;
	//7.相关推荐学员新闻查询(查四条)
	 List<Edu_student_job> findRecomStus(Integer stuid)throws Exception;
	//1.查询就业学员总页数
	 int  selectStusWorkPages()throws Exception;
	//8.根据页数查询学员
    List<Edu_student_job> selectStusWorkBypage(Integer page)throws Exception;
   //9.更新学生新闻
    int updateByPrimaryKeySelective(Edu_student_job record)throws Exception;
	//10.查询置顶学员新闻
    List<Edu_student_job>  selectZDstuNews()throws Exception;
    //查询4条普通学生新闻到index
    List<Edu_student_job> selectLev1StusNews() throws Exception;
    
}
