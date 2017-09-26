package com.qixin.neoit.biz;

import java.util.List;

import com.qixin.neoit.entity.Edu_teachers;


public interface TeacherBiz  {
	
	//1.��ѯʦ����ҳ��(��̨����)
    int selectTeacherPages()throws Exception;
    //2.����ҳ����ѯʦ��(��̨����)
    List<Edu_teachers> selectTeacherByPage(Integer page)throws Exception;
    //3.��ѯʦ����ҳ��(ǰ̨����)
    int selectQianTeacherPages()throws Exception;
    //4.����ҳ����ѯʦ��(ǰ̨����)
    List<Edu_teachers> selectQianTeacherByPage(Integer page)throws Exception;
   //5.chaxun zhiding laoshi 3tiao(index.jsp)
    List<Edu_teachers>  selectZDteaList()throws Exception;
    //6.chaxun putong news 4tiao on index show
    List<Edu_teachers> selectLev1TeaNews()throws Exception;
    //7.chaxun zhiding laoshi 8 tiao(on sztd.jsp)
    List<Edu_teachers>  selectQianTaiZDteaList()throws Exception;
    
    
    
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Edu_teachers record);
    int insertSelective(Edu_teachers record);
    Edu_teachers selectByPrimaryKey(Integer id);
    

}
