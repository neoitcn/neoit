package com.qixin.neoit.test;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
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

import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

public class Test {

	public static void main(String[] args) throws Exception {
	
	/*	List<Sys_user> createrList=new ArrayList<Sys_user>();
		Sys_user user=new Sys_user();
		user.setRealName("323");
		createrList.add(user);
		System.out.println("createrList:"+createrList.get(0).getRealName());*/
	
	
	    //String	message="123211";//MD5:65F3772CD5D16F190CE4991408114607
	    String	message="zhuyuanjie11";///MD5:5EA4021F17007A563956FFC563A475E1
	    String	md5="";
		MessageDigest md = MessageDigest.getInstance("MD5");  // ����һ��md5�㷨����  
		byte[] messageByte = message.getBytes("UTF-8");  
		byte[] md5Byte = md.digest(messageByte);              // ���MD5�ֽ�����,16*8=128λ  
	    md5 = bytesToHex(md5Byte);       
	
	   System.out.println("MD5:"+md5);
		
		/*String str="������ְ�";
	   //ȷ�����㷽��
       MessageDigest md5=MessageDigest.getInstance("MD5");
       BASE64Encoder base64en = new BASE64Encoder();
       //���ܺ���ַ���
       String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
       System.out.println("newstr:"+newstr);*/
	
	}
	
	public static String bytesToHex(byte[] bytes) {  
	        StringBuffer hexStr = new StringBuffer();  
	        int num;  
	        for (int i = 0; i < bytes.length; i++) {  
	            num = bytes[i];  
	             if(num < 0) {  
	                 num += 256;  
	            }  
	            if(num < 16){  
	                hexStr.append("0");  
	            }  
	            hexStr.append(Integer.toHexString(num));  
	        }  
	        return hexStr.toString().toUpperCase();  
	}  
}