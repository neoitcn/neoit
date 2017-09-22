package com.qixin.neoit.mapper;

import java.util.List;
import java.util.Map;

import com.qixin.neoit.entity.Edu_news;

public interface Edu_newsMapper {

	// 1�����������ͺ͵ȼ���ѯ����
	List<Edu_news> findNewsByTypeAndLevel(Map<String, Object> map) throws Exception;

	// 2�������Ͳ�ѯ��ҳ��
	int selectNewsPages(Integer newstype) throws Exception;

	// 3ͨ��ҳ������Ͳ�ѯ����(��̨)
	List<Edu_news> selectNewsByTyeAndPage(Map<String, Object> map) throws Exception;
	// 4������һ��ѧԺ����

	Edu_news selectLastNews() throws Exception;

	// 5����newid��ѯ��һƪ����һƪ������
	List<Edu_news> findNeBaNews(Integer newid) throws Exception;

	// 6�������ŵ�ַ��ѯ����
	Edu_news selectByhtmurl(String htmlurl) throws Exception;

	// 7.����Ƽ����Ų�ѯ(������)
	List<Edu_news> findRecomNews(Integer newid) throws Exception;
	//9.����ҳ�����������Ͳ�ѯ(ǰ�˹���)
    List<Edu_news> selectqdNewsByTyeAndPage(Map<String,Object>  map)throws Exception;
     //10.��ѯ�ö���ѧԺ����
    List<Edu_news> selectZDNews()throws Exception;

	int deleteByPrimaryKey(Integer id);

	int insert(Edu_news record);

	int insertSelective(Edu_news record);

	Edu_news selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Edu_news record);

	int updateByPrimaryKey(Edu_news record);
}