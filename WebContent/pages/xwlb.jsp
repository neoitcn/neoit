<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<title>启芯教育_90后工程师的摇篮-大数据培训-VR培训-交互视觉设计培训</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="启芯教育-0基础，0学费入学，签订就业协议保障学生就业薪资。专注于java培训，大数据培训，VR培训，虚拟现实培训，交互设计培训，UI培训。选择启芯教育既是选择新的起点，开创不一样的未来。我们倾尽全力，用教育改变人生。" />
<meta name="keywords" content="java培训-大数据培训-VR培训-虚拟现实培训-交互设计培训-UI培训" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="http://www.cssmoban.com" />
<!-- css -->
<link href="/neoit/pages/css/bootstrap.min.css" rel="stylesheet" />
<link href="/neoit/pages/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<!--<link href="/neoit/pages/css/jcarousel.css" rel="stylesheet" />-->
<link href="/neoit/pages/css/flexslider.css" rel="stylesheet" />
<link href="/neoit/pages/css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="/neoit/pages/css/chat.css"/>
<!-- Theme skin -->
<link href="/neoit/pages/skins/default.css" rel="stylesheet" />
<script type="text/javascript" src="/neoit/pages/js/jquery.min.js"></script>
<script type="text/javascript">
function searchForm(page,type){
	window.location.href="index/SelectMoreNews.do?page="+page+"&type="+type;
	
};
window.onload=function(){ 
	 var myDate = new Date();
	 var mon= myDate.getMonth()+1; 
	 var da= myDate.getDate();
	if(da<8){
		document.getElementById("vardate1").innerHTML=mon+"月8号";
		document.getElementById("vardate2").innerHTML=mon+"月18号";
		document.getElementById("vardate3").innerHTML=mon+"月28号";
			
	} 
	if(da>=8&&da<18){
		document.getElementById("vardate1").innerHTML=mon+1+"月8号";
		document.getElementById("vardate2").innerHTML=mon+"月18号";
		document.getElementById("vardate3").innerHTML=mon+"月28号";
			
	} 
	 
	if(da>=18&&da<=28){
		document.getElementById("vardate1").innerHTML=mon+1+"月8号";
		document.getElementById("vardate2").innerHTML=mon+1+"月18号";
		document.getElementById("vardate3").innerHTML=mon+"月28号";
			
	} 
	if(da>28){
		document.getElementByID("vardate1").innerHTML=mon+1+"月8号";
		document.getElementByID("vardate2").innerHTML=mon+1+"月18号";
		document.getElementByID("vardate3").innerHTML=mon+1+"月28号";
	} 
} 

</script>
</head>


<body>
 <%  
 if (request.getAttribute("newsList")==null ){%>
 <jsp:forward page="../index/SelectMoreNews.do?page=1&type=2" ></jsp:forward>
 <%}%>
 
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
						<li><a href="/neoit/pages/sztd.jsp">师资团队</a></li>
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
					<li class="active">新闻</li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<div id="content">
	<div class="container">
		<div class="row">
			<!----------右侧内容------------>
			<div class="col-lg-8">
				<c:forEach var="news" items="${newsList}">
				   <div>
						<dl class="dl-horizontal dl_list dl_detail">
							<dt><img src="/neoit/pages/news/images/titleimages/${news.titleImage}"  alt="" class="img_hover2" style="margin-top: 20px;height:162px;width:178px;"></dt>
							<dd>
								<h3 class="f4" style="padding-top: 0px;font-size: 1.6rem;line-height: 1.4;max-height: 44px">
								<a class="c5" style="color: #000;text-decoration: none" href="pages/news/2/${news.htmlUrl}">${news.title}</a></h3>
								<p class="f2_1 c2 hidden-xs hidden-sm" style="max-height: 64px;line-height: 1.5;margin-top: 10px;overflow: hidden;text-overflow: ellipsis;color: #666;font-size: 1.4rem;">${news.resume}</p>
								<div class="clearfix f3">
								<span class="yd_right list_yd_right fa fa-android"><span style="margin-left: 20px">
							   <fmt:formatDate pattern="yyyy-MM-dd"
							   value="${news.createTime}" />
								</span></span>
								</div>
							</dd>
						</dl>
					</div>
				    <hr/>
             </c:forEach>   
			

			

			
				<!------分页样式------>
			<div class="text-center page_wrap border_t">
				<nav>
					<ul class="pagination pag_ul pagination-lg">
						<li>
							<a href="javascript:searchForm(${backpage},2)" class="pre_next prev">上一页</a>
						</li>
						<c:forEach var="i" begin="1" end="${pages}">
							<li class="hidden-xs currentPage">
								<a href="javascript:searchForm(${i},2)">${i}</a>
							</li>
						</c:forEach>
						<li>
							<a href="javascript:searchForm(${nextpage},2)" class="pre_next next_page">下一页</a>
							<div class="pre_next page-all hidden-xs f1">共${pages}页</div>
						</li>
					</ul>
				</nav>
			</div>
			</div>
			<!-----左侧内容------>
			<div class="col-lg-4 col-md-4 hidden-xs hidden-sm">
				<div class="right-sidebar">
				<div class="widget">
					 <div align="center" style="margin-top: 20px">
						 <a href="https://tb.53kf.com/code/client/10162270/1" target="_blank"><img src="/neoit/pages/img/images/1495458603018.jpg" ></a>
						 <a href="https://tb.53kf.com/code/client/10162270/1" target="_blank"><img src="/neoit/pages/img/images/1495458821650.jpg" ></a>
						 <a href="https://tb.53kf.com/code/client/10162270/1" target="_blank"><img src="/neoit/pages/img/images/1496737033250.jpg" ></a>
					 </div>
				</div>
				<div class="widget">
					<h3 class="widgetheading" style="padding-left: 8px;height: 22px;line-height: 18px;margin-top: 25px;margin-bottom: 20px;color: #000;font-size: 1.8rem">丨开班时间</h3>
					<ul class="cat">
					    <li>
							<span style="font-size: 1.4rem;color: #000;margin-left: 15px">大数据开发</span>
							<span   id="vardate1" style="display: inline-block;margin: auto;color: #000;position: absolute;left: 45%"> </span>
							<a href="https://tb.53kf.com/code/client/10162270/1" target="_blank" style="height: 20px;line-height: 20px;padding: 0 15px;background: #f15b1a;position: absolute;right: 0;color: #fff;font-size: 1.4rem; text-decoration: none;margin-right: 30px">立即报名</a>
						</li>
						<li>
							<span style="font-size: 1.4rem;color: #000;margin-left: 15px">交互视觉设计</span>
							<span  id="vardate2" style="display: inline-block;margin: auto;color: #000;position: absolute;left: 45%"></span>
							<a href="https://tb.53kf.com/code/client/10162270/1" target="_blank" style="height: 20px;line-height: 20px;padding: 0 15px;background: #f15b1a;position: absolute;right: 0;color: #fff;font-size: 1.4rem; text-decoration: none;margin-right: 30px">立即报名</a>
						</li>
						<li>
							<span style="font-size: 1.4rem;color: #000;margin-left: 15px">VR/AR开发</span>
							<span   id="vardate3" style="display: inline-block;margin: auto;color: #000;position: absolute;left: 45%"></span>
							<a href="https://tb.53kf.com/code/client/10162270/1" target="_blank" style="height: 20px;line-height: 20px;padding: 0 15px;background: #f15b1a;position: absolute;right: 0;color: #fff;font-size: 1.4rem; text-decoration: none;margin-right: 30px">立即报名</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		</div>
	</div>



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
		<div class="qx-link">
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