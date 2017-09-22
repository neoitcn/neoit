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
<link rel="stylesheet" type="text/css" href="/neoit/backment/css/css.css" />
</head>
<script type="text/javascript">
function checkdelete(newsid){ //确定是否删除
  	 if(confirm("确定删除吗?")){
		 window.location.href="admin/deleteNewsById.do?newsid="+newsid;
	 };
}
function updatenews(newsid){ //确定是否更新
 	 if(confirm("确定修改吗?")){
 		 window.location.href="admin/SelectNewsById.do?newsid="+newsid;
	 };
}

function chakan(htmlurl,type){//设置跳转的新闻HTML
	//alert("001:"+type);
  window.location.href="pages/news/"+type+"/"+htmlurl;
};
function searchForm(page,type){
	//alert("001:"+page);
window.location.href="admin/selectAllNews.do?page="+page+"&type="+type;
	
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
				<img src="/neoit/backment/img/coin02.png" />
				 <span style="color:#4390B9;">&nbsp;&nbsp;新闻管理>>>${newstype}</span>
			</div>
		</div>
		<div class="page" style="margin-top:-35px;">
			<!-- opinion 页面样式 -->
			<div class="opinion">
				<!-- opinion 表格 显示 -->
				<div class="opShow">
					<c:if test="${not empty newsList}">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="66px" class="tdColor tdC">序号</td>
								<td width="240px" class="tdColor">新闻标题</td>
								<td width="100px" class="tdColor">文章作者</td>
								<td width="70px" class="tdColor">显示级别</td>
								<td width="70px" class="tdColor">创建者</td>
								<td width="150px" class="tdColor">创建时间</td>
								<!-- <td width="50px" class="tdColor">优先级</td> -->
								<td width="70px" class="tdColor">更新者</td>
								<td width="150px" class="tdColor">更新时间</td>
								
								<td width="100px" class="tdColor">操作</td>
							</tr>
							<c:forEach var="news" items="${newsList}" varStatus="i">
								<tr height="40px">
									<td style="width: 16px;">${i['index']+(page-1)*10+1}</td>
									<td style="width: 130px;">
										<p style="font-size: 13px;">${news.title }</p>

									</td>
									<td>${news.author }</td>
									<c:if test="${news.level==1}">
									<td>一般</td>
									</c:if>
									<c:if test="${news.level==2}">
									<td>置顶</td>
									</c:if>
									
									
									
									
									
									
									<!-- 创建者 -->
									<c:forEach var="user" items="${createrList}" varStatus="j">
										<c:if test="${i['index']==j['index'] }">
										  <td>${user.realName }</td>
										</c:if>
									</c:forEach>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${news.createTime}" /></td>

									<%-- <td>${news.level }</td> --%>
								
									<!-- 更新者 -->
									<c:forEach var="user" items="${updaterList}" varStatus="j">
										<c:if test="${i['index']==j['index']}">
										  <td>${user.realName }</td>
										</c:if>
									</c:forEach>
									
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${news.updateTime}" /></td>
									<td><input type="button" value="查看"
										onclick="chakan('${news.htmlUrl}',${news.type})" /> 
										 <input
										type="button" value="修改" onclick="updatenews(${news.id})" />
										<input
										type="button" value="删除" onclick="checkdelete(${news.id})" />
								</td>
								</tr>
							</c:forEach>
						</table>
						<div id="page2">
							<div style="text-align: center;">
								<p>
									当前是第${page}页&nbsp;共${pages}页 &nbsp; &nbsp; <a
										style="text-decoration: none;"
										href="javascript:searchForm(${backpage},${type})">上一页</a>&nbsp;&nbsp;
									<c:forEach var="i" begin="1" end="${pages}">
						&nbsp;&nbsp;<a style="text-decoration: none;"
											href="javascript:searchForm(${i},${type})">${i}</a>&nbsp;&nbsp;
						 </c:forEach>
									&nbsp;&nbsp;<a style="text-decoration: none;"
										href="javascript:searchForm(${nextpage},${type})">下一页</a>&nbsp;&nbsp;

								</p>
							</div>
						</div>
					</c:if>
					<!-- 如果没有新闻则显示 -->
					<c:if test="${empty newsList}">
						<div style="text-align: center;">
							<span style="color: red; font-size: 15px;">没有你要查看的新闻,请添加....</span>
						</div>
					</c:if>
				</div>

			</div>
			<!-- 页面样式end -->
		</div>
	</div>
</body>
</html>