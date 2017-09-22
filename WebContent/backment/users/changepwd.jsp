<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启芯教育</title>
<link rel="stylesheet" type="text/css" href="../css/css.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
function checkpwd(){
var  oldpwd= document.getElementById('pwd1').value.trim();
var  newpwd1 = document.getElementById('pwd2').value.trim();
var  newpwd2 = document.getElementById('pwd3').value.trim();

    //判断旧密码是否正确
    if(oldpwd.length!=0&&oldpwd!=${loginUser.password}){ 
    	  alert("旧密码错误！请重新输入。");
		return false;
	}
    if(oldpwd.length==0){
    	sign=1;
    	alert("旧密码必须填写！请重新输入。");
 		return false;
    	
    }
    if(newpwd1.length<6||newpwd1.length>12){
    	alert("新密码长度只能为6-12位,请重新输入。");
    	
     	return false;
    }
    if(newpwd2.length<6||newpwd2.length>12){
     	alert("新密码长度只能为6-12位,请重新输入。");
    	return false;
    }
    
    if(newpwd1!=newpwd2){
    	alert("两次输入的新密码不一致！请重新输入。");
    	
    	return false;
    }
    

   document.form2.submit(); 


}

</script>
</head>
 <%  
 if (session.getAttribute("loginUser")==null ){%>
 <jsp:forward page="/backment/login.jsp" ></jsp:forward>
 <%}%> 
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
			<img src="/neoit/backment/img/coin02.png" />
			<span style="color: #4390B9;">&nbsp;&nbsp;系统管理>>修改密码</span>
			</div>
		</div>
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
			<form action="../../user/UpdatePwd.do"   method="post" name="form2">  
				<div class="bbD">&nbsp;&nbsp;&nbsp;&nbsp;
				当前用户名：&nbsp;&nbsp;&nbsp;&nbsp;${loginUser.name }
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;输入旧密码：
				<input type="password" class="input3" id="pwd1" />
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;
					输入新密码：<input type="password" name="password" class="input3" id="pwd2" /> 
				</div>
				<div class="bbD">&nbsp;
					再次确认密码：<input type="password" class="input3"  id="pwd3" /> 
				</div>
				<!-- 隐藏用户id -->
				<input type="hidden" name="id" value="${loginUser.id }" /> 
				<div class="bbD">
					<p class="bbDP">
						<button type="button" class="btn_ok btn_yes" onclick="checkpwd()">提交</button>
						<button class="btn_ok btn_yes" type="reset"  >重置</button>
						
					</p>
				</div>
				</form>
			</div>

			<!-- 修改密码页面样式end -->
		</div>
	</div>
	
</body>

</html>