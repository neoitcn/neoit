package com.qixin.neoit.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qixin.neoit.biz.UserBiz;
import com.qixin.neoit.entity.Sys_user;

@Controller
@RequestMapping(value = "login")
@SessionAttributes("")
public class LoginController {
	@Resource(name = "userBiz")
	private UserBiz userBiz;
	
	//后台用户登录
	@RequestMapping(value="/AdminLogin")
	public String AdminLogin(Sys_user user,String yzm, HttpServletRequest request){
		HttpSession session=request.getSession();
		//session.setMaxInactiveInterval(60*60*5);//设置session失效时间为5个小时
		String picyzm=session.getAttribute("yzm").toString();
		if(user.getName().contains(" ")){
			request.setAttribute("msg", "<p style='color:red;'>用户名输入非法,请重新输入!</p>");
			return "backment/login";
		}
		if(user.getPassword().contains(" ")){
			request.setAttribute("msg", "<p style='color:red;'>密码输入非法,请重新输入!</p>");
			return "backment/login";
		}
		
		Map<String,Object>  map=new HashMap<String, Object>();
		map.put("name", user.getName());
		map.put("password", user.getPassword());
		Sys_user checkuser=userBiz.selectUserByNameAndPwd(map);
		if(checkuser==null){
			request.setAttribute("msg", "<p style='color:red;'>用户名或密码错误,请重新输入!</p>");
			return "backment/login";
		}
		if(!picyzm.equals(yzm)){
			request.setAttribute("msg", "<p style='color:red;'>验证码错误,请重新输入!</p>");
			return "backment/login";
		}
		//更新用户最近登陆时间
		Date date=new Date();
		checkuser.setLoginTime(date);
		userBiz.updateByPrimaryKeySelective(checkuser);
		//保存用户信息到session中
		session.setAttribute("loginUser", checkuser);
		
		return "redirect:/backment/index.jsp";
	}
	
	
	

	
}
