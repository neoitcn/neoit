<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>启芯教育</title>
</head>
 <%  
 if (session.getAttribute("loginUser")==null ){%>
 <jsp:forward page="/backment/login.jsp" ></jsp:forward>
 <%}%>
<body>
 <p style="color: red;font-size:15px; ">${deletemsg}</p>   

</body>
</html>