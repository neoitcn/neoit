<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
 <%  
 if (session.getAttribute("loginUser")==null ){%>
 <jsp:forward page="/backment/login.jsp" ></jsp:forward>
 <%}%>
<body style="text-align: center;">
<p style="color: red;font-size:20px; font-weight: 600; ">注册成功！请牢记您的用户名和密码:</p>
<p style="color: red;font-size:20px; font-weight: 600;">用户名:${user.name}</p>
<p style="color: red;font-size:20px; font-weight: 600;">密码:${user.password}</p>

</body>
</html>