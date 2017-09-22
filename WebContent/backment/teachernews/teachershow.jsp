<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启芯教育</title>
<link rel="stylesheet" type="text/css"
	href="/neoit/backment/css/css.css" />
</head>
<script type="text/javascript">
function checkdelete(teaid){ //确定是否删除
  	 if(confirm("确定删除吗?")){
		 window.location.href="tea/deleteTeaById.do?teaid="+teaid;
	 };
}
function updatestunews(teaid){ //确定是否更新
	 if(confirm("确定修改吗?")){
		 window.location.href="admin/SelectTeaById.do?teaid="+teaid;
	 };
}
function chakan(htmlurl){//设置跳转的新闻HTML
	//alert("001:"+type);
  window.location.href="pages/news/teachernews/teahtml/"+htmlurl;
};
function searchForm(page){
	//alert("001:"+page);
window.location.href="tea/selectAllTeachers.do?page="+page;
	
}

</script>
 <%  
 if (session.getAttribute("loginUser")==null ){%>
 <jsp:forward page="/backment/login.jsp" ></jsp:forward>
 <%}%>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="/neoit/backment/img/coin02.png" /> <span
					style="color: #4390B9;">&nbsp;&nbsp;师资管理>>查看师资</span>
			</div>
		</div>
		<div class="page" style="margin-top: -35px;">
			<!-- opinion 页面样式 -->
			<div class="opinion">
				<!-- opinion 表格 显示 -->
				<div class="opShow">
					<c:if test="${not empty teacherList}">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="66px" class="tdColor tdC">序号</td>
								<td width="100px" class="tdColor">教师姓名</td>
								<td width="100px" class="tdColor">教师职位</td>
								<td width="90px" class="tdColor">显示级别</td>
								<td width="90px" class="tdColor">创建者</td>
								<td width="150px" class="tdColor">创建时间</td>
								<td width="90px" class="tdColor">更新者</td>
								<td width="150px" class="tdColor">更新时间</td>
								<td width="200px" class="tdColor">操作</td>
							</tr>
							<c:forEach var="tea" items="${teacherList}" varStatus="i">
								<tr>
									<td style="width: 10px;">${i['index']+(page-1)*10+1}</td>
								    <td>${tea.name }</td>
									<td>${tea.job }</td>
									<c:if test="${tea.level==1}">
									<td>一般</td>
									</c:if>
									<c:if test="${tea.level==2}">
									<td>置顶</td>
									</c:if>
									
									<!-- 创建者 -->
									<c:forEach var="user" items="${createrList}" varStatus="j">
										<c:if test="${i['index']==j['index'] }">
										  <td>${user.realName }</td>
										</c:if>
									</c:forEach>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${tea.createTime}" />
									</td>
								  <!-- 更新者 -->
									<c:forEach var="user" items="${updaterList}" varStatus="j">
										<c:if test="${i['index']==j['index']}">
										  <td>${user.realName }</td>
										</c:if>
									</c:forEach>
									 <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${tea.updateTime}" />
									</td>
									<td><input type="button" value="查看"
										onclick="chakan('${tea.htmlUrl}')" />
										 <input
										type="button" value="修改" onclick="updatestunews(${tea.id})" />
										 <input type="button"
										value="删除" onclick="checkdelete(${tea.id})" />
					            	</td>
								</tr>
							</c:forEach>
						</table>
						<!-- 页码显示 -->
	<div id="page2">
		<div style="text-align:center;">
			<p>
				当前是第${page}页&nbsp;共${pages}页 &nbsp; &nbsp; <a style="text-decoration: none;"
					href="javascript:searchForm(${backpage})">上一页</a>&nbsp;&nbsp;
				<c:forEach var="i" begin="1" end="${pages}">
					&nbsp;&nbsp;<a style="text-decoration: none;"
						href="javascript:searchForm(${i})">${i}</a>&nbsp;&nbsp;
					 </c:forEach>
				&nbsp;&nbsp;<a style="text-decoration: none;"
					href="javascript:searchForm(${nextpage})">下一页</a>&nbsp;&nbsp;

			</p>
		</div>
	</div>
	</c:if>
	<!-- 如果没有新闻则显示 -->
	<c:if test="${empty teacherList}">
	  <div style="text-align: center;">
		<span style="color: red;font-size:15px;">没有师资信息,请添加....</span>
	  </div>
	</c:if>
</body>
</html>