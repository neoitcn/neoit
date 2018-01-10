package com.qixin.neoit.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/** 
* @author 作者 zyj: 
* @version 创建时间：2018年1月2日 上午11:57:32 
* 用于调用接口 
*/
public class InterfaceUtil {

	 public String load(String url,String query) throws Exception
	    {
	        URL restURL = new URL(url);
	        /*
	         * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
	         */
	        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
	        //请求方式
	        conn.setRequestMethod("POST");
	        //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
	        conn.setDoOutput(true);
	        //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
	        conn.setAllowUserInteraction(false);

	        PrintStream ps = new PrintStream(conn.getOutputStream());
	        ps.print(query);

	        ps.close();

	        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));

	        String line,resultStr="";

	        while(null != (line=bReader.readLine()))
	        {
	        resultStr +=line;
	        }
	        //System.out.println("结果:---"+resultStr);
	        bReader.close();

	        return resultStr;
}
	 //测试
	public static void main(String []args) {
	    try {
		 InterfaceUtil restUtil = new InterfaceUtil();
         String resultString = restUtil.load(
        		"http://139.129.20.175:81/cell/?mcc=460&mnc=01&lac=4308&ci=43698&output=json",
                "");
            System.out.println("1:"+resultString); 
            JSONObject job = JSONObject.fromObject(resultString);//转换为json对象
    		System.out.println("2:"+job.get("regeocode")); // 得到 每个对象中的属性值
    		JSONObject job2 = JSONObject.fromObject(job.get("regeocode"));//转换为json对象
    		System.out.println("3:"+job2.get("formatted_address")); 
	   
	    } catch (Exception e) {
         System.out.print(e.getMessage());
        }

     }
	
}
