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
function checkdelete(userid){ //确定是否删除
  	 if(confirm("确定删除吗?")){
		 window.location.href="user/deleteUserById.do?userid="+userid;
	 };
}
function updateuser(userid){ //确定是否更新
	 if(confirm("确定修改吗?")){
		 window.location.href="user/SelectUserById.do?userid="+userid;
	 };
}

function searchForm(page){
	//alert("001:"+page);
window.location.href="user/SelectAllUsers.do?page="+page;
	
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
					style="color: #4390B9;">&nbsp;&nbsp;系统管理>>查看用户</span>
			</div>
		</div>
		<div class="page" style="margin-top: -35px;">
			<!-- opinion 页面样式 -->
			<div class="opinion">
				<!-- opinion 表格 显示 -->
				<div class="opShow">
					<c:if test="${not empty userList}">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="66px" class="tdColor tdC">序号</td>
								<td width="150px" class="tdColor">用户名</td>
								<td width="150px" class="tdColor">真实姓名</td>
							    <td width="150px" class="tdColor">所属部门</td>
								<td width="200px" class="tdColor">电话</td>
								<td width="150px" class="tdColor">邮箱</td>
								<td width="300px" class="tdColor">最近登录时间</td>
								<td width="300px" class="tdColor">用户注册时间</td>
								<td width="150px" class="tdColor">操作</td>
							
							</tr>
							<c:forEach var="user" items="${userList}" varStatus="i">
								<tr>
									<td style="width: 10px;">${i['index']+(page-1)*10+1}</td>
									<td id="th1">
										<p style="font-size:6px;">${user.name }</p>
									</td>
									<td >
										<p style="font-size:6px;">${user.realName }</p>
									</td>
									<td>
									<c:if test="${user.officeId==1}">
									${"教学部" }
									</c:if>
									<c:if test="${user.officeId==2}">
									${"市场部" }
									</c:if>
									<c:if test="${user.officeId==3}">
									${"后勤部" }
									</c:if>
									<c:if test="${user.officeId==4}">
									${"技术部" }
									</c:if>
									</td>
									<td >
										<p style="font-size:6px;">${user.mobile }</p>
									</td>
									<td >
										<p style="font-size:6px;">${user.email }</p>
									</td>
									
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${user.loginTime}" />
									</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${user.createTime}" />
									</td>
									
									 <td>
									 
									   <c:if test="${user.name=='admin' }">
									    <input type="button" style="width:70px; height:20px;" value="修改" onclick="updateuser(${user.id})" />
									   </c:if>
					            	   <c:if test="${user.name!='admin' }">
									    <input type="button" value="修改" onclick="updateuser(${user.id})" />
									    <input type="button" value="删除" onclick="checkdelete(${user.id})" />
					            	   </c:if>
					            	
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
	<!-- 如果没有用户则显示 -->
	
	<c:if test="${uesr.name=='admin'}">
	    <c:if test="${empty userList}">
		  <div style="text-align: center;">
			<span style="color: red;font-size:15px;">您是超级管理员,除了您还没有其他用户....</span>
		  </div>
		</c:if>
	</c:if>
	
	<c:if test="${uesr.name!='admin'}">
		 <div style="text-align: center;">
			<span style="color: red;font-size:15px;">${msg}</span>
		  </div>
	</c:if>
	
	
</body>
</html>