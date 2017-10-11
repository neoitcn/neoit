<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
window.onload=function(){
	 relogin();
} 
 var i=6;
function relogin(){
	i--;
	document.getElementById("contdown").innerHTML=i+"秒之后将跳转到登陆界面...";
	setTimeout("relogin()",1000)
	if(i==0){
		parent.location.reload(); 
	 
	}
}

</script>
<body style="text-align: center;" >
<p style="color: red;font-size:18px;font-weight: 600 ">你的新密码已改为:${newuser.password },需要您重新登陆...</p>
<p id="contdown" style="color: red;font-size:15px; "></p>

</body>
</html>