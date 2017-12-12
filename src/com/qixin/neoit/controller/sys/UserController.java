package com.qixin.neoit.controller.sys;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qixin.neoit.biz.UserBiz;
import com.qixin.neoit.entity.Edu_teachers;
import com.qixin.neoit.entity.Sys_user;

@Controller
@RequestMapping(value = "user")
@SessionAttributes("")
public class UserController {
	@Resource(name = "userBiz")
	private UserBiz userBiz;

	 /** 
	 *  1.查询所有用户(后台功能)
	 * @author:zyj
	 * @date: 2017年12月12日
	 */
	@RequestMapping(value = "/SelectAllUsers")
	public String SelectAllUsers(int page, HttpServletRequest request) {

		try {
			System.out.println("进入SelectAllUsers....");

			// 判断登陆用户名是否为admin(超级管理员)
			HttpSession session = request.getSession();
			Sys_user uesr = (Sys_user) session.getAttribute("loginUser");
			if (!uesr.getName().equals("admin")) {
				request.setAttribute("msg", "您的权限不足,无法查看!");
				request.setAttribute("user", uesr);
				return "backment/users/usershow";
			}
			// 2.1普通新闻的查询
			if (page == 0) {
				page = 1;// 设置默认查询页数为1
			}
			int pages = userBiz.selectUserPages();// 获得总页数

			int nextpage = 0;// 设置上一页下一页
			int backpage = 0;

			if (page >= pages && pages != 0) {
				page = pages;
			}
			// 设置下一页
			if (page >= 1 && page < pages) {
				nextpage = page + 1;
			}
			if (pages == page) {
				nextpage = pages;
			}
			// 设置上一页
			if (page > 1 && page <= pages) {
				backpage = page - 1;

			}
			List<Sys_user> userList = null;
			userList = userBiz.selectUserBypage((page - 1) * 10);
			// 保存数据传到jsp
			request.setAttribute("userList", userList);
			request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("nextpage", nextpage);
			request.setAttribute("backpage", backpage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "backment/users/usershow";
	}

	 /** 
	 * 2.根据id删除用户(后台功能) 
	 * @author:zyj
	 * @date: 2017年12月12日
	 */
	@RequestMapping(value = "/deleteUserById")
	public String deleteUserById(Integer userid, HttpServletRequest request) {
		try {
			Sys_user user = userBiz.selectByPrimaryKey(userid);
			if (user.getName().equals("admin")) {
				return "backment/users/admin";
			}
			request.setAttribute("user", user);
			userBiz.deleteByPrimaryKey(userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "backment/users/deletesuccess";
	}

	/**
	 * 3.根据id查询用户信息
	 * @author:zyj
	 * @date: 2017年12月12日
	 */
	@RequestMapping(value = "/SelectUserById")
	public String SelectUserById(Integer userid, HttpServletRequest request) {
		try {
			System.out.println("进入SelectUserById()....");
			Sys_user user = userBiz.selectByPrimaryKey(userid);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "backment/users/updateuser";
	}

	/**
	 * 4.更新用户信息
	 * @author:zyj
	 * @date: 2017年12月12日
	 */
	@RequestMapping(value = "/UpdateUser")
	public String UpdateUser(Sys_user user, HttpServletRequest request) {
		try {
			// 设置更新时间
			Date date = new Date();
			user.setUpdateTime(date);
			userBiz.updateByPrimaryKeySelective(user);
			request.setAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "backment/users/updatesucc";
	}
	/**
	 * 5.登陆用户修改自己的密码
	 * 
	 * @author:zyj
	 * @date: 2017年12月12日
	 * 
	 */
	@RequestMapping(value = "UpdatePwd")
	public String UpdatePwd(Sys_user user, HttpServletRequest request) {

		Sys_user newuser = userBiz.selectByPrimaryKey(user.getId());
		newuser.setPassword(user.getPassword());
		userBiz.updateByPrimaryKeySelective(newuser);

		request.setAttribute("newuser", newuser);

		HttpSession session = request.getSession();
		session.invalidate();

		return "backment/users/changepwdsucc";

	}

	/**
	 * 6.退出系统
	 * @author:zyj
	 * @date: 2017年12月12日
	 * 
	 */
	@RequestMapping(value = "loginOut")
	public String loginOut(HttpServletRequest request) {
		// 清除session中用户数据信息
		HttpSession session = request.getSession();
		session.invalidate();
		return "backment/users/loginoutsucc";

	}
}
