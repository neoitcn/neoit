package com.qixin.neoit.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qixin.neoit.biz.AdminBiz;
import com.qixin.neoit.biz.IndexBiz;
import com.qixin.neoit.biz.StudentBiz;
import com.qixin.neoit.biz.TeacherBiz;
import com.qixin.neoit.entity.Edu_news;
import com.qixin.neoit.entity.Edu_student_job;
import com.qixin.neoit.entity.Edu_teachers;

@Controller
@RequestMapping(value ="index")
@SessionAttributes("")
public class IndexController {
	@Resource(name = "indexBiz")
	private IndexBiz indexBiz;
	@Resource(name = "studentBiz")
	private StudentBiz studentBiz;
	@Resource(name = "teacherBiz")
	private TeacherBiz teacherBiz;

	
	 /** 
	 *查询首页所有显示的内容
	 * @author:zyj
	 * @date: 2017年12月12日
	 */
	@RequestMapping(value = "/SelectAllIndexContent")
	public String SelectAllIndexContent(HttpServletRequest request) {
		try {
			// 1.1查出头条新闻
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", 1); // 1表示头条新闻 2表示学院新闻
			map.put("level", 1);// 新闻等级,1表示普�?�显�?
			List<Edu_news> headnewslist = indexBiz.findNewsByTypeAndLevel(map);
			if (headnewslist != null) {
				request.setAttribute("headnewslist", headnewslist);

			}		
			// 1.2查出学院新闻(显示级别为普�?)
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("type", 2);//1表示轮播�?  2.表示下方的普通新�?
			map2.put("level", 1);// 新闻等级,1表示普�?�显�?,2置顶
			List<Edu_news> collegenewslist = indexBiz.findNewsByTypeAndLevel(map2);
			if (collegenewslist != null) {
				request.setAttribute("collegenewslist", collegenewslist);
			}
			//1.2.1查出置顶新闻3�?
			List<Edu_news> zdcollegenewslist=indexBiz.selectZDNews();
            request.setAttribute("zdcollegenewslist", zdcollegenewslist);
			
			//1.3查出学员就业新闻(显示级别为普�?)
			List<Edu_student_job> stuList = null;
			stuList = studentBiz.selectLev1StusNews();
			// 保存数据传到jsp
			request.setAttribute("stuList", stuList);
			//1.3.1查出置顶学员新闻zdstunewslist(3�?)
			List<Edu_student_job> zdstunewslist=studentBiz.selectZDstuNews();
			request.setAttribute("zdstunewslist", zdstunewslist);
			
		   //1.4查出师资信息(显示级别为普�?)
			List<Edu_teachers> teaList = null;
			teaList = teacherBiz.selectLev1TeaNews();
					
		    // 保存数据传到jsp
			request.setAttribute("teaList", teaList);
			//1.4.1查询置顶教师3�?
			List<Edu_teachers> selectZDteaList =teacherBiz.selectZDteaList();
			request.setAttribute("selectZDteaList", selectZDteaList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "index";
	}
	
	 /** 
	 * 查看更多
	 * @author:zyj
	 * @date: 2017年12月12日
	 */
	@RequestMapping(value ="/SelectMoreNews")
	public String SelectMoreNews(int page, int type, HttpServletRequest request) {
		try {
			// 2.1普�?�新闻的查询
			if (page == 0) {
				page = 1;// 设置默认查询页数�?1
			}
			int pages = indexBiz.selectNewsPages(2);// 获得总页�?
			int nextpage = 0;// 设置上一页下�?�?
			int backpage = 0;

			if (page >= pages && pages!= 0) {
				page = pages;
			}
			// 设置下一�?
			if (page >= 1 && page < pages) {
				nextpage = page + 1;
			}
			if (pages == page) {
				nextpage = pages;
			}
			// 设置上一�?
			if (page > 1 && page <= pages) {
				backpage = page - 1;

			}		
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", type);
			map.put("page", (page - 1) * 5);
			List<Edu_news> newsList = null;
			newsList = indexBiz.selectqdNewsByTyeAndPage(map);
			// 保存数据传到jsp
			request.setAttribute("newsList", newsList);
			request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("type", type);
			request.setAttribute("nextpage", nextpage);
			request.setAttribute("backpage", backpage);
	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	return "pages/xwlb";
	}

	
	 /** 
	 * 利用ajax查询新闻详情页的上下篇 及相关推荐
	 * @author:zyj
	 * @date: 2017年12月12日
	 */
	@ResponseBody
	@RequestMapping(value ="/finbebanews")
	public Map<String, Object> FinBeBanews(String newhtml){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (newhtml != null) {
				// 查询上一篇下�?�?
				int newid = indexBiz.selectByhtmurl(newhtml+".html").getId();
				List<Edu_news> newslist = indexBiz.findNeBaNews(newid);
				Edu_news news=indexBiz.selectLastNews();//查出�?后一条新�?
				map.put("newslist", newslist);
				map.put("news", news);
				map.put("newid", newid);
				// 查询相关推荐
				List<Edu_news> recomnewslist = indexBiz.findRecomNews(newid);
				map.put("recomnewslist", recomnewslist);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	
}