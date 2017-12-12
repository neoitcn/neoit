package com.qixin.neoit.controller.sch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.qixin.neoit.biz.AdminBiz;
import com.qixin.neoit.biz.StudentBiz;
import com.qixin.neoit.biz.TeacherBiz;
import com.qixin.neoit.biz.UserBiz;
import com.qixin.neoit.entity.Edu_news;
import com.qixin.neoit.entity.Edu_student_job;
import com.qixin.neoit.entity.Edu_teachers;
import com.qixin.neoit.entity.Sys_user;
import com.qixin.neoit.proaddress.ProjectAddress;

@Controller
@RequestMapping(value = "admin")
@SessionAttributes("")
public class SchoolController {
	@Resource(name = "adminBiz")
	private AdminBiz adminBiz;
	@Resource(name = "studentBiz")
	private StudentBiz studentBiz;
	@Resource(name = "teacherBiz")
	private TeacherBiz teacherBiz;
	@Resource(name = "userBiz")
	private UserBiz userBiz;
	//获取项目绝对路径
	String basicpath = ProjectAddress.projectaddress;
	
	 //上传新闻(后台功能)
	@RequestMapping(value = "/uploadNews")
	public String uploadNews(Edu_news news, String[] pic, String content,
			@RequestParam(value = "smallpicture") MultipartFile smallpicture, Map<String, Object> map,
			HttpServletRequest request) {

		try {
			// 1.上传新闻缩略图
			if (smallpicture.getOriginalFilename().equals("")) {
				request.setAttribute("msg", "请选择新闻标题图片..");
				return "main";
			}
			String filename = smallpicture.getOriginalFilename();// 获取缩略图名�??
			int index = filename.lastIndexOf(".");
			String filetype = filename.substring(index + 1);// 获得图片后缀
			// 定义新闻缩略图上传类型
			List<String> typelist = new ArrayList<String>();
			typelist.add("JPG");
			typelist.add("jpg");
			typelist.add("jpeg");
			typelist.add("JPEG");
			typelist.add("GIF");
			typelist.add("gif");
			typelist.add("BMP");
			typelist.add("bmp");
			typelist.add("PNG");
			typelist.add("png");
			// 图片类型不对则返回
			if (!typelist.contains(filetype)) {
				request.setAttribute("msg", "上传文件类型不对..");
				return "main";
			}
			long lon = new Date().getTime();// 利用当前日期作为 缩略图名 (也用做下面新闻地�??)
			// 设定图片保存的路径path
			String path = basicpath + "images/titleimages/";
			// 保存文件(两种:1.通过流读取和写入,2.通过MultipartFile的transferTo保存)
			String picpath = path + lon + "." + filetype;
			smallpicture.transferTo(new File(picpath));
			request.setAttribute("msg", "图片上传成功..");
			request.setAttribute("studentxinxi", "新闻添加完成..");
			// ----------------------2.以下是添加新闻-----------------------------------------
			news.setCreateTime(new Date());// 设定新闻创建时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 加上HTML头和尾,生成HTML页面;
			String htmlcontent;
			// 2.1添加HTML头部
			htmlcontent = "<!DOCTYPE html>" 
			        + "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/html\">"
					+ "<head>"
					+ "<meta charset=\"utf-8\">" 
					+"<title>启芯教育_90后工程师的摇蓝-大数据培训-VR培训-交互视觉设计培训</title>"
					+"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"
					+"<meta name=\"description\" content=\"启芯教育-0基础,0学费入学，签订就业协议保障学生就业薪资,专注于java培训，大数据培训，VR培训，虚拟现实培训，交互设计培训，UI培训。 选择启芯教育既是选择新的起点，开创不一样的未来。我们倾尽全力，用教育改变人生。\"/>"
					+"<meta name=\"keywords\" content=\"java培训-大数据培训-VR培训-虚拟现实培训-交互设计培训-UI培训\" />"
					
					
					+ "<meta name=\"author\" content=\"http://www.cssmoban.com\" />" + "<!-- css -->"
					+ "<link href=\"../../css/bootstrap.min.css\" rel=\"stylesheet\" />"
					+ "<link href=\"../../css/fancybox/jquery.fancybox.css\" rel=\"stylesheet\">"
					+ "<!--<link href=\"../../css/jcarousel.css\" rel=\"stylesheet\" />-->"
					+ "<link href=\"../../css/flexslider.css\" rel=\"stylesheet\" />"
					+ "<link href=\"../../css/style.css\" rel=\"stylesheet\" />"
					+ "<link rel=\"stylesheet\" href=\"../../css/chat.css\"/>"
					+"<link href=\"/neoit/pages/img/favicon.ico\" rel=\"shortcut icon\" type=\"image/x-icon\"/>"

					+ "<!-- Theme skin -->" 
					+ "<link href=\"../../skins/default.css\" rel=\"stylesheet\" />"
					+ "<script type=\"text/javascript\" src=\"../../js/jquery.min.js\"></script>"

					+ "<script type=\"text/javascript\">"
					+ "$(document).ready(function changSecondKind() {"
					+ "var newhtml =document.getElementById(\"newhtml\").value;"

					+ "$.ajax({" 
					+ "type : \"post\"," + "url : \"../../../index/finbebanews.do\","
					+ "data : \"newhtml=\" + newhtml," + "datatype : \"html\"," + "success : function(resu) {"
					+ "var news = resu.news;" + "var newid = resu.newid;" + "var sec = resu.newslist;"
					+ "var recsec = resu.recomnewslist;" + "var sedstr = \"\";" + "var recomstr = \"\";"

					+ "for (var i = 0; i < sec.length; i++) {"

					+ "var obj = sec[i];"

					+ "if(sec.length ==1){"

					+ "if (newid==news.id) {"
					+ "sedstr ='<div class=\"f1 c2 article_list article_list1\" style=\"font-size: 16px\">'"
					+ "+'<span>上一篇：</span>'"
					+ "+'<a class=\"c2\" style=\"color: #666\">没有上一篇了</a>'" 
					+ "+'</div>'"

					+ "+'<div class=\"f1 c2 article_list \" style=\"font-size: 16px;padding-bottom: 30px;\">'"
					+ "+ '<span>下一篇：</span>'"

					+ "+ '<a class=\"c2\" style=\"color:#666\" href=\"/neoit/pages/news/'+obj.type+'/'+obj.htmlUrl+'\">'"
					+ "+ obj.title"
					+ "+ '</a>'"
					+ "+ '</div>';" 
					+ "} else {"
					+ "sedstr = '<div class=\"f1 c2 article_list article_list1\" style=\"font-size: 16px\">'"
					+ "+ '<span>上一篇：</span>'"

					+ "+ '<a class=\"c2\" style=\"color:#666\" href=\"/neoit/pages/news/'+obj.type+'/'+obj.htmlUrl+'\">'" + "+ obj.title"
					+ "+ '</a>'" 
					+ "+ '</div>'"
					+ "+ '<div class=\"f1 c2 article_list \" style=\"font-size: 16px; padding-bottom: 30px;\">'"
					+ "+ '<span>下一篇：</span>'"
					+ "+'<a class=\"c2\" style=\"color: #666\">没有下一篇了</a>'" 
					+ "+ '</div>';"
					+ "}"

					+ "} else {"

					+ "if (i==0) {"

					+ "sedstr+='<div class=\"f1 c2 article_list article_list1\" style=\"font-size: 16px\">'"
				    + "+ '<span>上一篇：</span>'"
					+ "+ '<a class=\"c2\" style=\"color:#666\" href=\"/neoit/pages/news/'+obj.type+'/'+obj.htmlUrl+'\">'"
					+ "+ obj.title"
					+ "+ '</a>' + '</div>';"
					+ "} else {"
					+ "sedstr+='<div class=\"f1 c2 article_list \" style=\"font-size: 16px;padding-bottom: 30px;\">'"
					+ "+ '<span>下一篇：</span>'"
					+ "+ '<a class=\"c2\" style=\"color:#666\" href=\"/neoit/pages/news/'+obj.type+'/'+obj.htmlUrl+'\">'" 
					+ "+ obj.title"
					+ "+ '</a>' + '</div>';"
					+ "}"
					+ "}" + "}"

					+ "$(\"#nebanews\").html(sedstr);"
					+ "for (var i = 0; i < recsec.length; i++) {"
					+ "var obj = recsec[i];" 
					+ "recomstr += '<div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12\">'"
					+ "+ '<dl class=\"dl-horizontal dl_list dl_detail\">'"
					+ "+ '<dt>'"
					+ "+ '<img src=\"../images/titleimages/'+obj.titleImage+'\"'"
					+ "+'	style=\"width: 138px; height: 125px\" alt=\"\" class=\"img_hover2\">'" + "+ '</dt>'"
					+ "+ '<dd>'" 
					+ "+ '<h3 class=\"f4\"'"
					+ "+'	style=\"padding-top: 0px; font-size: 1.6rem; line-height: 1.4; max-height: 44px\">'"
					+ "+ '	<a class=\"c5\" style=\"color: #000; text-decoration: none\"'"
					+ "+'		href=\"/neoit/pages/news/'+obj.type+'/'+obj.htmlUrl+'\">'" + "+ obj.title" + "+ '</a>'"
					+ "+ '</h3>'"
					+ "+ '<p class=\"f2_1 c2 hidden-xs hidden-sm\"'"
					+ "+'	style=\"max-height: 42px; line-height: 1.5; margin-top: 10px; overflow: hidden; text-overflow: ellipsis; color: #666; font-size: 1.4rem; margin: 0px\">'"
					+ "+ obj.resume" 
					+ "+ '</p>'"
					+ "+ '</dd>'"
					+ "+ '	</dl>'" 
					+ "+ '</div>';"
					+ "}"

					+ "$(\"#recomnews\").html(recomstr);"

					+ "}," 
					+ "error : function() {"
					+ "alert(\"执行ajax的方法错误了...\");" 
					+ "}" + "});"
					+ "});"
					+"window.onload=function(){" 
					+"var myDate = new Date();"
					+" var mon= myDate.getMonth()+1;"
					+" var mon2= myDate.getMonth()+2;"
					+"if(mon2==13) {mon2=1;}"
					+" var da= myDate.getDate();"
				
				    +"if(da<8){"
			
					+"document.getElementById(\"vardate1\").innerHTML=mon+\"月8号\";"
					+"document.getElementById(\"vardate2\").innerHTML=mon+\"月18号\";"
					+"document.getElementById(\"vardate3\").innerHTML=mon+\"月28号\";"
						
					+"}"
				    +"if(da>=8&&da<18){"
				
					+"document.getElementById(\"vardate1\").innerHTML=mon2+\"月8号\";"
					+"document.getElementById(\"vardate2\").innerHTML=mon+\"月18号\";"
					+"document.getElementById(\"vardate3\").innerHTML=mon+\"月28号\";"
						
					+"} "
				 
				    +"if(da>=18&&da<=28){"
				
					+"document.getElementById(\"vardate1\").innerHTML=mon2+\"月8号\";"
					+"document.getElementById(\"vardate2\").innerHTML=mon2+\"月18号\";"
					+"document.getElementById(\"vardate3\").innerHTML=mon+\"月28号\";"
						
					+"}" 
				    +"if(da>28){"
				    +"document.getElementById(\"vardate1\").innerHTML=mon2+\"月8号\";"
					+"document.getElementById(\"vardate2\").innerHTML=mon2+\"月18号\";"
					+"document.getElementById(\"vardate3\").innerHTML=mon2+\"月28号\";"
					+"};"
					 //控制编辑器中的图片
					
					 +"var spans = document.getElementById(\"con\").getElementsByTagName(\"img\");"
			         +"for(var i=0;i<spans.length;i++){"
			    	 +"spans[i].setAttribute(\"class\",'img-responsive center-block');"
			    	 +"spans[i].setAttribute(\"style\",'width:100%;height: 100%;');"
			         +"}"
					
					+"}"
				
					+ "</script>"
					+ "<style type=\"text/css\">"
					+ "#con img{"
					+ " max-width:560px;" 
					+ " height:auto;"
					+ " }"

					+ "</style>"

					+ "</head>"
					+ "<body>"
					// 设置新闻地址html,利用ajax传到后台 查询他的上下一篇
					+ "<input id=\"newhtml\" type=\"hidden\" value=\"" + lon + "\"/>" + "<div id=\"wrapper\">"
					+ "<!-- start header -->" + "<header>" + " <div class=\"navbar navbar-default navbar-static-top\">"
					+ "<div class=\"container\">" + "<div class=\"navbar-header\">"
					+ " <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">"
					+ " <span class=\"icon-bar\"></span>" + " <span class=\"icon-bar\"></span>"
					+ " <span class=\"icon-bar\"></span>" + "</button>"
					+ " <a class=\"navbar-brand\" href=\"/neoit/index.jsp\"><img src=\"../../img/1.png.png\" alt=\"\"/></a>"
					+ "</div>"
					+ "<div class=\"navbar-collapse collapse \">" 
					+ "<ul class=\"nav navbar-nav\">"
					+ "<li><a href=\"/neoit/index.jsp\">首页</a></li>"
					+ "<li class=\"dropdown \">"
					+ "<a href=\"../../#\" class=\"dropdown-toggle \" data-toggle=\"dropdown\" data-hover=\"dropdown\" data-delay=\"0\" data-close-others=\"false\">课程介绍<b class=\" icon-angle-down\"></b></a>"
					+ " <ul class=\"dropdown-menu\">"
					+ "<li><a href=\"../../dsj.html\">大数据</a></li>"
					+ "<li><a href=\"/neoit/pages/sjcd.html\">交互视觉设计</a></li>"
					+ "<li><a href=\"../../vr.html\">VR</a></li>"
					+ "</ul>" +
					"</li>"
					+ "<li><a href=\"../../sztd.jsp\">师资团队</a></li>"
					+ "<li><a href=\"/neoit/pages/xyjy.jsp\">学员生活</a></li>"
					+"<li><a  href=\"/neoit/pages/gxjy.html\">高薪就业</a></li>"
					+ "<li><a href=\"../../gywm.html\">关于我们</a></li>"
					
					+ "</ul>" 
					+ "</div>" + "</div>" + "</div>"
					+ "</header>" + "<!-- end header -->" + "<section id=\"inner-headline\">"
					+ "<div class=\"container\">" + "<div class=\"row\">" + "<div class=\"col-lg-12\">"
					+ "<ul class=\"breadcrumb\">"
					+ "<li><a href=\"/neoit/index.jsp\"><i class=\"fa fa-home\"></i></a><i class=\"icon-angle-right\"></i></li>"
					+ "<li class=\"active\">新闻</li>" 
					+ "</ul>"
					+ "</div>" 
					+ "</div>" + "</div>" + "</section>"
					+ "<section id=\"content\">" + "<section class=\"container\">" + "<div class=\"row\">"
					+ "<div class=\"col-lg-8\">"

					+ "<article>" + "<div class=\"post-image\">" + "<div class=\"post-heading\">"
					+ "<h3 align=\"center\">" + news.getTitle() + "</h3>" // 文章标题
					+ "</div>"

					+ " <div class=\"div_wrap\" align=\"center\">"
					+ "<ul class=\"detail_ul clearfix f3\" style=\"display: inline-block;margin-top: 18px;margin-bottom: 26px;font-size: 1.2rem;list-style: none;text-indent: 0;list-style-position: outside;\">"
					+ " <li style=\"display: inline-block;float: left;padding: 0 14px;\">时间:<span>"
					+ sdf.format(news.getCreateTime()) + "</span>" // 发布时间
					+ "</li>"
					+ "<li style=\"display: inline-block;float: left;padding: 0 14px\">作者:<span>"+news.getAuthor()+"</span>"
					+ "</li>"
					+ "<li style=\"display: inline-block;float: left;padding: 0 14px\">来源:<span><a href=\"/neoit/pages/xwlb.jsp\">新闻</a></span>"
					+ "</li>"
					+ " <li style=\"display: inline-block;float: left;padding: 0 14px\" class=\"hidden-xs\"><span class=\"inline_block pull-left\">分享到：</span>"
					+ " <span class=\"share_wrap inline_block pull-left\">"
					+ " <div class=\"bdsharebuttonbox bdshare-button-style0-16\" data-bd-bind=\"1502439907092\"><a href=\"../../#\" class=\"bds_more\" data-cmd=\"more\"></a><a title=\"分享到QQ空间\" href=\"../../#\" class=\"bds_qzone\" data-cmd=\"qzone\"></a><a title=\"分享到新浪微博\" href=\"../../#\" class=\"bds_tsina\" data-cmd=\"tsina\"></a><a title=\"分享到腾讯微博\" href=\"../../#\" class=\"bds_tqq\" data-cmd=\"tqq\"></a><a title=\"分享到人人网\" href=\"../../#\" class=\"bds_renren\" data-cmd=\"renren\"></a><a title=\"分享到微信\" href=\"../../#\" class=\"bds_weixin\" data-cmd=\"weixin\"></a></div>"
					+ "<script>"
					+ "window._bd_share_config={\"common\":{\"bdSnsKey\":{},\"bdText\":\"\",\"bdMini\":\"2\",\"bdMiniList\":false,\"bdPic\":\"\",\"bdStyle\":\"0\",\"bdSize\":\"16\"},\"share\":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>"
					+ "</span>" + "</li>" + "</ul>" + "</div>"
					+ "<hr class=\"line_style\" style=\"border-top: solid 1px;box-sizing: content-box\">" + "</div>"

					+ "<div id=\"con\">"

					  + content // 添加新闻内容
					+ "</div>"

					+ "</article>"
					// 设置上 下篇
					+ "<div id=\"nebanews\">"

					+ "</div>"
				
					+ "<div style=\"margin-top:10px;\" class=\"detail_caption  f4 c1\" >"
					+ "<span class=\"icon font-icon-bell\"></span>相关推荐"
					+ "</div>"
					+ "<hr class=\"hidden-xs line_style\">"
					
					// 相关推荐的DIV
					+ "<div id=\"recomnews\" class=\"row tui_jie\">" 
					+ "</div>"
					+ "</div>"
					+ "<div class=\"col-lg-4 col-md-4 hidden-xs hidden-sm\">"
					+ "<div class=\"right-sidebar\">"
					+ "<div class=\"widget\">"
					+ " <div align=\"center\" style=\"margin-top: 20px\">"
					+ "<a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\"><img src=\"../../img/images/1495458603018.jpg\" width=\"300\" height=\"142\"></a>"
					+ "<a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\"><img src=\"../../img/images/1495458821650.jpg\" width=\"300\" height=\"142\"></a>"
					+ "<a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\"><img src=\"../../img/images/1496737033250.jpg\" width=\"300\" height=\"142\"></a>"
					+ "</div>" + "</div>" + "<div class=\"widget\">"
					+ "<h3 class=\"widgetheading\" style=\"padding-left: 8px;height: 22px;line-height: 18px;margin-top: 25px;margin-bottom: 20px;color: #000;font-size: 1.8rem\">丨开班时间</h3>"
					+ "<ul class=\"cat\">"
					+ "<li><span style=\"font-size: 1.4rem;color: #000;margin-left: 15px\">大数据开发</span> <span id=\"vardate1\" style=\"display: inline-block;margin: auto;color: #000;position: absolute;left: 40%\"> </span><a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\" style=\"height: 20px;line-height: 20px;padding: 0 15px;background: #f15b1a;position: absolute;right: 0;color: #fff;font-size: 1.4rem; text-decoration: none;margin-right: 30px;\">立即报名</a></li>"
					+ "<li><span style=\"font-size: 1.4rem;color: #000;margin-left: 15px\">交互视觉设计</span> <span id=\"vardate2\" style=\"display: inline-block;margin: auto;color: #000;position: absolute;left: 40%\"> </span><a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\" style=\"height: 20px;line-height: 20px;padding: 0 15px;background: #f15b1a;position: absolute;right: 0;color: #fff;font-size: 1.4rem; text-decoration: none;margin-right: 30px;\">立即报名</a></li>"
					+ "<li><span style=\"font-size: 1.4rem;color: #000;margin-left: 15px\">VR/AR开发</span> <span id=\"vardate3\" style=\"display: inline-block;margin: auto;color: #000;position: absolute;left: 40%\"> </span><a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\" style=\"height: 20px;line-height: 20px;padding: 0 15px;background: #f15b1a;position: absolute;right: 0;color: #fff;font-size: 1.4rem; text-decoration: none;margin-right: 30px;\">立即报名</a></li>"
					+ "</ul>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>"

				

					+ "<!--start footer-->" + "<footer>" + "<div class=\"container\">" + "	<div class=\"row\">"
					+ "		<div class=\"col-lg-3 col-sm-6 col-xs-12 col-md-4\">" + "			<div class=\"widget\">"
					+ "				<h4 align=\"center\" class=\"widgetheading\">关于我们</h4>"
					+ "				<div align=\"center\">"
					+ "				<p><b style=\"font-size: 15px\">启芯教育—专业打造互联网（IT）精英人才</b></p><br/>"
					+ "<p> 学校地址：北京市海淀区杏石口路98号（北京师范大学培训基地)</p><br/>"

					+ "<p>联系方式：招生办公室电话: 010-59460819</p>" + "<p style=\"margin-left: 35px\">王老师:15910865224</p><br/>"
					+ "<p style=\"margin-right:80px\">官方邮箱：qixin@neoit.cn</p>" + "</div>" + "</div>" + "</div>"
					+ "<div class=\"col-lg-3 col-sm-6 col-xs-12 col-md-4\">"
					+ "<div class=\"widget\">"
					+ "<h4 align=\"center\" class=\"widgetheading\">课程介绍</h4>"
					+ "<div align=\"center\">"
					+ "<ul class=\"link-list\">"
					+ "<li>"
					+ "<a href=\"../../dsj.html\" target=\"_blank\">大数据开发</a></li>"
					+ "<br/>"
					+ "<li><a href=\"../../jhsjsj.html\" target=\"_blank\">交互视觉设计</a></li>"
					+ "<br/>"
					+ "<li><a href=\"../../vr.html\" target=\"_blank\">VR/AR开发</a></li>"
					+ "</ul>"
					+ "</div>"
					+ "</div>" + "</div>"
					+ "<div class=\"col-lg-3 col-sm-6 col-xs-12 col-md-4\">"
					+ "<div class=\"widget\">"
					+ "<h4 align=\"center\" class=\"widgetheading\">服务专区</h4>" + "<div align=\"center\">"
					+ "<ul class=\"link-list\">" 
					+ "<li><a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\" >我要报名</a></li>" + "<br/>"
					+ "<li><a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\">付款方式</a></li>" + "<br/>" 
					+ "<li><a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\">乘车路线</a></li>" + "<br/>"
					+ "<li><a href=\"https://tb.53kf.com/code/client/10165030/1\" target=\"_blank\">常见问题</a>"
					+ "</li>"
					+ "</ul>" + "</div>" + "</div>" + "</div>"
					+ "<div class=\"col-lg-3 col-sm-6 col-xs-12 col-md-4\">"
					+ "<div class=\"widget\">"
					+ "<h4 align=\"center\" class=\"widgetheading\">官方微信</h4>"
					+ "<div class=\"footer-ewm fl_left\" align=\"center\">" + "<div class=\"fl_left erweima\">"
					+ "<img src=\"../../img/images/erweima1.jpeg\" width=\"110\" height=\"110\" style=\"display: inline\" alt=\"\"/>"
					+ "<br/>" + "<p>扫一扫，关注我们</p>" + "<div class=\"flickr_badge\"></div>" + "<div class=\"clear\"></div>"
					+ "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "<div class=\"qx-link\">" + "<p>" + "友情链接:"
					+ "<span><a href=\"http://edu.qq.com\" target=\"_blank\">腾讯教育</a></span>" + "<b>|</b>"

					+ "<span><a href=\"http://edu.ifeng.com\" target=\"_blank\">凤凰教育</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://chuanke.baidu.com/\" target=\"_blank\">百度传课</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://jobuy.com/\" target=\"_blank\">人才网</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://www.job5156.com/\" target=\"_blank\">找工作</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://www.hhxx.com.cn/\" target=\"_blank\">好好学习</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://www.studyems.com\" target=\"_blank\">求学快递网</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://book.kongfz.com/\" target=\"_blank\">孔夫子图书网购</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://www.xueda.com/\" target=\"_blank\">学大教育</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://www.51zxw.net\" target=\"_blank\">我要自学网</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://www.udashi.com\" target=\"_blank\">U大师</a></span>" + "<b>|</b>"
					+ "<span><a href=\"http://www.51shiping.com\" target=\"_blank\">我要视频</a></span>" + "</p>" + "</div>"
					+ "</div>" + "<div id=\"sub-footer\">" + "<div class=\"container\">" + "<div class=\"row\">"
					+ "<div class=\"col-lg-12\">" + "<div class=\"copyright\">"
					+ "<p style=\"text-align: center;font-size: 1.5rem\">"
					+ "<span>Copyright © 2017 neoit.cn  All Rights Reserved</span>" + "</p>" + "</div>" + "</div>"
					+ "</div>" + "</div>" + "</div>" + "</footer>" + "</div>"

					+ "<a href=\"#\" class=\"scrollup\" style=\"display: block\">"
					+ "<i class=\"fa fa-angle-up active\"></i>"
					+ "</a>"
					+"<script>(function () {var _53code=document.createElement(\"script\");_53code.src = '//tb.53kf.com/code/code/10165030/1'; var s = document.getElementsByTagName(\"script\")[0];s.parentNode.insertBefore(_53code, s);})();</script>"
					+ "<!-- javascript -->" + "<script src=\"../../js/jquery.js\"></script>"
					+ "<script src=\"../../js/jquery.easing.1.3.js\"></script>"
					+ "<script src=\"../../js/bootstrap.min.js\"></script>"
					+ "<script src=\"../../js/jquery.fancybox.pack.js\"></script>"
					+ "<script src=\"../../js/jquery.fancybox-media.js\"></script>"
					+ "<script src=\"../../js/google-code-prettify/prettify.js\"></script>"
					+ "<script src=\"../../js/portfolio/jquery.quicksand.js\"></script>"
					+ "<script src=\"../../js/portfolio/setting.js\"></script>"
					+ "<script src=\"../../js/jquery.flexslider.js\"></script>"
					+ "<script src=\"../../js/animate.js\"></script>" + "<script src=\"../../js/custom.js\"></script>"
					+ "</body>" + "</html>";

			// 到此HTML新闻尾添加结�??---

			// System.out.println("lon2:" + lon);
			File file = new File(basicpath + news.getType() + "/" + lon + ".html");
			if (!file.exists()) {
				file.createNewFile();
				if (!file.createNewFile()) {
					System.out.println("news下面创建了新文件...");
				}
			}
			// 通过字符流写入到指定文件
			FileOutputStream out = new FileOutputStream(file, true);
			StringBuffer sb = new StringBuffer();
			sb.append(htmlcontent);
			out.write(sb.toString().getBytes("utf-8"));
			out.close();
			map.put("content", htmlcontent);

			// ----------3.补充news的一些数�??
			if (pic != null) { // 添加新闻内容中的图片
				String newsimages = "";
				int fi = 0;
				for (String str : pic) {
					if (fi + 1 < pic.length) {
						newsimages += str + ",";
					} else {
						newsimages += str;
					}
					fi++;
				}
				// System.out.println("newsimages:" + newsimages);
				news.setImages(newsimages);
			}

			news.setHtmlUrl(lon + ".html");
			news.setTitleImage(lon + "." + filetype);
			news.setEnabled(0);
			news.setDeleted(0);
			// 添加新闻
			adminBiz.insertSelective(news);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (news.getType() == 1) {
			return "backment/news/addheadsucc";
		} else {

			return "backment/news/addschosucc";
		}
	}

	// 2.新闻查询(后台功能)
	@RequestMapping(value = "/selectAllNews")
	public String selectAllNews(int page, int type, HttpServletRequest request) {
		try {
			System.out.println("进入selectAllNews....");
			// 2.1普通新闻的查询
			if (page == 0) {
				page = 1;// 设置默认查询页数为1
			}
			int pages = adminBiz.selectNewsPages(type);// 获得总页�??

			System.out.println("总页数pages:" + pages);
			int nextpage = 0;// 设置上一页下一页
			int backpage = 0;

			if (page >= pages && pages != 0) {
				page = pages;
			}
			// 设置下一页
			if (page >= 1 && page < pages) {
				nextpage = page + 1;
			}
			if (pages == page) {
				nextpage = pages;
			}
			// 设置上一页
			if (page > 1 && page <= pages) {
				backpage = page - 1;

			}

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", type);
			map.put("page", (page - 1) * 10);
			List<Edu_news> newsList = null;
			List<Sys_user> createrList = new ArrayList<Sys_user>();
			List<Sys_user> updaterList = new ArrayList<Sys_user>();
			newsList = adminBiz.selectNewsByTyeAndPage(map);
			//根据新闻中的创建者id更新者id查出对应的user传到后台页面显示
			for (Edu_news news : newsList) {
				if(news.getCreateId()!=null){
					Sys_user user=userBiz.selectUserNameById(news.getCreateId());
					createrList.add(user);	
				}
				if(news.getUpdateId()!=null){
					Sys_user user2=userBiz.selectUserNameById(news.getUpdateId());
					updaterList.add(user2);
				}else{
					Sys_user user2=new Sys_user();;
					user2.setRealName("管理员");
					updaterList.add(user2);
				}
			}
		    // 保存数据传到jsp
			request.setAttribute("newsList", newsList);
			request.setAttribute("createrList", createrList);
			request.setAttribute("updaterList", updaterList);
			request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("type", type);
			request.setAttribute("nextpage", nextpage);
			request.setAttribute("backpage", backpage);
			if (type == 1) {
				request.setAttribute("newstype", "头条新闻展示页面");
			}
			if (type == 2) {
				request.setAttribute("newstype", "学院新闻展示页面");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "backment/news/newsshow";
	}

	// 3.根据id删除新闻(后台功能)
	@RequestMapping(value = "/deleteNewsById")
	public  String deleteNewsById(Integer newsid, HttpServletRequest request) {

		try {
			System.out.println("进入deletenews.do....");
			Edu_news news = adminBiz.selectByPrimaryKey(newsid);
			System.out.println("news:" + news);
			if (news != null) {
				// 3.1删除新闻图片
				String newspic = news.getImages();// 获取新闻图片
				if (newspic != null) {
					String[] pics = newspic.split("\\,");
					for (int i = 0; i < pics.length; i++) {
						File file1 = new File(basicpath + "images/" + pics[i]);
						if (file1.exists()) {
							file1.delete();
						}
					}
				}
				// 3.2删除新闻标题图片
				File file2 = new File(basicpath + "images/titleimages/" + news.getTitleImage());
				System.out.println("001:" + file2.getAbsolutePath());
				if (file2.exists()) {
					file2.delete();
				}
				// 3.3删除新闻页面HTML
				File file3 = new File(basicpath + news.getType() + "/" + news.getHtmlUrl());
				System.out.println("001:" + file3.getAbsolutePath());
				if (file3.exists()) {
					file3.delete();
				}
				adminBiz.deleteByPrimaryKey(newsid);
				if (news.getType() == 1) {
					request.setAttribute("deletemsg", "头条新闻删除成功...");
				} else {
					request.setAttribute("deletemsg", "学院新闻删除成功...");
				}
				/*System.out.println("即将跳转到selectAllnews...");
				 selectAllNews(1,news.getType(), null);*/

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		return "backment/news/deletesuccess";
	}

	// 4.根据id修改新闻(后台功能)
	@RequestMapping(value = "/updateNewsById")
	public String updateNewsById(Integer newsid, HttpServletRequest request) {

		try {
			System.out.println("进入deletenews.do....");
			Edu_news news = adminBiz.selectByPrimaryKey(newsid);
			System.out.println("news:" + news);
			if (news != null) {
				// 3.1删除新闻图片
				String newspic = news.getImages();// 获取新闻图片
				if (newspic != null) {
					String[] pics = newspic.split("\\,");
					for (int i = 0; i < pics.length; i++) {
						File file1 = new File(basicpath + "images/" + pics[i]);
						if (file1.exists()) {
							file1.delete();
						}
					}
				}
				// 3.2删除新闻标题图片
				File file2 = new File(basicpath + "images/titleimages/" + news.getTitleImage());
				System.out.println("001:" + file2.getAbsolutePath());
				if (file2.exists()) {
					file2.delete();
				}
				// 3.3删除新闻页面HTML
				File file3 = new File(basicpath + news.getType() + "/" + news.getHtmlUrl());
				System.out.println("001:" + file3.getAbsolutePath());
				if (file3.exists()) {
					file3.delete();
				}
				adminBiz.deleteByPrimaryKey(newsid);
				if (news.getType() == 1) {
					request.setAttribute("deletemsg", "头条新闻删除成功...");
				} else {
					request.setAttribute("deletemsg", "学院新闻删除成功...");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "backment/news/deletesuccess";
	}

	// 5.根据id查询新闻SelectNewsById
	@RequestMapping(value = "/SelectNewsById")
	public String SelectNewsById(Integer newsid, HttpServletRequest request) {

		try {
			if (newsid != null) {
				Edu_news senews = adminBiz.selectByPrimaryKey(newsid);
				// 获取该新闻的内容传到修改界面编辑器中展示
				String filePath = basicpath + senews.getType() + "/"
						+ senews.getHtmlUrl();
				String encoding = "utf-8";
				File file = new File(filePath);
				String newsStr = "";
				if (file.isFile() && file.exists()) { // 判断文件是否存在
					InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格�??
					BufferedReader bufferedReader = new BufferedReader(read);
					String lineTxt = null;
					
					a:while((lineTxt = bufferedReader.readLine())!= null) {
						if(lineTxt.contains("<div id=\"con\">")) {
							String[] newsc = lineTxt.split("<div id=\"con\">");
							newsStr += newsc[1];
							System.out.println("newsStr[1]:"+newsStr);
							if(newsStr.contains("</div></article>")){
								String[] newsc1 = newsStr.split("</div></article>");
								newsStr= newsc1[0];
								break a;
							}
							
						}
						
						if (!lineTxt.contains("</div></article>")&&!lineTxt.contains("<div id=\"con\">")&&!lineTxt.contains("</html>")) {
							newsStr+= lineTxt;
							System.out.println("newsStrnull:"+newsStr);
						} 
						if (lineTxt.contains("</div></article>")) {
							String[] newsc = lineTxt.split("</div></article>");
							newsStr+= newsc[0];
							System.out.println("newsStr[0]:"+newsStr);
						}                	
                 	}
					System.out.println("newsStr:" + newsStr);
					read.close();
						 
				 
			} else {
					System.out.println("找不到指定的文件");
				}
				request.setAttribute("newsContent", newsStr);
				request.setAttribute("news", senews);
     	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "backment/news/updatenews";

	}
	// 6.根据学生id查询学生就业新闻SelectStuNewsById
		@RequestMapping(value = "/SelectStuNewsById")
	public String SelectStuNewsById(Integer stuid, HttpServletRequest request) {

			try {
				if (stuid!= null) {
					Edu_student_job stunews = studentBiz.selectByPrimaryKey(stuid);
					// 获取该新闻的内容传到修改界面编辑器中展示
					String filePath = basicpath+"studentnews/stuhtml/"
							+ stunews.getHtmlUrl();
					String encoding = "utf-8";
					File file = new File(filePath);
					String stunewsStr = "";
					if (file.isFile() && file.exists()) { // 判断文件是否存在
						InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格�??
						BufferedReader bufferedReader = new BufferedReader(read);
						String lineTxt = null;
						
						a:while((lineTxt = bufferedReader.readLine())!= null) {
							if(lineTxt.contains("<div id=\"con\">")) {
								String[] newsc = lineTxt.split("<div id=\"con\">");
								stunewsStr += newsc[1];
								System.out.println("newsStr[1]:"+stunewsStr);
								if(stunewsStr.contains("</div></article>")){
									String[] newsc1 = stunewsStr.split("</div></article>");
									stunewsStr= newsc1[0];
									break a;
								}
								
							}
							
							if (!lineTxt.contains("</div></article>")&&!lineTxt.contains("<div id=\"con\">")&&!lineTxt.contains("</html>")) {
								stunewsStr+= lineTxt;
								System.out.println("newsStrnull:"+stunewsStr);
							} 
							if (lineTxt.contains("</div></article>")) {
								String[] newsc = lineTxt.split("</div></article>");
								stunewsStr+= newsc[0];
								System.out.println("newsStr[0]:"+stunewsStr);
							}                	
	                 	}
						System.out.println("newsStr:" + stunewsStr);
						read.close();
							 
					 
				} else {
						System.out.println("找不到指定的文件");
					}
					request.setAttribute("stunewsStr", stunewsStr);
					request.setAttribute("stunews", stunews);
	     	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "backment/studentnews/updatestunews";

		}
	// 7.根据教师id查询教师新闻,提取新闻html中的内容传到修改页面的编辑器�??
	@RequestMapping(value = "/SelectTeaById")
     public String SelectTeaById(Integer teaid, HttpServletRequest request) {

		try {
			if (teaid!= null) {
				Edu_teachers teacher = teacherBiz.selectByPrimaryKey(teaid);
				// 获取该新闻的内容传到修改界面编辑器中展示
				String filePath = basicpath+"teachernews/teahtml/"
						+ teacher.getHtmlUrl();
				String encoding = "utf-8";
				File file = new File(filePath);
				String teacherStr = "";
				if (file.isFile() && file.exists()) { // 判断文件是否存在
					InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格�??
					BufferedReader bufferedReader = new BufferedReader(read);
					String lineTxt = null;
					
					a:while((lineTxt = bufferedReader.readLine())!= null) {
						if(lineTxt.contains("<div id=\"con\">")) {
							String[] newsc = lineTxt.split("<div id=\"con\">");
							teacherStr += newsc[1];
							System.out.println("teacherStr[1]:"+teacherStr);
							if(teacherStr.contains("</div></article>")){
								String[] newsc1 = teacherStr.split("</div></article>");
								teacherStr= newsc1[0];
								break a;
							}
							
						}
						
						if (!lineTxt.contains("</div></article>")&&!lineTxt.contains("<div id=\"con\">")&&!lineTxt.contains("</html>")) {
							teacherStr+= lineTxt;
							System.out.println("teacherStrnull:"+teacherStr);
						} 
						if (lineTxt.contains("</div></article>")) {
							String[] newsc = lineTxt.split("</div></article>");
							teacherStr+= newsc[0];
							System.out.println("teacherStr[0]:"+teacherStr);
						}                	
                 	}
					System.out.println("teacherStr:" + teacherStr);
					read.close();
						 
				 
			} else {
					System.out.println("找不到指定的文件");
				}
				request.setAttribute("teacherStr", teacherStr);
				request.setAttribute("teacher", teacher);
     	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "backment/teachernews/updateteacher";

	}
}
