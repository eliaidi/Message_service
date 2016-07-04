package com.springMVC.shortMessage;

public class MessageTemplate {
	//消息模板
	static private String messageTemp_verify_first;//验证码
	static private String messageTemp_verify_end;

	
	static{
		messageTemp_verify_first="%e3%80%90%e9%82%b9%e5%bf%97%e5"
				+"%85%a8%e3%80%91%e6%82%a8%e7%9a%84%e9%aa%8c%e"
				+"8%af%81%e7%a0%81%e6%98%af";
		
		messageTemp_verify_end="%ef%bc%8c%e6%9c%89%e6%95%88%e6%"
				+"97%b6%e9%97%b45%e5%88%86%e9%92%9f%ef%bc%8c%e8%"
				+"af%b7%e4%b8%8d%e8%a6%81%e5%91%8a%e8%af%89%e4%bb%96%e4%ba%ba";
	}

	public MessageTemplate() {
	
	}

	public static String getMessageTemp_verify_first() {
		return messageTemp_verify_first;
	}

	public static String getMessageTemp_verify_end() {
		return messageTemp_verify_end;
	}
	
	
	

}
