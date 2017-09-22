<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragrma","no-cache");
response.setDateHeader("Expires",0);
%>
<!DOCTYPE>
 <html>
<head>
<base href="<%=basePath%>">
<link rel="icon" href="common/resource/img/ico/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<jsp:include page="/common/jsinclude.jsp">
	<jsp:param name="groups" value="aofa-validate,jquery-form,jquery-rotate" />
</jsp:include>
<title>用户登录</title>	
<style type="text/css">
.bodywrap {
	text-align: left;
	margin-top: 10px;
	visibility: visible;
}



 td {
    line-height: 30px;
}
* {
    font-size: 12px;
}
td[Attributes Style] {
    text-align: -webkit-right;
}

td, th {
    display: table-cell;
    vertical-align: inherit;
}
.dialogwrap {
	text-align: left;
	margin: 0 auto;
	padding: 10px;
	border: 2px solid #ddd;
	background: #fafafa;
}
.input_login{
    height: 22px;
    width: 218px;
    border: 1px #5FBAE0 solid;
    padding: 2px 1px;
    font: normal normal 12px/17px "宋体", "arial", "微软雅黑";
}
.loginBody {
	text-align: center;
	margin-top: 215px;
	visibility: visible;
	background: url('common/resource/img/bg/bs_back.png') center top
		no-repeat;
}

.loginform1 {
	text-align: center;
	width: 961px;
	height: 392px;
	margin: 0 auto;
	padding: 10px;
	background: #fafafa;
	background: url('common/resource/img/bg/bs_input_back2.png') center top
		no-repeat;
}

.login_submit {
	background: url('common/resource/img/bg/bs_logging_in_normal.png')
		no-repeat;
	width: 181px;
	height: 31px;
	display: block;
	border: 0;
}

.login_submit:hover {
	background: url('common/resource/img/bg/bs_logging_in_pushed.png')
		no-repeat;
	border: 0;
}
.erweima{
 display:block;position:absolute;bottom:250px;right:50px;height:125px;width:100px;
}
.merweima{
 display:block;position:absolute;bottom:110px;right:50px;height:125px;width:100px;
}


</style>
<script src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
var i=0;
function changeYzm(){
document.getElementById("yzm").src="yanzm/scyzm.do?i="+i;
i++;

};

function checkForm(){
	  var na=document.getElementById("na").value;
	  var pwd=document.getElementById("pwd").value;
	  if(na==""||pwd==""){
		  document.getElementById("remind").innerHTML='<p style="color:red;">请输入用户名或密码!</p>';
		 return false; 
	  }
	  document.form.submit();
	  
}

if (top!= self) {
	  alert('当前用户密码已经过期,请重新登录!');
    parent.location.reload(); 
}
/*  window.onload=function(){
	alert("00");
   document.getElementById('pwd').value='';
}  */

</script>
 </head>
 <body class="loginBody">
	<div class="loginform1" title="启芯教育登录系统" closable="false" border="false">
		<form action="login/AdminLogin.do" method="post" name="form">
			<div
				style="margin:0 auto;text-align:center;width:400px;height: 260px;padding-left:100px;*padding-left:40px;padding-top:130px;text-align:center;">
				<table class="table_login" cellpadding="0" cellspacing="3">
					<tr>
						<td colspan="2"><span id="errorMessage" style="color:#FF0000;"></span></td>
					</tr>
					<tr>
						<td align="right" style="padding-right:3px;">用户名</td>
						<td>
						<input type="text" class="easyui-validatebox input_login" id="na" name="name" /></td>
					</tr>

					<tr>
						<td align="right" style="padding-right:3px;">密码</td>
						<td><input type="password"  class="easyui-validatebox input_login" id="pwd" name="password" />
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="right" style="padding-right:3px;">验证码</td>
						<td style="position: relative;">
							<input type="text" name="yzm" class="input_login easyui-validatebox" style="width:95px;" placeholder="输入验证码"/>&nbsp;&nbsp;
			    			<img id="yzm" style="position:absolute; height:25px;width:85px;cursor:pointer;vertical-align:middle;" src="yanzm/scyzm.do"></td>
						<td><a href="javascript:void(0)" id="refresh"
							onClick="changeYzm()"
							style="color:#57acdf;text-decoration:underline;">刷新</a>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<table border="0" cellpadding="0" cellspacing="0" width="95%">
								<tr>
									<td width="69%" style=""></td>
									<td><a href="javascript:void(0);" onclick="checkForm()"
										id="loginSubmit" class="login_submit"></a>
									</td>
								</tr>
								<tr>
								<td colspan="2"><span id="error_msg"
										style="color: red;">  </span></td>
								</tr>
								
							</table>
							<div id="remind">${msg}</div>
							
						</td>
					</tr>
				</table>
				<br />
			</div>
		</form>
	</div>
		<div style="position: absolute;bottom:50px;right:50px;height:400px;display:none;">
  		<div style="height:200px;position: relative;">
  			<img src="common/resource/img/b-code/master.png" width="150" height="150"/>
  			<div style="position: absolute;bottom:20px;left: 0;right:0;text-align: center;">管理app下载</div>
  		</div>
  		<div style="height:200px;">
  			<img src="common/resource/img/b-code/slave.png" width="150" height="150"/>
  			<div style="position: absolute;bottom:20px;left: 0;right:0;text-align: center;">矫正app下载</div>
  		</div>
  	</div>
</body>
</html>