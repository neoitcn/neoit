<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>头部-有点</title>
<link rel="stylesheet" type="text/css" href="/neoit/backment/css/public.css" />
<script type="text/javascript" src="/neoit/backment/js/jquery.min.js"></script>
<script type="text/javascript" src="/neoit/backment/js/public.js"></script>

<script type="text/javascript">

function checkout(){
	
	if(confirm("确定退出当前系统吗？")){
		window.location.href="user/loginOut.do";
		
	}
}
</script>




</head>

<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL">
			<!-- <img class="headLogo" src="/neoit/backment/img/headlogo.png" /> -->
		    <p style="font-size:23px;color:white;margin-top:35px;font-weight:800;">欢迎使用启芯教育后台管理系统</p>
		</div>
		<div class="headR">
			<p style="font-size:15px;color:white;margin-top:30px;font-weight:400;">
				欢迎您:${loginUser.name}
			</p>
			
			<p >
			<a href="javascript:checkout()" class="goOut" style="font-size:15px;color:white;">(点此退出系统)</a> 
			</p>
		</div>
	</div>

	


</body>
</html>