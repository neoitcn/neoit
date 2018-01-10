package com.qixin.neoit.ccmsinterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qixin.neoit.biz.AdminBiz;
import com.qixin.neoit.biz.IndexBiz;
import com.qixin.neoit.biz.StudentBiz;
import com.qixin.neoit.biz.TeacherBiz;
import com.qixin.neoit.entity.Edu_news;
import com.qixin.neoit.entity.Edu_student_job;
import com.qixin.neoit.entity.Edu_teachers;
import com.qixin.neoit.utils.InterfaceUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value ="cell")
@SessionAttributes("")
public class HttpInterfaceController {
	
	
	 /** 
	 * ccms司法项目调用的接口
	 * @author:zyj
	 * @date: 2018年1月9日
	 * 
	 */
	@ResponseBody
	@RequestMapping(value ="/locate",produces = "text/json;charset=UTF-8")
	public String httpInterface(String mcc,String mnc,String lac,String ci,String output){
			  InterfaceUtil restUtil = new InterfaceUtil();
	          String resultString=null;
	          try {
			 resultString = restUtil.load(
			  "http://139.129.20.175:81/cell/?mcc="+mcc+"&mnc="+mnc+"&lac="+lac+"&ci="+ci+"&output="+output,""
		     );
	          } catch (Exception e) {
				e.printStackTrace();
			}
		return resultString;
	}
	
}