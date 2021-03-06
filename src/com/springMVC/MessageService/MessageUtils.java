package com.springMVC.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MessageUtils {
	//生成验证码
	public String creatCode();
	//正则验证手机号
	public boolean teltest(String tel);
	//发送信息
	public void request(String httpArg);
	//模板生成
	public String creatTemp(String tel,String code);
    public void renderData(HttpServletResponse response, String data);
	public String getJSONString(HttpServletRequest request);



}
