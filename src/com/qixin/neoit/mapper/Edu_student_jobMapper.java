package com.qixin.neoit.mapper;

import java.util.List;

import com.qixin.neoit.entity.Edu_student_job;

public interface Edu_student_jobMapper {
	
	 //1.��ѯѧԱ��ҳ��
	 int  selectStuPages()throws Exception;
	 //2.����ҳ���ѯѧԱ
	 List<Edu_student_job> selectStuBypage(Integer page)throws Exception;
	 //3.����ѧԱ���ŵ�ַ��ѯѧԱ
	 Edu_student_job selectStuByhtmurl(String htmlurl )throws Exception;
	//4.����Ƽ�ѧԱ���Ų�ѯ(������)
     List<Edu_student_job> findRecomStus(Integer stuid)throws Exception;
    //5.��ѯ��ҵѧ����ҳ��
   	 int  selectStusWorkPages()throws Exception;
   	//6.����ҳ����ѯ��ҵѧԱ
     List<Edu_student_job> selectStusWorkBypage(Integer page)throws Exception;
     //10.查询置顶学员新闻
     List<Edu_student_job>  selectZDstuNews()throws Exception;
   //查询4条普通学生新闻到index
     List<Edu_student_job> selectLev1StusNews() throws Exception;
	 int deleteByPrimaryKey(Integer id);

    int insert(Edu_student_job record);

    int insertSelective(Edu_student_job record);

    Edu_student_job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Edu_student_job record);

    int updateByPrimaryKey(Edu_student_job record);
}