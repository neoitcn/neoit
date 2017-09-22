<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragrma","no-cache");
response.setDateHeader("Expires",0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启芯教育</title>
<link rel="stylesheet" type="text/css" href="/neoit/backment/css/css.css" />
<script type="text/javascript" src="/neoit/backment/js/jquery.min.js"></script>

<script type="text/javascript">

 function checkformdata(){   
	  //判断必填项是否为空
	
	    var cname=document.form2.name.value.trim();	  
		var crealName=document.form2.realName.value.trim();
		var cpassword=document.form2.password.value.trim();
		var cmobile=document.form2.mobile.value.trim();
		var cemail=document.form2.email.value.trim();
		
		if(cname.length==0){
			alert("用户名不能为空,请修改！");
			return false;
		}
		if(crealName.length==0){
			alert("真实姓名不能为空,请修改！");
			return false;
		}
		if(cpassword.length==0){
			alert("密码不能为空,请修改！");
			return false;
		}
		if(cmobile.length==0){
			alert("手机号不能为空,请修改！");
			return false;
		} 
	 
	 

	var name=document.form2.name.value;
	var realName=document.form2.realName.value;	
    var password=document.form2.password.value;
	var email=document.form2.email.value;
	var mobile=document.form2.mobile.value;  
	
	 var re1 =/^1[34578]\d{9}$/;//手机号码验证  
	 var re2 = /^[\u4e00-\u9fa5]$/;//真实姓名验证
	 var re3 =/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;  //邮箱验证
	 var re4 =/^[\a-\z]$/;//验证用户名,只能由小写字母组成  
	 for(var i=0;i<realName.length;i++){
	     if(!re2.test(realName[i])){
            alert("真实姓名只能为汉字,请修改!"); 
         　　　　        return false;
         } 
	 }
	 if(!re1.test(mobile)){
         alert("手机号码格式不对,请修改!"); 
         　　　　return false;
 　           }
	 if(cemail.length!=0){ 
		 if(!re3.test(cemail)){
	         alert("邮箱格式不对,请修改!"); 
	         　　　　return false;
	 　           }
	 }
	 for(var i=0;i<name.length;i++){
	  if(!re4.test(name[i])){
         alert("用户名只能由小写字母组成,请修改!"); 
         　　　　return false;
 　           }
	 }
	 
	 if(confirm("确认注册吗?")){
        document.form2.submit(); 
	 }
	
}

</script>

</head>
  <%  
 if (session.getAttribute("loginUser")==null ){%>
 <jsp:forward page="/backment/login.jsp" ></jsp:forward>
 <%}%> 
<body  >
	<div id="pageAll"  >
		<div class="pageTop" >
			<div class="page">
				<img src="/neoit/backment/img/coin02.png" />
				<span
					style="color: #4390B9;">&nbsp;&nbsp;系统管理>>用户注册</span>
			</div>
		</div>
		<div >
		    <!--判断是否为超级管理员 -->
			<div style="text-align:center; ">
			 <c:if test="${loginUser.name!='admin' }">
			 <span style="color: red;font-size:15px;">您的权限不足,无法添加!</span>  	 
			 </c:if>
			
			</div>
		
		  <c:if test="${loginUser.name=='admin' }">
		
			<!-- 用户注册页面样式 -->
			<div class="banneradd bor" style="text-align:center;" > 
				<div class="baTopNo">
					<span>添加用户</span>
				</div>
			
				<div class="baBody" >
				
				<form action="reg/Register.do" name="form2"  method="post">
				    <div class="bbD">
					真实姓名：<span style="color: red;">*</span><input type="text" name="realName" class="input3" />
					</div>
					<div class="bbD">&nbsp;&nbsp;
					用户名：<span style="color: red;">*</span>
						<input type="text"  name="name" class="input3" />
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：<span style="color: red;">*</span><input type="password"
						name="password"	class="input3" />
					</div>
					
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门：<span style="color: red;">*</span>
						<select class="input3" name="officeId">
						    <option value="1">教学部</option>
						    <option value="2">市场部</option>
						    <option value="3">后勤部</option>
						    <option value="4">技术部</option>
						</select>
				 	</div>
					<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;手机号：<span style="color: red;">*</span><input type="text"
							name="mobile" class="input3" />
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱：<input type="text"
						name="email"	class="input3" />
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text"
						name="remarks"	class="input3" />
					</div>
					 <div class="bbD">
						<!-- 创建者ID(默认登陆用户id) 隐藏提交 -->
					  <input type="hidden" value="${loginUser.id}"  name="createId" />
							
					</div>
					<div class="bbD">
					<p style="color: red;">${msg}</p>
						<p class="bbDP">
							
							<button type="button" onclick="checkformdata()" style="margin-left: 100px;"  class="btn_ok btn_yes" >注册</button> 
							
							<button   type="reset"   class="btn_ok " >重置</button>
						</p>
					</div>
					
							
					</form>
					
				</div>
			</div>
			 </c:if>

			<!-- 会员注册页面样式end -->
		</div>
	</div>
</body>
</html>