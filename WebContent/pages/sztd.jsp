<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>
<!DOCTYPE html>
<html lang="en">
<head>
 <base href="<%=basePath%>">
<meta charset="utf-8">
<title>启芯教育_90后工程师的摇篮-大数据培训-VR培训-交互视觉设计培训</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="启芯教育-0基础，0学费入学，签订就业协议保障学生就业薪资。专注于java培训，大数据培训，VR培训，虚拟现实培训，交互设计培训，UI培训。选择启芯教育既是选择新的起点，开创不一样的未来。我们倾尽全力，用教育改变人生。" />
<meta name="keywords" content="java培训-大数据培训-VR培训-虚拟现实培训-交互设计培训-UI培训" />

<meta name="author" content="http://www.cssmoban.com" />
<!-- css -->
<link href="/neoit/pages/css/bootstrap.min.css" rel="stylesheet" />
<link href="/neoit/pages/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<!--<link href="css/jcarousel.css" rel="stylesheet" />-->
<link href="/neoit/pages/css/flexslider.css" rel="stylesheet" />
<link href="/neoit/pages/css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="/neoit/pages/css/chat.css"/>
<!-- Theme skin -->
<link href="/neoit/pages/skins/default.css" rel="stylesheet" />
<script type="text/javascript" src="/neoit/pages/js/jquery.min.js"></script>
<script type="text/javascript">
function searchForm(page){
	window.location.href="tea/selectTeacher.do?page="+page;
	
}

</script>
</head>
  <%  
 if (request.getAttribute("teacherList")==null ){%>
 <jsp:forward page="../tea/selectTeacher.do?page=1" ></jsp:forward>
 <%}%> 
<body>
<div id="wrapper">

	<!-- start header -->
	<header>
		<div class="navbar navbar-default navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/neoit/index.jsp"><img src="/neoit/pages/img/1.png.png" alt=""/></a>
				</div>
				<div class="navbar-collapse collapse " style="height: auto" >

					<ul class="nav navbar-nav">
						<li><a href="/neoit/index.jsp">首页</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">课程介绍<b class=" icon-angle-down"></b></a>
							<ul class="dropdown-menu">
								<li><a href="/neoit/pages/dsj.html">大数据</a></li>
								<li><a href="/neoit/pages/jhsjsj.html">交互视觉设计</a></li>
								<li><a href="/neoit/pages/vr.html">VR</a></li>
							</ul>
						</li>
						<li class="active"><a href="/neoit/pages/sztd.jsp">师资团队</a></li>
						<li><a href="/neoit/pages/xyjy.jsp">学员生活</a></li>
						<li><a  href="/neoit/pages/gxjy.html">高薪就业</a></li>
						<li><a href="/neoit/pages/gywm.html">关于我们</a></li>
						
					</ul>
				</div>
			</div>
		</div>
	</header>
	<!--end header-->
	<section id="inner-headline">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<ul class="breadcrumb">
					<li><a href="/neoit/index.jsp"><i class="fa fa-home"></i></a><i class="icon-angle-right"></i></li>
					<!-- <li><a href="/neoit/index.jsp">师资团队</a><i class="icon-angle-right"></i></li> -->
					<li class="active">师资团队</li>
				</ul>
			</div>
		</div>
		
	</div>
	</section>
	<section id="content" >
	<img src="/neoit/pages/img/images/contact3.jpg"  class="img-responsive center-block" style="margin-bottom:20px;width: 100%;height: 100%;">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row" style="margin-top:20px;" >
				<!-- 输出置顶的讲师 -->
					<c:forEach var="teacher" items="${QTZDteaList}" varStatus="i">
						<div class="col-lg-3 col-sm-6" >
								   <div class="box">
									   <div class="box-gray aligncenter">
										   <!--<h4>启芯一</h4>-->
										   <a href="/neoit/pages/news/teachernews/teahtml/${teacher.htmlUrl }" target="_blank" style="text-decoration: none">
											   <div class="icon">
												   <!--<i class="fa fa-tasks fa-3x"></i>-->
												   <img src="/neoit/pages/news/teachernews/titleimages/${teacher.teacherImage}"  style="width:300px;height:230px" alt="">
											   </div>
											   <div style="font-size: 1.5rem;height:120px;line-height:2;overflow: hidden;text-overflow: ellipsis;color:#666666;text-align:center;">
											   <p style="color:#000000;font-weight:400;">金牌讲师:  ${teacher.name }</p>
											   <p style="font-size: 15px;">职位:  ${teacher.job}</p>
											   <p style="font-size: 13px;">授课风格:  ${teacher.teachingStyle}</p>
											 
											   </div>
										   </a>
									   </div>
									   <!-- <div class="box-bottom">
									   <a href="news/2/1502936788778.html" target="_blank">了解更多</a>
									   </div> -->
								   </div>
							   </div>
					</c:forEach>
					<!-- 普通讲师 -->
					<c:forEach var="teacher" items="${teacherList}" varStatus="i">
						<div class="col-lg-3 col-sm-6" >
								   <div class="box">
									   <div class="box-gray aligncenter">
										   <!--<h4>启芯一</h4>-->
										   <a href="/neoit/pages/news/teachernews/teahtml/${teacher.htmlUrl }" target="_blank" style="text-decoration: none">
											   <div class="icon">
												   <!--<i class="fa fa-tasks fa-3x"></i>-->
												   <img src="/neoit/pages/news/teachernews/titleimages/${teacher.teacherImage}"  style="width:300px;height:230px" alt="">
											   </div>
											   <div style="font-size: 1.5rem;height:120px;line-height:2;overflow: hidden;text-overflow: ellipsis;color:#666666;text-align:center;">
											   <p style="color:#000000;font-weight:400;">金牌讲师:  ${teacher.name }</p>
											   <p style="font-size: 15px;">职位:  ${teacher.job}</p>
											   <p style="font-size: 13px;">授课风格:  ${teacher.teachingStyle}</p>
											 
											   </div>
										   </a>
									   </div>
									   <!-- <div class="box-bottom">
									   <a href="news/2/1502936788778.html" target="_blank">了解更多</a>
									   </div> -->
								   </div>
							   </div>
					</c:forEach>
			
			 </div>
			 		 <!------分页样式------>
			<div class="text-center page_wrap border_t">
				<nav>
					<ul class="pagination pag_ul pagination-lg">
						<li>
							<a href="javascript:searchForm(${backpage})" class="pre_next prev">上一页</a>
						</li>
						<c:forEach var="i" begin="1" end="${pages}">
							<li class="hidden-xs currentPage">
								<a href="javascript:searchForm(${i})">${i}</a>	
							</li>
						</c:forEach>
						
						<li>
							<a href="javascript:searchForm(${nextpage})" class="pre_next next_page">下一页</a>
							<div class="pre_next page-all hidden-xs f1">共${pages}页</div>
						</li>
					</ul>
				</nav>
			</div>
			</div>
		</div>
	</div>
	</section>



	<!--start footer-->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-sm-6 col-xs-12 col-md-4">
					<div class="widget">
						<h4 align="center"
							class="widgetheading">关于我们</h4>
						<div align="center">
							<p><b style="font-size: 15px">启芯教育——专业打造互联网（IT）精英人才</b></p><br/>
							<p> 学校地址：北京市海淀区杏石口路98号（北京师范大学培训基地）</p><br/>

							<p>联系方式：招生办公室：010-59460819</p>
							<p style="margin-left: 35px">王老师：15910865224</p><br/>
							<p style="margin-right:80px">官方邮箱：qixin@neoit.cn</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 col-xs-12 col-md-4">
					<div class="widget">
						<h4 align="center" class="widgetheading">课程介绍</h4>
						<div align="center">
							<ul class="link-list">
								<li><a href="/neoit/pages/dsj.html" target="_blank">大数据开发</a></li>
								<br/>
								<li><a href="/neoit/pages/jhsjsj.html" target="_blank">交互视觉设计</a></li>
								<br/>
								<li><a href="/neoit/pages/vr.html" target="_blank">VR/AR开发</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 col-xs-12 col-md-4">
					<div class="widget">
						<h4 align="center" class="widgetheading">服务专区</h4>
						<div align="center">
							<ul class="link-list">
								<li><a href="https://tb.53kf.com/code/client/10162270/1" target="_blank">我要报名</a></li>
								<br/>
								<li><a href="https://tb.53kf.com/code/client/10162270/1" target="_blank">付款方式</a></li>
								<br/>
								<li><a href="https://tb.53kf.com/code/client/10162270/1" target="_blank">乘车路线</a></li>
								<br/>
								<li><a href="https://tb.53kf.com/code/client/10162270/1" target="_blank">常见问题</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 col-xs-12 col-md-4">
					<div class="widget">
						<h4 align="center" class="widgetheading">官方微信</h4>
						<div class="footer-ewm fl_left" align="center">
							<div class="fl_left erweima">
								<img src="/neoit/pages/img/images/erweima1.jpeg" width="110" height="110" style="display: inline" alt=""/>
								<br/>
								<p>扫一扫，关注我们</p>
								<div class="flickr_badge"></div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="qx-link ">
				<p>
					友情链接：
					<span><a href="http://edu.qq.com" target="_blank">腾讯教育</a></span>
					<b>丨</b>

					<span><a href="http://edu.ifeng.com" target="_blank">凤凰教育</a></span>
					<b>丨</b>
					<span><a href="http://chuanke.baidu.com/" target="_blank">百度传课</a></span>
					<b>丨</b>
					<span><a href="http://jobuy.com/" target="_blank">人才网</a></span>
					<b>丨</b>
					<span><a href="http://www.job5156.com/" target="_blank">找工作</a></span>
					<b>丨</b>
					<span><a href="http://www.hhxx.com.cn/" target="_blank">好好学习</a></span>
					<b>丨</b>
					<span><a href="http://www.studyems.com" target="_blank">求学快递网</a></span>
					<b>丨</b>
					<span><a href="http://book.kongfz.com/" target="_blank">孔夫子图书网购</a></span>
					<b>丨</b>
					<span><a href="http://www.xueda.com/" target="_blank">学大教育</a></span>
					<b>丨</b>
					<span><a href="http://www.51zxw.net" target="_blank">我要自学网</a></span>
					<b>丨</b>
					<span><a href="http://www.udashi.com" target="_blank">U大师</a></span>
					<b>丨</b>
					<span><a href="http://www.51shiping.com" target="_blank">我要视频</a></span>
				</p>
			</div>
		</div>
		<div id="sub-footer">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="copyright">
							<p style="text-align: center;font-size: 1.5rem">
								<span>Copyright © 2017 <a href="index.html">neoit.cn</a>  All Rights Reserved</span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</div>

<a href="#" class="scrollup" style="display: block">
	<i class="fa fa-angle-up active"></i>
</a>

<script>(function () {var _53code=document.createElement("script");_53code.src = '//tb.53kf.com/code/code/10162270/1'; var s = document.getElementsByTagName("script")[0];s.parentNode.insertBefore(_53code, s);})();</script>


<!-- javascript -->
<script src="/neoit/pages/js/jquery.js"></script>
<script src="/neoit/pages/js/jquery.easing.1.3.js"></script>
<script src="/neoit/pages/js/bootstrap.min.js"></script>
<script src="/neoit/pages/js/jquery.fancybox.pack.js"></script>
<script src="/neoit/pages/js/jquery.fancybox-media.js"></script>
<script src="/neoit/pages/js/google-code-prettify/prettify.js"></script>
<script src="/neoit/pages/js/portfolio/jquery.quicksand.js"></script>
<script src="/neoit/pages/js/portfolio/setting.js"></script>
<script src="/neoit/pages/js/jquery.flexslider.js"></script>
<script src="/neoit/pages/js/animate.js"></script>
<script src="/neoit/pages/js/custom.js"></script>
</body>
</html>