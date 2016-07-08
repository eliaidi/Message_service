package com.springMVC.MessageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageUtilImpl implements MessageUtils {
	//产生验证码
	@Override
	public String creatCode() {
		Random rd = new Random();
		  String code="";
		  int getNum;
		  do {
		   getNum = Math.abs(rd.nextInt())%10 + 48;//产生数字0-9的随机数
		   //getNum = Math.abs(rd.nextInt())%26 + 97;//产生字母a-z的随机数
		   char num1 = (char)getNum;
		   String dn = Character.toString(num1);
		   code += dn;
		  } while (code.length()<6);
		return code;
	}
	//正则验证手机号
	@Override
	public boolean teltest(String tel) {
		boolean result;
		//待扩展
		
		result=true;
		return result;
	}
	//模板生成
	public String creatTemp(String tel,String code){
		String httpArg=null;
		httpArg = "mobile="+tel+"&content=%e3%80%90%e9%82%b9%e5%bf%97%e5%85%a8%e3%80%91%e6%82%a8%e7%9a%84%e9%aa%8c%e8%af%81%e7%a0%81%e6%98%af"+code+"%ef%bc%8c%e6%9c%89%e6%95%88%e6%97%b6%e9%97%b45%e5%88%86%e9%92%9f%ef%bc%8c%e8%af%b7%e4%b8%8d%e8%a6%81%e5%91%8a%e8%af%89%e4%bb%96%e4%ba%ba";
		return httpArg;
	}
	//发送验证码短信
	@Override
	public  void request( String httpArg) {
		String httpUrl="http://apis.baidu.com/kingtto_media/106sms/106sms";
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	        connection.setRequestProperty("apikey",  "76921004adbdb74eb29c12e79ae38ee7");
	        connection.connect();
	        connection.getInputStream();
	  }
	        catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public String getJSONString(HttpServletRequest request) {
		return null;
	  }

	  /**
	   * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	   * 
	   * @param response
	   * @param data 
	   */
	@Override
	  public void renderData(HttpServletResponse response, String data) {
			    PrintWriter printWriter = null;
			    try {
			      printWriter = response.getWriter();
			      printWriter.print(data);
			    } catch (IOException ex) {
			    	System.out.println(ex);
			    } finally {
			      if (null != printWriter) {
			        printWriter.flush();
			        printWriter.close();
			      }
			    
			  }
	  }
	
	

}
