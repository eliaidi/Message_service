package com.springMVC.shortMessage;

import java.util.Random;

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
		result=true;
		return result;
	}

}
