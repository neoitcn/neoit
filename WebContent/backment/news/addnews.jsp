<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		 var newtitlepage =document.forms.userfile.value;
		 var newtitle =document.forms.title.value.trim();
		 var newscontent =document.forms.content.value.trim();
		 var newsresume =document.forms.resume.value.trim();
		 var newstype =document.forms.type.value;
		 var newslevel =document.forms.level.value;
		 
		   if(newstype==1&&newslevel==2){
			   alert('头条新闻不得置顶显示,请修改显示级别!');
			   return false;
		   }
		    if(newtitle.length>28)//标题给出提示;
		    {
		        alert('新闻标题不得超过28个字符,请修改!');
		        return false;
		    }
		    if(newtitle.length==0)//没有上传标题则给出提示;
		    {
		        alert('新闻标题不能为空!');
		        return false;
		    }
		    if(newtitlepage=="")
		    {
		        alert('新闻标题缩略图不能为空,请上传!');
		        return false;
		    }
		    if(newsresume.length==0)//没有添加概要则给出提示;
		    {
		        alert('新闻概要不能为空,请输入!');
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
		 // alert('已匹配的图片地址'+(i+1)+'：'+src[1]);
		 $("#savepic").append('保存的图片名称:<input type="text" name="pic" value="'+src[1]+'"/><br>');
				
		 }
		}}
		if(confirm("确定发布？")){
		 document.forms.submit();
		}
	}
  //2.控制上传标题图片的大小
	 function check(){
   	    var obj = document.getElementById("userfile") ; 
	    var aa=document.getElementById("userfile").value.toLowerCase().split('.');//以“.”分隔上传文件字符串
	   // var aa=document.form1.userfile.value.toLowerCase().split('.');//以“.”分隔上传文件字符串
	    if(document.forms.userfile.value=="")
	    {
	        alert('图片不能为空！');
	        return false;
	    }
	    else
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
	   };
 
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
	width:120px; 
	text-align:right;  
	padding-right:20px;
	height:36px;
	font-weight:bolder;
	font-family:微软雅黑;
}
#td_right
{
	text-align:left;
	padding-left:25px; 
	padding-right:10px;
	height:36px;
	width:760px
}
</style>
 <%  
 if (session.getAttribute("loginUser")==null ){%>
 <jsp:forward page="/backment/login.jsp" ></jsp:forward>
 <%}%>

<body >
 <div class="pageTop">
			<div class="page">
				<img src="/neoit/backment/img/coin02.png" />
				<span style="color:#4390B9;"> &nbsp;&nbsp;新闻管理>>添加新闻</span>
			</div>
 </div> 

  <div  style="margin-left:25px;margin-top:10px; width:1025px;">
	<form action="../../admin/uploadNews.do"  name="forms" method="post"  enctype="multipart/form-data"  >
		<!--此div保存新闻中的图片的名字 -->
        <div id="savepic"></div>
        <table id="tab">
         <tr >
	         <td  id="td_left">新闻标题<span style="color:red">*</span>:<p style="font-size: 10px; color: gray;">(28个字符以内)</p></td>
	         <td id="td_right">
	         	<input id="title" name="title" size="62" disable="false"   style="width: 843px; "/>
	         	<span style="display:none" id="errorMsg"/>
	         </td>
         </tr>
         <tr>
	         <td  id="td_left">标题图<span style="color:red">*</span>:<p style="font-size: 10px;color: gray;">(学院:300x200<br/>轮播图:1500x400)</p></td>
	         <td id="td_right"><input type="file"  name="smallpicture"  id="userfile" onchange="check()"/><p id="picsize"></p></td>
         </tr>
         <tr style="height: 45px; ">
	         <td  id="td_left">新闻概要<span style="color:red">*</span>:<p style="font-size: 10px; color: gray;">(30字左右)</p></td>
	         <td id="td_right" style="height:70px;">
	         <textarea rows="2" cols="50" name="resume" style="width: 848px; height: 70px; "  ></textarea>
	         </td>
         </tr>
         <tr>
	         <td  id="td_left">新闻类型<span style="color:red">*</span>:</td>
	         <td id="td_right"><select  id =  "sel" name="type" >
					 <option  value = "1" >头条新闻</option >
					 <option  value = "2" selected = "selected" >学院新闻</option >
				  </select >
				 <span style="font-size: 10px; color: gray;"> 注意:头条新闻表示首页滚动大图(不能置顶显示)，学院新闻表示其下方的小新闻(可置顶)。</span>
			 </td>
         </tr>
         <tr>
	         <td  id="td_left"> 显示级别:</td>
	         <td id="td_right"><select  id =  "sel" name="level" >
				 <option  value = "1"  selected = "selected">普通显示</option >
				 <option  value = "2" >置顶</option >
				 </select ></td>
         </tr>
         <tr>
	         <td  id="td_left"> 文章作者<span style="color:red">*</span>:</td>
	         <td id="td_right"><input type="text"  name="author"  value="&nbsp;请输入作者_" onfocus="if (value =='&nbsp;请输入作者_'){value =''}" onblur="if (value ==''){value='&nbsp;请输入作者_'}" style="width: 211px; "/></td>
         </tr>
       </table>
       <!-- 创建者id 隐藏提交 -->
	   <input type="hidden" value="${loginUser.id}" name="createId"  />
	    
		<!-- 加载编辑器的容器 -->
		 <script id="container" name="content" type="text/plain" style="width:1024px;height:450px;">
  此处开始输入新闻内容...
        </script>   
	   <!-- <a href="javascript:picname()" style="text-decoration: none;">提交</a> -->
	   <input type="button" onclick="picname()" value="点击发布" />
	</form>
  </div>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
	        var ue = UE.getEditor('container'); 
	</script>

	<script>
		function valid(){
		    //获取name为123对应的input输入框中的值
		    var val = $("#title").val();
		    if(val == ""|| $.trim(val) == ""){
		        //如果val为空或者空格，将错误消息显示在对应span
		        $("#errorMsg").html('不能为空');
		        //让span显示出来
		        $("#errorMsg").show();
		    }
		}
	</script>
</body>
</html>