package com.qixin.neoit.test;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tomcat.jni.User;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.NodeList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qixin.neoit.biz.AdminBiz;
import com.qixin.neoit.biz.IndexBiz;
import com.qixin.neoit.entity.Edu_news;
import com.qixin.neoit.entity.Sys_user;

public class Test {

	public static void main(String[] args) throws Exception {
	
		List<Sys_user> createrList=new ArrayList<Sys_user>();
		Sys_user user=new Sys_user();
		user.setRealName("323");
		createrList.add(user);
		System.out.println("createrList:"+createrList.get(0).getRealName());
	
	}

}