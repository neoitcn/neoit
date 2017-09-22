<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>启芯教育</title>
<!-- 配置文件 -->
<script type="text/javascript" src="/neoit/backment/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="/neoit/backment/ueditor/ueditor.all.js"></script>

 <!--   引入js jar包 -->
 <script type="text/javascript" src="/neoit/backment//js/jquery-1.7.2.min.js"></script>
 <link rel="stylesheet" type="text/css" href="/neoit/backment/css/css.css" />
</head>
<script type="text/javascript">
 /* 1.获取ueditor编辑器内容中img标签中图片的名称(alt的值), 保存到 <input/>中 */
	function picname(){
		 var newtitlepage =document.forms.userfile.value;
		 var newtitle =document.forms.title.value.trim();
		 var newscontent =document.forms.content.value.trim();
		 //alert("newtitlelength:"+newtitle.length);
		    if(newtitle.length>28)//标题字数过多则给出提示;
		    {
		        alert('新闻标题不得超过28个字符,请修改!');
		        return false;
		    }
		    if(newtitle.length==0)//没有添加标题则给出提示;
		    {
		        alert('新闻标题不能为空!');
		        return false;
		    }
		    if(newscontent.length==0)
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
		 // alert('已匹配的图片地址'+(i+1)+'：'+src[1]);
		 $("#savepic").append('保存的图片名称:<input type="text" name="pic" value="'+src[1]+'"/><br>');
				
		 }
		}}
		document.forms.submit();
	}
  //2.控制上传标题图片的大小
	 function check(){
   	    var obj = document.getElementById("userfile") ; 
	    var aa=document.getElementById("userfile").value.toLowerCase().split('.');//以“.”分隔上传文件字符串
	   // var aa=document.form1.userfile.value.toLowerCase().split('.');//以“.”分隔上传文件字符串
	    if(document.forms.userfile.value!="")
	   /*  {
	        alert('图片不能为空！');
	        return false;
	    }
	    else  */
	    {
	     //alert("进入check3...");
	    if(aa[aa.length-1]=='gif'||aa[aa.length-1]=='jpg'||aa[aa.length-1]=='bmp'
	     ||aa[aa.length-1]=='png'||aa[aa.length-1]=='jpeg')//判断图片格式
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
 </script>
<style type="text/css">
#tab{
border-collapse:collapse;

}
#tab td{
text-align:left;
border:1px gray solid; 
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
				<span style="color:#4390B9;"> &nbsp;&nbsp;新闻管理>>修改新闻</span>
			</div>
 </div> 

  <div  style="margin-left:25px;margin-top:10px; width:1025px;">
	<form action="update/updateNews.do"  name="forms" method="post"  enctype="multipart/form-data"  >
		<!--此div保存新闻中的图片的名字 -->
        <div id="savepic"></div>
        <!-- 保存news的其他信息传到后台 -->
        <input type="hidden" value="${news.id}" name="id" />
        <input type="hidden" value="${news.images}" name="images" />
        <input type="hidden" value="${news.titleImage}" name="titleImage" />
        <input type="hidden" value="${news.createTime}" name="createTime" />
        <input type="hidden" value="${news.htmlUrl}" name="htmlUrl" />
        <input type="hidden" value="${news.type}" name="type" />
        
        <table id="tab">
         <tr >
	         <td style="text-align: center;width: 150px;font-weight: 600;">新闻标题:</td>
	         <td><input id="title" name="title" value="${news.title}" size="62" /></td>
         </tr>
         <tr>
	         <td style="text-align: center;font-weight: 600;">标题图:<p style="font-size: 10px;color: gray;">(300x200)</p></td>
	         <td><input type="file"  name="smallpicture"  id="userfile" onchange="check()"/><p id="picsize"></p>
             <span style="font-size: 10px; color: gray;"> (注意:若不修改,则使用新闻原标题图片)</span></td>
         </tr>
         <tr>
	         <td style="text-align: center;font-weight: 600;">新闻概要:</td>
	         <td></p><textarea rows="2" cols="50"  name="resume">${news.resume}</textarea></td>
         </tr>
        
        <c:if test="${news.type==2}">
           <c:if test="${news.level==1}">
	         <tr>
		         <td style="text-align: center;font-weight: 600;">显示级别:</td>
		         <td><select  id =  "sel" name="level" >
					 <option  value = "1"  selected = "selected">普通显示</option >
					 <option  value = "2" >置顶</option >
					 </select ></td>
	         </tr>
	         </c:if>
	         <c:if test="${news.level==2}">
	         <tr>
		         <td style="text-align: center;font-weight: 600;">显示级别:</td>
		         <td><select  id =  "sel" name="level" >
					 <option  value = "1"  >普通显示</option >
					 <option  value = "2" selected = "selected">置顶</option >
					 </select ></td>
	         </tr>
	         </c:if>
       </c:if>
         <tr>
	         <td style="text-align: center;font-weight: 600;"> 文章作者:</td>
	         <td><input type="text"  value="${news.author }" name="author" /></td>
         </tr>
        
        </table>
         <!-- 更新者id 隐藏提交 -->
		<input type="hidden" value="${loginUser.id}" name="updateId" />
	
		<!-- 加载编辑器的容器 -->
		 <script id="container" name="content" type="text/plain" style="width:1024px;height:450px;">
${newsContent}
        </script>   
	  
	   <input type="button" onclick="picname()" value="点击更新" />
	
	</form>
  </div>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
	        var ue = UE.getEditor('container'); 
	</script>
</body>
</html>