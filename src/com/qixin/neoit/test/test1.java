package com.qixin.neoit.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author ��ũС�� H20121012.java 2012-10-12����11:40:21
 */
public class test1 {
	/**
	 * ���ܣ�Java��ȡtxt�ļ������� ���裺1���Ȼ���ļ���� 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
	 * 3����ȡ������������Ҫ��ȡ�����ֽ��� 4��һ��һ�е������readline()�� ��ע����Ҫ���ǵ����쳣���
	 * 
	 * @param filePath
	 */
	public static void readTxtFile(String filePath) {
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String newsStr="";
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine())!= null) {
					 System.out.println("lineTxt:"+lineTxt);
					 if(lineTxt.contains("<div id=\"con\">")){
						 String [] newsc=lineTxt.split("<div id=\"con\">");
					     newsStr+=newsc[1];
					 }
					 if(lineTxt.contains("</div></article>")){
						 String [] newsc=lineTxt.split("</div></article>");
					  	 newsStr+=newsc[0];
					 }
					 
					System.out.println("newsStr:"+newsStr);
				
				}
				read.close();
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}

	}

	public static void main(String argv[]) {
		String filePath = "E:/github/neoit/WebContent/pages/news/2/1504517432452.html";

		readTxtFile(filePath);
	}

}