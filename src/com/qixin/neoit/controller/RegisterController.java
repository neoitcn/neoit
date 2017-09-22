package com.qixin.neoit.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qixin.neoit.biz.UserBiz;
import com.qixin.neoit.entity.Sys_user;

@Controller
@RequestMapping(value = "reg")
@SessionAttributes("")
public class RegisterController {
	@Resource(name = "userBiz")
	private UserBiz userBiz;
	
	@RequestMapping(value="/Register")
	public String Register( Sys_user user,  HttpServletRequest request){
		if(user!=null){
			Sys_user cuser=userBiz.selectByName(user.getName());
			if(cuser==null){
				//设置注册时间
				Date date=new Date();
				user.setCreateTime(date);
				userBiz.insertSelective(user);
				request.setAttribute("user", user);
				
			}else{
				request.setAttribute("msg", "用户名已存在,请修改!");
				return "backment/users/useradd";
			}
			
		}
		
		return "backment/users/registersuccess";
	}
	
	
}
