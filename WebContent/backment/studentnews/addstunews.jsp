<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>启芯教育</title>
<!-- 配置文件 -->
<script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../ueditor/ueditor.all.js"></script>

 <!--   引入js jar包 -->
 <script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
 <link rel="stylesheet" type="text/css" href="/neoit/backment/css/css.css" />
 
</head>
<script type="text/javascript">
 /* 1.获取ueditor编辑器内容中img标签中图片的名称(alt的值), 保存到 <input/>中 */
	function picname(){
	
		 var newtitlepage =document.forms2.userfile.value;
		 var newtitle =document.forms2.title.value.trim();
		 var newscontent =document.forms2.content.value.trim();
		 var salary =document.forms2.salary.value.trim();
		 var stuname =document.forms2.studentName.value.trim();
		 var stujob =document.forms2.job.value.trim();
		 var newsresume =document.forms2.resume.value.trim();
		 var stucompany =document.forms2.company.value.trim();
		 var re = /^[0-9]+.?[0-9]*$/;
		 if(!re.test(salary)){
	         alert("薪水只能为纯数字,请修改!");
	       return false;
	      }
		    if(newtitle.length>28)//没有上传标题则给出提示;
		    {
		        alert('学生就业标题不得28个字符,请修改!');
		        return false;
		    }
		    if(newtitle.length==0)//没有上传标题则给出提示;
		    {
		        alert('学生就业标题不能为空!');
		        return false;
		    }
		    if(newsresume.length==0)//没有上传标题则给出提示;
		    {
		        alert('新闻概要不能为空!');
		        return false;
		    }
		     if(stuname.length==0)//没有上传标题则给出提示;
		    {
		        alert('学生姓名不能为空!');
		        return false;
		    }
		    if(stujob.length==0)//职位;
		    {
		        alert('学生职位不能为空!');
		        return false;
		    }
		    if(salary.length==0)//薪资;
		    {
		        alert('学生薪水不能为空!');
		        return false;
		    }
		    if(stucompany.length==0)//薪资;
		    {
		        alert('学生入职公司不能为空!');
		        return false;
		    }
		    
		    if(newtitlepage=="")//没有上传标题图片则给出提示;
		    {
		        alert('学生图片不能为空,请上传!');
		        return false;
		    }
		    if(newscontent.length==0)//没有添加内容则给出提示;
		    {
		        alert('新闻内容不能为空,请输入内容!');
		        return false;
		    }
		    
	 
		var ue = UE.getEditor('container');
		var str=ue.getPlainTxt();//s就是编辑器的带格式的内容
		//alert("编辑器内容是:"+str);
		//var str='<img src="1502274370754037759.png" title="1502274370754037759.png" alt="66.png"/><br>HAHAH<img src="1502274370754037759.png" title="1502274370754037759.png" alt="777.png"/><br>';
		//匹配图片（g表示匹配所有结果i表示区分大小写）
		var imgReg = /<img.*?(?:>|\/>)/gi;
		//匹配src属性
		var srcReg = /title=[\'\"]?([^\'\"]*)[\'\"]?/i;
		var arr = str.match(imgReg);
		//alert('所有已成功匹配图片的数组：'+arr);
		if(arr!=null){
		for (var i = 0; i < arr.length; i++) {
		 var src = arr[i].match(srcReg);
		 //获取图片地址
		 if(src[1]){
		  //alert('已匹配的图片地址'+(i+1)+'：'+src[1]);
		 $("#savepic").append('保存的图片名称:<input type="text" name="pic" value="'+src[1]+'"/><br>');
				
		 }
		}}
		if(confirm("确定发布？")){
			 document.forms2.submit();
		}
	}
  //2.控制上传标题图片的大小
	 function check(){		
   	    var obj = document.getElementById("userfile") ; 
	    var aa=document.getElementById("userfile").value.toLowerCase().split('.');//以“.”分隔上传文件字符串
	   // var aa=document.form1.userfile.value.toLowerCase().split('.');//以“.”分隔上传文件字符串
	    if(document.forms2.userfile.value=="")
	    {
	        alert('图片不能为空！');
	        return false;
	    }
	    else
	    {
	     //alert("进入check3...");
	    if(aa[aa.length-1]=='gif'||aa[aa.length-1]=='jpg'||aa[aa.length-1]=='bmp'||aa[aa.length-1]=='png'||aa[aa.length-1]=='jpeg')//判断图片格式
	    {
		var imagSize =  document.getElementById("userfile").files[0].size;
		 //alert("图片大小："+imagSize+"B")
		if(imagSize<1024*1024*3){
	        //alert("图片大小在3M以内，为："+imagSize/(1024*1024)+"M");
	        document.getElementById("picsize").innerHTML="";
	       return true;
		}else{
			obj.outerHTML=obj.outerHTML; 
		    document.getElementById("picsize").innerHTML='<p style="color:red;font-size:14px;">警告:标题图片不得超过3M,请重新上传!</p>';
			return false;
		}  
     
	    }else
	    {  
	       obj.outerHTML=obj.outerHTML; 
	       document.getElementById("picsize").innerHTML='<p style="color:red;font-size:14px;">格式错误!请选择格式为(*.jpg、*.gif、*.bmp、*.png、*.jpeg)的图片重新上传!</p>';
	       //alert('请选择格式为*.jpg、*.gif、*.bmp、*.png、*.jpeg 的图片');//jpg和jpeg格式是一样的只是系统Windows认jpg，Mac OS认jpeg，
	       //二者区别自行百度
	        return false;
	    }
     }
	   }
	   
	   function sn()
	   {
	   		var name=document.getElementById("studentname").value();
	   		if(name=="")
	   		{
	   			alert("学员姓名为必填项，请认真填写后提交");
	   		}
	   }
 </script>
<style type="text/css">
#tab{
border-collapse:collapse;

}
#tab td{
border:1px gray solid; 
}
#td_left
{
	text-align:right;
	font-weight:bolder;
	font-family:微软雅黑;
	padding-right:30px;
	width:150px;
	height:40px;
}
#td_right
{
	text-align:left;
	padding-left:35px;
	width:790px;
	height:40px;
}
</style>
  <%  
 if (session.getAttribute("loginUser")==null ){%>
 <jsp:forward page="/backment/login.jsp" ></jsp:forward>
 <%}%>
<body>
 <div class="pageTop">
			<div class="page">
				<img src="/neoit/backment/img/coin02.png" />
				<span style="color:#4390B9;"> &nbsp;&nbsp;学员管理>>添加学员新闻</span>
			</div>
 </div>
  <div  style="width:1025px;margin-top:10px;margin-left: 25px; ">
	<form action="../../stu/uploadStuWorkNews.do"  name="forms2" method="post"  enctype="multipart/form-data"  >
		<!--此div保存新闻中的图片的名字 -->
        <div id="savepic"></div>
        <table id="tab">
         <tr>
	        <td id="td_left">新闻标题<span style="color:red">*</span>:<p style="font-size: 10px; color: gray;">(28个字符以内)</p></td>
	        <td id="td_right"><input  id="title" name="title" size="59" style="width: 580px;"/></td>
         </tr>
          <tr>
	        <td id="td_left">新闻概要<span style="color:red">*</span>:<p style="font-size: 10px; color: gray;">(30字以内)</p></td>
	        <td id="td_right">
     <textarea  name="resume" rows="2" cols="30" style="width:400px; height:50px;" ></textarea>
	        </td>
         </tr>
         
         <tr>
	        <td id="td_left">学员图片<span style="color:red">*</span>:<p style="font-size: 10px;color: gray;">(300x200)</p></td>
	        <td id="td_right"><input type="file"  name="smallpicture"  id="userfile" onchange="check()"/><p id="picsize"></p></td>
         </tr>
         <tr>
	        <td id="td_left">学员姓名<span style="color:red">*</span>:</td>
	        <td id="td_right">
	        	<input type="text" id="studentname"  name="studentName" style="width: 160px;"  />
	        	<span style="font-weight:bolder; font-family:微软雅黑; margin-right:22px; margin-left:55px;">
	        	显示级别<span style="color:red">&nbsp;</span>：</span>
	        	<select  id = "sel" name="level" >
				 <option  value = "1"  selected = "selected">普通显示</option >
				 <option  value = "2" >置顶</option >
				 </select >
	        </td>
         </tr>
         <tr>
	        <td id="td_left">学员年龄<span style="color:red">&nbsp;&nbsp;</span>:</td>
	        <td id="td_right">
	              <select  id ="sel" name="age" >	
		          	<c:forEach var="i" begin="16"  end="55">
					 <option  value = "${i}" >${i}</option>
					</c:forEach> 
				   </select >
				   <span style="font-weight:bolder; font-family:微软雅黑; margin-right:22px; margin-left:179px;">学员性别<span style="color:red">&nbsp;&nbsp;</span>：</span>
				   <select  id =  "sel" name="sex" >
					 <option  value = "0" selected = "selected" >男</option >
					 <option  value = "1" >女</option >
				  </select >
	        </td>
         </tr> 
         
         <tr>
	        <td id="td_left">学员职位<span style="color:red">*</span>:</td>
	        <td id="td_right">
	        	<input type="text"  name="job" style="width: 160px;" />
	        	<span style="font-weight:bolder; font-family:微软雅黑; margin-right:22px; margin-left:55px;">学员薪水<span style="color:gray;font-size: 6px;">(纯数字)</span><span style="color:red">*</span>：</span>
	        	<input type="text"  name="salary" style="width: 160px;" />
	        </td>
         </tr>
        
         <tr>
	        <td id="td_left">入职公司<span style="color:red">*</span>:</td>
	        <td id="td_right"><input type="text"  name="company" size="59" style="width: 580px;" /></td>
         </tr>
         <tr>
	        <td id="td_left">毕业院校<span style="color:red">&nbsp;&nbsp;</span>:</td>
	        <td id="td_right"> 
	        <input type="text"  name="gradSchool" style="width: 580px; "  /></td>
         </tr>
         <tr>
	        <td id="td_left">通讯地址<span style="color:red">&nbsp;&nbsp;</span>:</td>
	        <td id="td_right"><input type="text"  name="comeFrom" style="width: 580px;" /></td>
         </tr>
        <!--  <tr>
	        <td id="td_left">学员联系方式<span style="color:red">*</span>:</td>
	        <td id="td_right"><input type="text"  name="mobile" style="width: 580px;" /></td>
         </tr> -->
         <tr>
	        <td id="td_left">文章作者<span style="color:red">&nbsp;&nbsp;</span>:</td>
	        <td id="td_right"><input type="text"  name="author" style="width: 580px;" /></td>
         </tr>
      </table>
  		<!-- 创建者id 隐藏提交 -->
	   <input type="hidden" value="${loginUser.id}" name="createId"  />

		
		<!-- 加载编辑器的容器 -->
		 <script id="container" name="content" type="text/plain" style="width:1024px;height:450px;">
	此处输入就业学员信息...
        </script>   
	   <!-- <a href="javascript:picname()" style="text-decoration: none;">提交</a> -->
	   <input type="button" onclick="picname()" value="点击发布" />
	</form>
  </div>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
	        var ue = UE.getEditor('container'); 
	</script>

</body>
</html>