package com.qixin.neoit.mapper;

import java.util.List;

import com.qixin.neoit.entity.Edu_teachers;

public interface Edu_teachersMapper {
	
	//1.��ѯʦ����ҳ��
    int selectTeacherPages()throws Exception;
    //2.����ҳ����ѯʦ��(��̨����)
    List<Edu_teachers> selectTeacherByPage(Integer page)throws Exception;
    //3.��ѯʦ����ҳ��(ǰ̨����)
    int selectQianTeacherPages()throws Exception;
    //4.����ҳ����ѯʦ��(ǰ̨����)
    List<Edu_teachers> selectQianTeacherByPage(Integer page)throws Exception;
  //5.chaxun zhiding laoshi 3tiao
    List<Edu_teachers>  selectZDteaList()throws Exception;
  //6.chaxun putong news 4tiao on index show
    List<Edu_teachers> selectLev1TeaNews()throws Exception;
   
    int deleteByPrimaryKey(Integer id);

    int insert(Edu_teachers record);

    int insertSelective(Edu_teachers record);

    Edu_teachers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Edu_teachers record);

    int updateByPrimaryKey(Edu_teachers record);
}