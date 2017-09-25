package com.qixin.neoit.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import com.qixin.neoit.biz.StudentBiz;
import com.qixin.neoit.biz.UserBiz;
import com.qixin.neoit.entity.Edu_news;
import com.qixin.neoit.entity.Edu_student_job;
import com.qixin.neoit.entity.Edu_teachers;
import com.qixin.neoit.entity.Sys_user;

@Controller
@RequestMapping(value="stu") // 设置一级路径
@SessionAttributes("")
public class StuWorkNewsController {
	@Resource(name = "studentBiz")
	private StudentBiz studentBiz;
	@Resource(name = "userBiz")
	private UserBiz userBiz;
	//设置新闻html和标题图片保存的路径基本路径(发布时修改路径改这里就行)
	String basicpath="E:/github/neoit/WebContent/pages/news/";
	//String basicpath="/usr/local/tomcat/webapps/neoit/pages/news/";
	
	// 1.上传学员就业新闻(类似上传新闻)
	@RequestMapping(value = "/uploadStuWorkNews")
	public String uploadStuWorkNews(Edu_student_job stunews, String[] pic, String content,
			@RequestParam(value = "smallpicture") MultipartFile smallpicture, Map<String, Object> map,
			HttpServletRequest request) {

		try {
			System.out.println("已经进入添加学员方法uploadStuWorkNews()...");
			// -----------------1.上传新闻缩略图
			// 若标题图片为空则返回
			if (smallpicture.getOriginalFilename().equals("")) {
				request.setAttribute("msg", "请选择新闻标题图片..");
				return "main";
			}

			String filename = smallpicture.getOriginalFilename();// 获取缩略图名
			int index = filename.lastIndexOf(".");
			String filetype = filename.substring(index + 1);// 获得图片后缀
			System.out.println("图片后缀:" + filetype);
			System.out.println("图片名称:" + smallpicture.getOriginalFilename());
			System.out.println("图片smallpicture:" + smallpicture);
			System.out.println("上传图片的类型:" + smallpicture.getContentType());

			// 定义学员展示图的上传类型
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
			// 图片类型不对则返回..
			if (!typelist.contains(filetype)) {
				request.setAttribute("msg", "上传文件类型不对..");
				return "main";
			}

			long lon = new Date().getTime();// 利用当前日期作为 缩略图名 (也用做下面新闻地址)
			System.out.println("lon1:" + lon);
			// 设定图片保存的路径path
			String path = basicpath+"studentnews/titleimages/";
			// 保存文件(两种:1.通过流读取和写入,2.通过MultipartFile的transferTo保存)
			String picpath = path + lon + "." + filetype;
			smallpicture.transferTo(new File(picpath));
			System.out.println("图片上传成功.......");
			request.setAttribute("msg", "图片上传成功1..");
			request.setAttribute("studentxinxi", "学生就业添加完成..");

			// ----------------------2.以下是添加新闻-----------------------------------------
		    stunews.setCreateTime(new Date());// 设定新闻创建时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// 加上HTML头和尾 ,生成HTML页面;
			String htmlcontent;
			// 2.1添加HTML头部
			htmlcontent = "<!DOCTYPE html>"
			        + "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/html\">"
					+ "<head>"
					+ "<meta charset=\"utf-8\">"
					+"<title>启芯教育_90后工程师的摇篮-大数据培训-VR培训-交互视觉设计培训</title>"
					+"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"
					+"<meta name=\"description\" content=\"启芯教育-0基础，0学费入学，签订就业协议保障学生就业薪资。专注于java培训，大数据培训，VR培训，虚拟现实培训，交互设计培训，UI培训。选择启芯教育既是选择新的起点，开创不一样的未来。我们倾尽全力，用教育改变人生。\"/>"
					+"<meta name=\"keywords\" content=\"java培训-大数据培训-VR培训-虚拟现实培训-交互设计培训-UI培训\" />"
					
					+ "<meta name=\"author\" content=\"http://www.cssmoban.com\" />" 
					+ "<!-- css -->"
					+ "<link href=\"../../../css/bootstrap.min.css\" rel=\"stylesheet\" />"
					+ "<link href=\"../../../css/fancybox/jquery.fancybox.css\" rel=\"stylesheet\">"
					+ "<!--<link href=\"../../../css/jcarousel.css\" rel=\"stylesheet\" />-->"
					+ "<link href=\"../../../css/flexslider.css\" rel=\"stylesheet\" />"
					+ "<link href=\"../../../css/style.css\" rel=\"stylesheet\" />"
					+"<link rel=\"stylesheet\" href=\"../../../css/chat.css\"/>"
	
					+ "<!-- Theme skin -->"
					+ "<link href=\"../../../skins/default.css\" rel=\"stylesheet\" />"
					+ "<script type=\"text/javascript\" src=\"../../../js/jquery.min.js\"></script>"
					+ "<script type=\"text/javascript\">"
					+ "$(document).ready(function changSecondKind() {"
					+ "var newhtml =document.getElementById(\"newhtml\").value;"

					+ "$.ajax({" 
					+ "type : \"post\"," 
					+ "url : \"../../../../stu/findStuRecomm.do\","
					+ "data : \"newhtml=\" + newhtml,"
					+ "datatype : \"html\","
					+ "success : function(resu) {"
					+ "var recsec = resu.recomstuslist;" 
					+ "var recomstr = \"\";"

					
					+ "for (var i = 0; i < recsec.length; i++) {"
					+ "var obj = recsec[i];"
					+ "recomstr += '<div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12\">'"
					+ "+ '<dl class=\"dl-horizontal dl_list dl_detail\">'" 
					+ "+ '<dt>'"
					+ "+'<img src=\"/neoit/pages/news/studentnews/titleimages/'+obj.studentImage+'\"'"
					+ "+' style=\"width: 138px; height: 125px\" alt=\"\" class=\"img_hover2\">'" 
					+ "+ '</dt>'"
					+ "+ '<dd>'" 
					+ "+ '<h3 class=\"f4\"'"
					+ "+'	style=\"padding-top: 0px; font-size: 1.6rem; line-height: 1.4; max-height: 44px\">'"
					+ "+ '	<a class=\"c5\" style=\"color: #000; text-decoration: none\"'"
					+ "+'		href=\"/neoit/pages/news/studentnews/stuhtml/'+obj.htmlUrl+'\">'"
					+ "+ obj.title"
					+ "+ '</a>'"
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
					+ "alert(\"执行学员的ajax的方法错误了...\");"
					+ "}"
					+ "});"
					+ "});"
					+"window.onload=function(){" 
					+"var myDate = new Date();"
					+" var mon= myDate.getMonth()+1;"
				 +" var da= myDate.getDate();"
				+"if(da<8){"
					+"document.getElementById(\"vardate1\").innerHTML=mon+\"月8号\";"
					+"document.getElementById(\"vardate2\").innerHTML=mon+\"月18号\";"
					+"document.getElementById(\"vardate3\").innerHTML=mon+\"月28号\";"
						
					+"}"
				+"if(da>=8&&da<18){"
					+"document.getElementById(\"vardate1\").innerHTML=mon+1+\"月8号\";"
					+"document.getElementById(\"vardate2\").innerHTML=mon+\"月18号\";"
					+"document.getElementById(\"vardate3\").innerHTML=mon+\"月28号\";"
						
					+"} "
				 
				+"if(da>=18&&da<=28){"
					+"document.getElementById(\"vardate1\").innerHTML=mon+1+\"月8号\";"
					+"document.getElementById(\"vardate2\").innerHTML=mon+1+\"月18号\";"
					+"document.getElementById(\"vardate3\").innerHTML=mon+\"月28号\";"
						
					+"}" 
				+"if(da>28){"
					+"document.getElementByID(\"vardate1\").innerHTML=mon+1+\"月8号\";"
					+"document.getElementByID(\"vardate2\").innerHTML=mon+1+\"月18号\";"
					+"document.getElementByID(\"vardate3\").innerHTML=mon+1+\"月28号\";"
					+"} "
					 //控制编辑器中的图片
						
					 +"var spans =document.getElementById(\"con\").getElementsByTagName(\"img\");"
			         +"for(var i=0;i<spans.length;i++){"
			    	 +"  spans[i].setAttribute(\"class\",'img-responsive center-block');"
			    	 +"spans[i].setAttribute(\"style\",'width: 100%;height: 100%;');"
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
					// 设置新闻地址html,利用ajax传到后台 查询他的相关推荐
					+ "<input id=\"newhtml\" type=\"hidden\" value=\"" + lon + "\"/>"
					+ "<div id=\"wrapper\">"
					+ "<!-- start header -->" 
					+ "<header>" 
					+ " <div class=\"navbar navbar-default navbar-static-top\">"
					+ "<div class=\"container\">"
					+ "<div class=\"navbar-header\">"
					+ " <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">"
					+ " <span class=\"icon-bar\"></span>" 
					+ " <span class=\"icon-bar\"></span>"
					+ " <span class=\"icon-bar\"></span>"
					+ "</button>"
					+ " <a class=\"navbar-brand\" href=\"/neoit/index.jsp\"><img src=\"../../../img/1.png.png\" alt=\"\"/></a>"
					+ "</div>" 
					+ "<div class=\"navbar-collapse collapse \">"
					+ "<ul class=\"nav navbar-nav\">"
					+ "<li><a href=\"/neoit/index.jsp\">首页</a></li>" + "<li class=\"dropdown \">"
					+ "<a href=\"../../#\" class=\"dropdown-toggle \" data-toggle=\"dropdown\" data-hover=\"dropdown\" data-delay=\"0\" data-close-others=\"false\">课程介绍<b class=\" icon-angle-down\"></b></a>"
					+ " <ul class=\"dropdown-menu\">" + "<li><a href=\"../../../dsj.html\">大数据</a></li>"
					+ "<li><a href=\"/neoit/pages/sjcd.html\">交互视觉设计</a></li>"
					+ "<li><a href=\"../../../vr.html\">VR</a></li>" + "</ul>" + "</li>"
					+ "<li><a href=\"/neoit/pages/sztd.jsp\">师资团队</a></li>"
					+ "<li><a href=\"/neoit/pages/xyjy.jsp\">学员生活</a></li>"
					+"<li><a  href=\"/neoit/pages/gxjy.html\">高薪就业</a></li>"
					+ "<li><a href=\"../../../gywm.html\">关于我们</a></li>"
					
					+ "</ul>" + "</div>" + "</div>" + "</div>"
					+ "</header>" + "<!-- end header -->" + "<section id=\"inner-headline\">"
					+ "<div class=\"container\">" + "<div class=\"row\">" + "<div class=\"col-lg-12\">"
					+ "<ul class=\"breadcrumb\">"
					+ "<li><a href=\"/neoit/index.jsp\"><i class=\"fa fa-home\"></i></a><i class=\"icon-angle-right\"></i></li>"
					+ "<li class=\"active\">学员</li>" + "</ul>" + "</div>" + "</div>" + "</div>" + "</section>"
					+ "<section id=\"content\">" + "<section class=\"container\">" + "<div class=\"row\">"
					+ "<div class=\"col-lg-8\">" + "<article>" + "<div class=\"post-image\">"
					+ "<div class=\"post-heading\">" + "<h3 align=\"center\">" + stunews.getTitle() + "</h3>" // 文章标题
					+ "</div>"

					+ " <div class=\"div_wrap\" align=\"center\">"
					+ "<ul class=\"detail_ul clearfix f3\" style=\"display: inline-block;margin-top: 18px;margin-bottom: 26px;font-size: 1.2rem;list-style: none;text-indent: 0;list-style-position: outside;\">"
					+ " <li style=\"display: inline-block;float: left;padding: 0 14px;\">时间:<span>"
					+ sdf.format(stunews.getCreateTime()) + "</span>" // 发布时间
					+ "</li>"
					+ "<li style=\"display: inline-block;float: left;padding: 0 14px\">作者:<span>"+stunews.getAuthor()+"</span>"
					+ "</li>"
					+ "<li style=\"display: inline-block;float: left;padding: 0 14px\">来源:<span><a href=\"/neoit/pages/xyjy.jsp\">学员</a></span>"
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
					+ "<div class=\"detail_caption  f4 c1\" >"
					+ "<span class=\"icon font-icon-bell\"></span>相关推荐"
					+ "</div>"
					+ "<hr class=\"hidden-xs line_style\">"
				    + "<div id=\"recomnews\" class=\"row tui_jie\">" 
					+ "</div>"
				
					+ "</div>" 
					+ "<div class=\"col-lg-4 col-md-4 hidden-xs hidden-sm\">"
					+ "<div class=\"right-sidebar\">" 
					+ "<div class=\"widget\">"
					+ " <div align=\"center\" style=\"margin-top: 20px\">"
					+ "<a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\"><img src=\"../../../img/images/1495458603018.jpg\" width=\"300\" height=\"142\"></a>"
					+ "<a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\"><img src=\"../../../img/images/1495458821650.jpg\" width=\"300\" height=\"142\"></a>"
					+ "<a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\"><img src=\"../../../img/images/1496737033250.jpg\" width=\"300\" height=\"142\"></a>"
					+ "</div>" + "</div>" + "<div class=\"widget\">"
					+ "<h3 class=\"widgetheading\" style=\"padding-left: 8px;height: 22px;line-height: 18px;margin-top: 25px;margin-bottom: 20px;color: #000;font-size: 1.8rem\">丨开班时间</h3>"
					+ "<ul class=\"cat\">"
					+ "<li><span style=\"font-size: 1.4rem;color: #000;margin-left: 15px\">大数据开发</span> <span id=\"vardate1\" style=\"display: inline-block;margin: auto;color: #000;position: absolute;left: 40%\"> </span><a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\" style=\"height: 20px;line-height: 20px;padding: 0 15px;background: #f15b1a;position: absolute;right: 0;color: #fff;font-size: 1.4rem; text-decoration: none;margin-right: 30px;\">立即报名</a></li>"
					+ "<li><span style=\"font-size: 1.4rem;color: #000;margin-left: 15px\">交互视觉设计</span> <span id=\"vardate2\" style=\"display: inline-block;margin: auto;color: #000;position: absolute;left: 40%\"> </span><a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\" style=\"height: 20px;line-height: 20px;padding: 0 15px;background: #f15b1a;position: absolute;right: 0;color: #fff;font-size: 1.4rem; text-decoration: none;margin-right: 30px;\">立即报名</a></li>"
					+ "<li><span style=\"font-size: 1.4rem;color: #000;margin-left: 15px\">VR/AR开发</span> <span id=\"vardate3\"  style=\"display: inline-block;margin: auto;color: #000;position: absolute;left: 40%\"> </span><a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\" style=\"height: 20px;line-height: 20px;padding: 0 15px;background: #f15b1a;position: absolute;right: 0;color: #fff;font-size: 1.4rem; text-decoration: none;margin-right: 30px;\">立即报名</a></li>"
					+ "</ul>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>"

					

					+ "<!--start footer-->" + "<footer>" + "<div class=\"container\">" + "	<div class=\"row\">"
					+ "		<div class=\"col-lg-3 col-sm-6 col-xs-12 col-md-4\">" + "			<div class=\"widget\">"
					+ "				<h4 align=\"center\" class=\"widgetheading\">关于我们</h4>"
					+ "				<div align=\"center\">"
					+ "				<p><b style=\"font-size: 15px\">启芯教育——专业打造互联网（IT）精英人才</b></p><br/>"
					+ "<p> 学校地址：北京市海淀区杏石口路98号（北京师范大学培训基地）</p><br/>"

					+ "<p>联系方式：招生办公室：010-59460819</p>" + "<p style=\"margin-left: 35px\">王老师：15910865224</p><br/>"
					+ "<p style=\"margin-right:80px\">官方邮箱：qixin@neoit.cn</p>" + "</div>" + "</div>" + "</div>"
					+ "<div class=\"col-lg-3 col-sm-6 col-xs-12 col-md-4\">" + "<div class=\"widget\">"
					+ "<h4 align=\"center\" class=\"widgetheading\">课程介绍</h4>" + "<div align=\"center\">"
					+ "<ul class=\"link-list\">" 
					+ "<li><a href=\"../../../dsj.html\" target=\"_blank\">大数据开发</a></li>" + "<br/>"
					+ "<li><a href=\"../../../jhsjsj.html\" target=\"_blank\">交互视觉设计</a></li>" + "<br/>"
					+ "<li><a href=\"../../../vr.html\" target=\"_blank\">VR/AR开发</a></li>" + "</ul>" + "</div>" + "</div>" + "</div>"
					+ "<div class=\"col-lg-3 col-sm-6 col-xs-12 col-md-4\">" + "<div class=\"widget\">"
					+ "<h4 align=\"center\" class=\"widgetheading\">服务专区</h4>" + "<div align=\"center\">"
					+ "<ul class=\"link-list\">" 
					+ "<li><a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\">我要报名</a></li>" + "<br/>"
					+ "<li><a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\">付款方式</a></li>" + "<br/>" 
					+ "<li><a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\">乘车路线</a></li>" + "<br/>"
					+ "<li><a href=\"https://tb.53kf.com/code/client/10162270/1\" target=\"_blank\">常见问题</a>"
					+ "</li>"
					+ "</ul>" + "</div>" + "</div>" + "</div>"
					+ "<div class=\"col-lg-3 col-sm-6 col-xs-12 col-md-4\">" + "<div class=\"widget\">"
					+ "<h4 align=\"center\" class=\"widgetheading\">官方微信</h4>"
					+ "<div class=\"footer-ewm fl_left\" align=\"center\">" + "<div class=\"fl_left erweima\">"
					+ "<img src=\"../../../img/images/erweima1.jpeg\" width=\"110\" height=\"110\" style=\"display: inline\" alt=\"\"/>"
					+ "<br/>" + "<p>扫一扫，关注我们</p>" + "<div class=\"flickr_badge\"></div>" + "<div class=\"clear\"></div>"
					+ "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "<div class=\"qx-link\">" + "<p>" + "友情链接："
					+ "<span><a href=\"http://edu.qq.com\" target=\"_blank\">腾讯教育</a></span>" + "<b>丨</b>"

					+ "<span><a href=\"http://edu.ifeng.com\" target=\"_blank\">凤凰教育</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://chuanke.baidu.com/\" target=\"_blank\">百度传课</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://jobuy.com/\" target=\"_blank\">人才网</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://www.job5156.com/\" target=\"_blank\">找工作</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://www.hhxx.com.cn/\" target=\"_blank\">好好学习</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://www.studyems.com\" target=\"_blank\">求学快递网</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://book.kongfz.com/\" target=\"_blank\">孔夫子图书网购</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://www.xueda.com/\" target=\"_blank\">学大教育</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://www.51zxw.net\" target=\"_blank\">我要自学网</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://www.udashi.com\" target=\"_blank\">U大师</a></span>" + "<b>丨</b>"
					+ "<span><a href=\"http://www.51shiping.com\" target=\"_blank\">我要视频</a></span>" + "</p>" + "</div>"
					+ "</div>" + "<div id=\"sub-footer\">" + "<div class=\"container\">" + "<div class=\"row\">"
					+ "<div class=\"col-lg-12\">" + "<div class=\"copyright\">"
					+ "<p style=\"text-align: center;font-size: 1.5rem\">"
					+ "<span>Copyright © 2017 neoit.cn  All Rights Reserved</span>" + "</p>" + "</div>" + "</div>"
					+ "</div>" + "</div>" + "</div>" + "</footer>" + "</div>"

					+ "<a href=\"#\" class=\"scrollup\" style=\"display: block\">"
					+ "<i class=\"fa fa-angle-up active\"></i>" + "</a>"
					+"<script>(function () {var _53code=document.createElement(\"script\");_53code.src = '//tb.53kf.com/code/code/10162270/1'; var s = document.getElementsByTagName(\"script\")[0];s.parentNode.insertBefore(_53code, s);})();</script>"
					+ "<!-- javascript -->"
					+ "<script src=\"../../../js/jquery.js\"></script>"
					+ "<script src=\"../../../js/jquery.easing.1.3.js\"></script>"
					+ "<script src=\"../../../js/bootstrap.min.js\"></script>"
					+ "<script src=\"../../../js/jquery.fancybox.pack.js\"></script>"
					+ "<script src=\"../../../js/jquery.fancybox-media.js\"></script>"
					+ "<script src=\"../../../js/google-code-prettify/prettify.js\"></script>"
					+ "<script src=\"../../../js/portfolio/jquery.quicksand.js\"></script>"
					+ "<script src=\"../../../js/portfolio/setting.js\"></script>"
					+ "<script src=\"../../../js/jquery.flexslider.js\"></script>"
					+ "<script src=\"../../../js/animate.js\"></script>"
					+ "<script src=\"../../../js/custom.js\"></script>" 
					+ "</body>"
					+ "</html>";

			// 到此HTML新闻尾添加结束---

			System.out.println("lon2:" + lon);
			File file = new File(basicpath+"studentnews/stuhtml/" + lon + ".html");
			if (!file.exists()) {
				file.createNewFile();
				if (!file.createNewFile()) {
					System.out.println("stunews下面创建了新文件...");
				}
			}
			// 通过字符流写入到指定文件
			FileOutputStream out = new FileOutputStream(file, true);
			StringBuffer sb = new StringBuffer();
			sb.append(htmlcontent);
			out.write(sb.toString().getBytes("utf-8"));
			out.close();
			map.put("content", htmlcontent);

			// ----------3.补充stunews的一些数据
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
				System.out.println("newsimages:" + newsimages);
				stunews.setImages(newsimages);
			}

			stunews.setHtmlUrl(lon + ".html");
			stunews.setStudentImage(lon + "." + filetype);
			stunews.setEnabled(0);
			stunews.setDeleted(0);
			// 添加学员新闻
			studentBiz.insertSelective(stunews);

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

		System.out.println("Done");

		 return "backment/studentnews/addstusucc";

	}

	// 2.学员列表查询(后台功能)
	@RequestMapping(value = "/selectAllStus")
	public String selectAllStus(int page, HttpServletRequest request) {
		try {
			System.out.println("进入selectAllStus....");
			// 2.1普通新闻的查询
			if (page == 0) {
				page = 1;// 设置默认查询页数为1
			}
			int pages = studentBiz.selectStuPages();// 获得总页数

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
			System.out.println("page的值是:" + page);
			List<Edu_student_job> stuList = null;
			stuList = studentBiz.selectStuBypage((page - 1) * 10);
			
			/* List<Sys_user> createrList = new ArrayList<Sys_user>();
			 List<Sys_user> updaterList = new ArrayList<Sys_user>();
			//根据新闻中的创建者id更新者id查出对应的user真实姓名传到后台页面显示(后台暂时没显示,这里就不查了)
			for (Edu_student_job stu : stuList) {
				if(stu.getCreateId()!=null){
					Sys_user user=userBiz.selectUserNameById(Integer.parseInt(stu.getCreateId()));
					createrList.add(user);	
				}
				if(stu.getUpdateId()!=null){
					Sys_user user2=userBiz.selectUserNameById(stu.getUpdateId());
					updaterList.add(user2);
				}else{
					Sys_user user2=new Sys_user();
					user2.setRealName("无");
					updaterList.add(user2);
				}
			}
			
			request.setAttribute("createrList", createrList);
			request.setAttribute("updaterList", updaterList);*/
			
			
			// 保存数据传到jsp
			request.setAttribute("stuList", stuList);
	    	request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("nextpage", nextpage);
			request.setAttribute("backpage", backpage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "backment/studentnews/stunewsshow";
	}

	// 3.根据id删除学员信息(后台功能)
	@RequestMapping(value = "/deleteStusById")
	public String deleteStusById(Integer stuid) {

		try {
			
			Edu_student_job stu = studentBiz.selectByPrimaryKey(stuid);
			if (stu != null) {
				// 3.1删除新闻图片
				String newspic = stu.getImages();// 获取新闻图片
				if (newspic != null) {
					String[] pics = newspic.split("\\,");
					for (int i = 0; i < pics.length; i++) {
						File file1 = new File(basicpath+"images/" + pics[i]);
						if (file1.exists()) {
							file1.delete();
						}
					}
				}
				// 3.2删除新闻标题图片
				File file2 = new File(
						basicpath+"studentnews/titleimages/" + stu.getStudentImage());
				System.out.println("stu001:" + file2.getAbsolutePath());
				if (file2.exists()) {
					file2.delete();
				}
				// 3.3删除新闻页面HTML
				File file3 = new File(
						basicpath+"studentnews/stuhtml/" + stu.getHtmlUrl());
				System.out.println("stu002:" + file3.getAbsolutePath());
				if (file3.exists()) {
					file3.delete();
				}
				studentBiz.deleteByPrimaryKey(stuid);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "backment/studentnews/deletesuccess";
	}

	//4.利用ajax查询学员新闻的相关推荐
	@ResponseBody
	@RequestMapping(value="/findStuRecomm")
	public Map<String, Object> findStuRecomm(String newhtml){
		Map<String, Object> map = new HashMap<String, Object>();		
		System.out.println("第三名给你几个客人");
		try {			
			if (newhtml!= null) {
			    int stuid = studentBiz.selectStuByhtmurl(newhtml+".html").getId();
				// 查询相关推荐
				List<Edu_student_job> recomstuslist = studentBiz.findRecomStus(stuid);
				map.put("recomstuslist", recomstuslist);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	// 5.学员列表查询(前台页面)
	@RequestMapping(value = "/selectStusWork")
	public String selectStusWork(int page, HttpServletRequest request) {
		try {
			System.out.println("进入selectStusWork....");
			// 2.1普通新闻的查询
			if (page == 0) {
				page = 1;// 设置默认查询页数为1
			}
			int pages = studentBiz.selectStusWorkPages();// 获得总页数

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
			System.out.println("page的值是:" + page);
			List<Edu_student_job> stuList = null;
			stuList = studentBiz.selectStusWorkBypage((page - 1) * 8);
			System.out.println("stuList长度:"+stuList.size());
			// 保存数据传到jsp
			request.setAttribute("stuList", stuList);
			request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("nextpage", nextpage);
			request.setAttribute("backpage", backpage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "pages/xyjy";
	}
	
	
	
	

}
