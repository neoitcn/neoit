<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>启芯教育</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<!-- css -->
<link href="pages/fybcss/index.css" rel="stylesheet" type="text/css">

<link href="pages/css/bootstrap.min.css" rel="stylesheet" />
<link href="pages/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<!--<link href="pages/css/jcarousel.css" rel="stylesheet" />-->
<link href="pages/css/flexslider.css" rel="stylesheet" />
<link href="pages/css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="pages/css/chat.css" />
<link href="<%=basePath %>/common/images/default/favicon.ico" rel="shortcut icon" type="image/x-icon"/> 

<!-- Theme skin -->
<link href="pages/skins/default.css" rel="stylesheet" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
 <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<script type="text/javascript" src="pages/js/jquery.min.js"></script>
</head>
<%
	if (request.getAttribute("headnewslist") == null) {
%>
<jsp:forward page="index/SelectAllIndexContent.do"></jsp:forward>
<%
	}
%>
<body>

	<div id="wrapper">
		<!-- start header -->
		<header>
			<div class="navbar navbar-default navbar-static-top ">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index.jsp"><img
							src="pages/img/1.png.png" alt="" /></a>
					</div>
					<div class="navbar-collapse collapse " style="height: auto">

						<ul class="nav navbar-nav">
							<li class="active"><a href="index.jsp">首页</a></li>
							<li class="dropdown"><a href="pages/#"
								class="dropdown-toggle " data-toggle="dropdown"
								data-hover="dropdown" data-delay="0" data-close-others="false">课程介绍<b
									class=" icon-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li><a href="pages/dsj.html">大数据</a></li>
									<li><a href="pages/jhsjsj.html">交互视觉设计</a></li>
									<li><a href="pages/vr.html">VR</a></li>
								</ul></li>
							<li><a href="pages/sztd.jsp">师资团队</a></li>
							<li><a href="pages/xyjy.jsp">学员生活</a></li>
							<li><a href="/neoit/pages/gxjy.html">高薪就业</a></li>
							<li><a href="pages/gywm.html">关于我们</a></li>

						</ul>
					</div>
				</div>
			</div>
		</header>
		<!--end header-->

		<section id="featured">
			<!--start slider-->
			<div class="container22">
				<div class="row">
					<div class="col-lg-12">
						<!--slider-->
						<div id="main-slider" class="flexslider">
							<ul class="slides">
								<!-- 输出头条新闻 -->
								<c:forEach var="headnews" items="${headnewslist}" varStatus="i">
									<c:if test="${i['index']<5}">
										<li class="flex-active-slide"
											style="width: 100%; height: 100%; float: left; margin-right: -100%; position: relative; display: none">
											<a href="pages/news/1/${headnews.htmlUrl}" target="_blank"><img
												src="pages/news/images/titleimages/${headnews.titleImage}"
												class="img-responsive lb1"
												style="width: 100%; height: 400px;" alt="" /></a>
										</li>
									</c:if>
								</c:forEach>
							</ul>
							<ul class="flex-direction-nav">
								<li><a class="flex-prev" href="#">Previous</a></li>
								<li><a class="flex-next" href="#">Next</a></li>
							</ul>
						</div>
						<!--end slider-->

					</div>
				</div>
			</div>
		</section>
		<section class="callaction">
			<div class="container">
				<div class="row">
					<div class="col-lg-12" style="margin-top: -20px;">
						<div class="big-cta">
							<div class="cta-text">
								<h2 align="center">
									<span>每一条</span> 新闻都是头条
								</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section id="content">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 ">
						<div class="row">
							<!-- 置顶新闻显示 -->
							<c:forEach var="zdnews" items="${zdcollegenewslist}"
								varStatus="i">
								<div class="col-lg-3 col-sm-6 col-xs-12 col-md-4">
									<div class="box">
										<div class="box-gray aligncenter">
											<!--<h4>启芯一</h4>-->
											<a href="pages/news/2/${zdnews.htmlUrl }" target="_blank"
												style="text-decoration: none">
												<div class="icon">
													<!--<i class="fa fa-tasks fa-3x"></i>-->
													<img
														src="pages/news/images/titleimages/${zdnews.titleImage}"
														style="width: 300px; height: 200px" alt="" />
												</div>
												<p
													style="font-size: 1.5rem; color: #666666; height: 40px; line-height: 1.5; overflow: hidden; text-overflow: ellipsis">${zdnews.title}</p>
											</a>

										</div>
									</div>
								</div>
							</c:forEach>
							<c:forEach var="colnews" items="${collegenewslist}" varStatus="i">


								<c:if test="${i['index']<8-zdcollegenewslist.size()}">
									<div class="col-lg-3 col-sm-6 col-xs-12 col-md-4">
										<div class="box">
											<div class="box-gray aligncenter">
												<!--<h4>启芯一</h4>-->
												<a href="pages/news/2/${colnews.htmlUrl}" target="_blank"
													style="text-decoration: none">
													<div class="icon">
														<!--<i class="fa fa-tasks fa-3x"></i>-->
														<img
															src="pages/news/images/titleimages/${colnews.titleImage}"
															style="width: 300px; height: 200px" alt="" />
													</div>
													<p
														style="font-size: 1.5rem; color: #666666; height: 40px; line-height: 1.5; overflow: hidden; text-overflow: ellipsis">${colnews.title}</p>
												</a>

											</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<div class="more"
							style="text-align: right; margin-top: -20px; margin-bottom: -20px;">

							<a href="pages/xwlb.jsp" target="_blank"
								style="text-decoration: none; color: #68A4C4;"> <!-- <span style="cursor: pointer">
						  <img src="pages/img/jt.png" alt=""/>
						  </span><br/> --> 查看更多>>
							</a>
						</div>


					</div>
				</div>
			</div>



			<section class="callaction">
				<div class="container">
					<div class="row">
						<div class="col-lg-12" style="margin-top: -20px;">
							<div class="big-cta">
								<div class="cta-text">
									<h2 align="center">
										<span>每一位</span> 学员都是高薪
									</h2>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="row">
							<!-- 置顶学员 -->
							<c:forEach var="zdstunews" items="${zdstunewslist}" varStatus="i">
								<div class="col-lg-3 col-sm-6">
									<div class="box">
										<div class="box-gray aligncenter">
											<!--<h4>启芯一</h4>-->
											<a href="pages/news/studentnews/stuhtml/${zdstunews.htmlUrl}"
												target="_blank" style="text-decoration: none">
												<div class="icon">
													<!--<i class="fa fa-tasks fa-3x"></i>-->
													<img
														src="pages/news/studentnews/titleimages/${zdstunews.studentImage}"
														style="width: 300px; height: 200px" alt="">
												</div>

												<p
													style="font-size: 1.5rem; color: #666666; height: 25px; line-height: 1; overflow: hidden; text-overflow: ellipsis">${zdstunews.studentName}</p>
												<p
													style="font-size: 1.5rem; color: #666666; height: 25px; line-height: 1; overflow: hidden; text-overflow: ellipsis">${zdstunews.company}</p>
												<p
													style="font-size: 1.5rem; color: #666666; height: 15px; line-height: 1; overflow: hidden; text-overflow: ellipsis">
													薪资:&nbsp;<span style="color: #e4393c;">${zdstunews.salary}元</span>
												</p>

											</a>
										</div>
									</div>
								</div>
							</c:forEach>
							<c:forEach var="stunews" items="${stuList}" varStatus="i">
								<c:if test="${i['index']<4-zdstunewslist.size()}">
									<div class="col-lg-3 col-sm-6">
										<div class="box">
											<div class="box-gray aligncenter">
												<!--<h4>启芯一</h4>-->
												<a href="pages/news/studentnews/stuhtml/${stunews.htmlUrl}"
													target="_blank" style="text-decoration: none">
													<div class="icon">
														<!--<i class="fa fa-tasks fa-3x"></i>-->
														<img
															src="pages/news/studentnews/titleimages/${stunews.studentImage}"
															style="width: 300px; height: 200px" alt="">
													</div>
													<p
														style="font-size: 1.5rem; color: #666666; height: 25px; line-height: 1; overflow: hidden; text-overflow: ellipsis">${stunews.studentName}</p>
													<p
														style="font-size: 1.5rem; color: #666666; height: 25px; line-height: 1; overflow: hidden; text-overflow: ellipsis">${stunews.company}</p>
													<p
														style="font-size: 1.5rem; color: #666666; height: 15px; line-height: 1; overflow: hidden; text-overflow: ellipsis">
														薪资:&nbsp;<span style="color: #e4393c;">${stunews.salary}元</span>
													</p>
												</a>
											</div>

										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>


						<div class="more"
							style="text-align: right; margin-top: -20px; margin-bottom: -50px;">

							<a href="pages/xyjy.jsp" target="_blank"
								style="text-decoration: none; color: #68A4C4;"> <!-- <span style="cursor: pointer">
					  <img src="pages/img/jt.png" alt=""/>
					  </span><br/> --> 查看更多>>
							</a>
						</div>
					</div>
				</div>
			</div>



			<!-- -------------就业排行榜---------------  -->
			<div class="Top_Record">
				<div class="record_Top">
					<p style="font-size: 22px; font-weight: 600;">薪资风云榜</p>
				</div>
				<div class="topRec_List">

					<table
						style="margin: 0 auto; width: 88%; margin-top: 20px; background-color: #25A4FF; color: white;">
						<tr>
							<th style="width: 3%;"></th>
							<th style="width: 7%;">姓名</th>
							<th style="width: 3.5%;"></th>
							<th style="width: 7%;">学历</th>
							<th style="width: 3.5%;"></th>
							<th style="width: 9%;">目前状态</th>
							<th style="width: 5%;"></th>
							<th style="width: 8%;">专业</th>
							<th style="width: 2%;"></th>
							<th style="width: 8%;">入职企业</th>
							<th style="width: 6%;"></th>
							<th style="width: 8%;">月薪</th>
							<th style="width: 7%;"></th>
							<th style="width: 8%;">地点</th>
							<th style="width: 6%;"></th>
							<th style="width: 9%;">就业时间</th>
						</tr>
					</table>

					<div class="maquee">
						<ul>
							<li>
								<div>杨*杰</div>
								<div>本科</div>
								<div>应届</div>
								<div>大数据开发</div>
								<div>阿里**集团</div>
								<div>18000</div>
								<div>北京</div>
								<div>2017-02-27</div>
							</li>
							<li>
								<div>丁*</div>
								<div>本科</div>
								<div>应届</div>
								<div>大数据开发</div>
								<div>北京**通网络公司</div>
								<div>13000</div>
								<div>北京</div>
								<div>2017-02-28</div>
							</li>

							<li>
								<div>杨*亮</div>
								<div>大专</div>
								<div>应届</div>
								<div>大数据开发</div>
								<div>北京盛*软件公司</div>
								<div>11000</div>
								<div>北京</div>
								<div>2017-02-22</div>
							</li>
							<li>
								<div>严*雪</div>
								<div>大专</div>
								<div>应届</div>
								<div>大数据开发</div>
								<div>中安**技术研究院</div>
								<div>11000</div>
								<div>北京</div>
								<div>2017-03-14</div>
							</li>
							<li>
								<div>沈*啸</div>
								<div>本科</div>
								<div>应届</div>
								<div>大数据开发</div>
								<div>紫**集团</div>
								<div>10000</div>
								<div>北京</div>
								<div>2017-03-25</div>
							</li>
							<li>
								<div>岳*涛</div>
								<div>本科</div>
								<div>应届</div>
								<div>UI设计师</div>
								<div>北京汉龙**公司</div>
								<div>10000</div>
								<div>北京</div>
								<div>2017-04-18</div>
							</li>
							<li>
								<div>滕*前</div>
								<div>本科</div>
								<div>应届</div>
								<div>大数据开发</div>
								<div>北京**达有限公司</div>
								<div>11000</div>
								<div>北京</div>
								<div>2017-04-27</div>
							</li>
							<li>
								<div>石*</div>
								<div>大专</div>
								<div>应届</div>
								<div>大数据开发</div>
								<div>北京盛**股份公司</div>
								<div>10000</div>
								<div>北京</div>
								<div>2017-05-31</div>
							</li>
							<li>
								<div>鲁*宇</div>
								<div>大专</div>
								<div>应届</div>
								<div>UI设计师</div>
								<div>北京圣*股份公司</div>
								<div>10000</div>
								<div>北京</div>
								<div>2017-05-31</div>
							</li>
							<li>
								<div>李*霞</div>
								<div>高中</div>
								<div>应届</div>
								<div>大数据工程师</div>
								<div>北京万**广告公司</div>
								<div>8200</div>
								<div>北京</div>
								<div>2017-04-08</div>
							</li>
							<li>
								<div>赵*波</div>
								<div>本科</div>
								<div>应届</div>
								<div>大数据工程师</div>
								<div>北京妙**有限公司</div>
								<div>9000</div>
								<div>北京</div>
								<div>2017-04-26</div>
							</li>
							<li>
								<div>吕*然</div>
								<div>大专</div>
								<div>应届</div>
								<div>大数据工程师</div>
								<div>北京爱**有限公司</div>
								<div>15000</div>
								<div>北京</div>
								<div>2017-03-27</div>
							</li>
						</ul>
					</div>
					
				</div>
				<p class="text-right" style="margin: 15px 15px;width:91%;">
					 <a class="more222" style="text-decoration: none;color: #68A4C4;" target="_blank"
						href="/neoit/pages/gxjy.html">查看更多>></a>
				</p>

			</div>

			<script type="text/javascript">
				function autoScroll(obj) {
					$(obj).find("ul").animate({
						marginTop : "-39px"
					}, 500, function() {
						$(this).css({
							marginTop : "0px"
						}).find("li:first").appendTo(this);
					})
				}
				$(function() {
					setInterval('autoScroll(".maquee")', 2000);

				})
			</script>






			<section class="callaction">
				<div class="container">
					<div class="row">
						<div class="col-lg-12" style="margin-top: -20px;">
							<div class="big-cta">
								<div class="cta-text">
									<h2 align="center">
										<span>每一位</span> 老师都是精英
									</h2>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

			<div class="container">
				<div class="row">
					<div class="col-lg-12" >
						<div class="row">
							<!-- 置顶教师 -->
							<c:forEach var="zdteacher" items="${selectZDteaList}"
								varStatus="i">
								<div class="col-lg-3 col-sm-6">
									<div class="box">
										<div class="box-gray aligncenter" style="height: 370px;">
											<!--<h4>启芯一</h4>-->
											<a href="pages/news/teachernews/teahtml/${zdteacher.htmlUrl}"
												target="_blank" style="text-decoration: none;">
												<div class="icon">
													<!--<i class="fa fa-tasks fa-3x"></i>-->
													<img
														src="pages/news/teachernews/titleimages/${zdteacher.teacherImage}"
														style="width: 300px; height: 200px" alt="">
												</div>
												<p
													style="font-weight: 600; font-size: 15px; color: black; text-align: le">金牌讲师:
													${zdteacher.name }</p>
												<p
													style="font-size: 1.5rem; font-weight: 400; color: #666666; line-height: 2;">职位:
													${zdteacher.job}</p>
												<p
													style="font-size: 1.5rem; font-weight: 400; color: #666666; line-height: 2;">授课风格:
													${zdteacher.teachingStyle}</p> <%-- <p style="font-size: 1.5rem;color:#E4393C;height:110px;line-height: 1.5;overflow: hidden;text-overflow: ellipsis">${teacher.resume}</p>
									 --%>


											</a>
										</div>

									</div>
								</div>
							</c:forEach>
							<c:forEach var="teacher" items="${teaList}" varStatus="i">
								<c:if test="${i['index']<4-selectZDteaList.size()}">
									<div class="col-lg-3 col-sm-6">
										<div class="box">
											<div class="box-gray aligncenter" style="height: 370px;">
												<!--<h4>启芯一</h4>-->
												<a href="pages/news/teachernews/teahtml/${teacher.htmlUrl}"
													target="_blank" style="text-decoration: none;">
													<div class="icon">
														<!--<i class="fa fa-tasks fa-3x"></i>-->
														<img
															src="pages/news/teachernews/titleimages/${teacher.teacherImage}"
															style="width: 300px; height: 200px" alt="">
													</div>
													<p
														style="font-weight: 600; font-size: 15px; color: black; text-align: le">金牌讲师:
														${teacher.name }</p>
													<p
														style="font-size: 1.5rem; font-weight: 400; color: #666666; line-height: 2;">职位:
														${teacher.job}</p>
													<p
														style="font-size: 1.5rem; font-weight: 400; color: #666666; line-height: 2;">授课风格:
														${teacher.teachingStyle}</p> <%-- <p style="font-size: 1.5rem;color:#E4393C;height:110px;line-height: 1.5;overflow: hidden;text-overflow: ellipsis">${teacher.resume}</p>
									 --%>


												</a>
											</div>

										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<div class="more"
							style="text-align: right; margin-top: -20px; margin-bottom: -20px;">

							<a href="pages/sztd.jsp" target="_blank"
								style="text-decoration: none;color: #68A4C4;">
								 <!-- <span style="cursor: pointer">
					             <img src="pages/img/jt.png" alt=""/>
					             </span><br/> --> 
					                      查看更多>>
							</a>


						</div>
					</div>
				</div>
			</div>




			<section class="callaction">
				<div class="container">
					<div class="row">
						<div class="col-lg-12" style="margin-top: -20px;">
							<div class="big-cta">
								<div class="cta-text">
									<h2 align="center">
										<span>每一门</span> 课程都是热门
									</h2>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>


			<div class="row">
				<div class="col-lg-12">
					<div class="row">
						<section id="projects">
							<ul id="thumbs" class="portfolio" style="text-align: center">
								<li class="col-lg-4 design col-md-4 col-sm-6" data-id="id-0"
									data-type="web">

									<div style="display: inline-block; text-align: center">
										<h3>大数据开发</h3>
										<a href="pages/dsj.html" target="_blank"
											style="text-decoration: none; color: #e4393c"> <img
											src="pages/img/images/dsj.jpg" alt="" />

											<p style="width: 314px">从Java语言学起，到大规模离线处理及实时处理技术，学习最前沿的大数据处理技术。</p></a>
									</div>

								</li>
								<li class="col-lg-4 design col-md-4 col-sm-6" data-id="id-0"
									data-type="web">

									<div style="display: inline-block; text-align: center">
										<h3>交互视觉设计</h3>
										<a href="pages/jhsjsj.html" target="_blank"
											style="text-decoration: none; color: #e4393c"> <img
											src="pages/img/images/jhsjsj.jpg" alt="" />

											<p style="width: 314px">从平面设计到网站设计到交互式设计，让学生不仅懂设计，还懂前后交互，培养高薪互联网设计师。</p></a>
									</div>

								</li>
								<li class="col-lg-4 design col-md-4 col-sm-6" data-id="id-0"
									data-type="web">

									<div style="display: inline-block; text-align: center">
										<h3>VR/AR开发</h3>
										<a href="pages/vr.html" target="_blank"
											style="text-decoration: none; color: #e4393c"> <img
											src="pages/img/images/vr.jpg" alt="" />

											<p style="width: 314px">学习企业广泛使用的Unity引擎开发技术，专业培养游戏工程师及VR/AR工程师。</p></a>
									</div>
								</li>
							</ul>
						</section>
					</div>
				</div>
			</div>
		</section>

		<!--start footer-->
		<footer>
			<div class="container">
				<div class="row">
					<div class="col-lg-3  col-sm-6 col-xs-12 col-md-4">
						<div class="widget">
							<h4 align="center" class="widgetheading">关于我们</h4>
							<div align="center">
								<p>
									<b style="font-size: 15px">启芯教育——专业打造互联网（IT）精英人才</b>
								</p>
								<br />
								<p>学校地址：北京市海淀区杏石口路98号（北京师范大学培训基地）</p>
								<br />

								<p>联系方式：招生办公室：010-59460819</p>
								<p style="margin-left: 35px">王老师：15910865224</p>
								<br />
								<p style="margin-right: 80px">官方邮箱：qixin@neoit.cn</p>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 col-xs-12 col-md-4">
						<div class="widget">
							<h4 align="center" class="widgetheading">课程介绍</h4>
							<div align="center">
								<ul class="link-list">
									<li><a href="pages/dsj.html" target="_blank">大数据开发</a></li>
									<br />
									<li><a href="pages/jhsjsj.html" target="_blank">交互视觉设计</a></li>
									<br />
									<li><a href="pages/vr.html" target="_blank">VR/AR开发</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 col-xs-12 col-md-4">
						<div class="widget">
							<h4 align="center" class="widgetheading">服务专区</h4>
							<div align="center">
								<ul class="link-list">
									<li><a href="https://tb.53kf.com/code/client/10165030/1"
										target="_blank">我要报名</a></li>
									<br />
									<li><a href="https://tb.53kf.com/code/client/10165030/1"
										target="_blank">付款方式</a></li>
									<br />
									<li><a href="https://tb.53kf.com/code/client/10165030/1"
										target="_blank">乘车路线</a></li>
									<br />
									<li><a href="https://tb.53kf.com/code/client/10165030/1"
										target="_blank">常见问题</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 col-xs-12 col-md-4">
						<div class="widget">
							<h4 align="center" class="widgetheading">官方微信</h4>
							<div class="footer-ewm fl_left" align="center">
								<div class="fl_left erweima">
									<img src="pages/img/images/erweima1.jpeg" width="110"
										height="110" style="display: inline" alt="" /> <br />
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
						友情链接： <span><a href="http://edu.qq.com" target="_blank">腾讯教育</a></span>
						<b>丨</b> <span><a href="http://edu.ifeng.com"
							target="_blank">凤凰教育</a></span> <b>丨</b> <span><a
							href="http://chuanke.baidu.com/" target="_blank">百度传课</a></span> <b>丨</b>
						<span><a href="http://jobuy.com/" target="_blank">人才网</a></span> <b>丨</b>
						<span><a href="http://www.job5156.com/" target="_blank">找工作</a></span>
						<b>丨</b> <span><a href="http://www.hhxx.com.cn/"
							target="_blank">好好学习</a></span> <b>丨</b> <span><a
							href="http://www.studyems.com" target="_blank">求学快递网</a></span> <b>丨</b>
						<span><a href="http://book.kongfz.com/" target="_blank">孔夫子图书网购</a></span>
						<b>丨</b> <span><a href="http://www.xueda.com/"
							target="_blank">学大教育</a></span> <b>丨</b> <span><a
							href="http://www.51zxw.net" target="_blank">我要自学网</a></span> <b>丨</b> <span><a
							href="http://www.udashi.com" target="_blank">U大师</a></span> <b>丨</b> <span><a
							href="http://www.51shiping.com" target="_blank">我要视频</a></span>
					</p>
				</div>
			</div>
			<div id="sub-footer">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="copyright">
								<p style="text-align: center; font-size: 1.5rem">
									<span>Copyright © 2017 <a href="index.html">neoit.cn</a>
										All Rights Reserved
									</span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>

	<a href="#" class="scrollup" style="display: block"> <i
		class="fa fa-angle-up active"></i>
	</a>

	<script>
		(function() {
			var _53code = document.createElement("script");
			_53code.src = '//tb.53kf.com/code/code/10165030/1';
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(_53code, s);
		})();
	</script>

	<!-- javascript -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>
	<script type="text/javascript" src="js/jquery.fancybox-media.js"></script>
	<script type="text/javascript"
		src="js/google-code-prettify/prettify.js"></script>
	<script type="text/javascript" src="js/portfolio/jquery.quicksand.js"></script>
	<script type="text/javascript" src="js/portfolio/setting.js"></script>
	<script type="text/javascript" src="js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="js/animate.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>

</body>
</html>