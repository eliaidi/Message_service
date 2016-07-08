package com.springMVC.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.MessageService.MessageUtils;

import net.sf.json.JSONObject;

@Controller
public class MessageController {
	//ajax请求地址
	@RequestMapping(value ={"/msgService/getSmsCode"}, method = {RequestMethod.POST})
	public void shortMassage(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ok");
		//获取管理器
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(com.springMVC.MessageService.MessageBeanConfiguration.class);
		//获取该bean
		MessageUtils mu=(MessageUtils) applicationContext.getBean("messageUtils");
		//获取手机号
		String tel=request.getParameter("mobileNumber");
		//定义需要反馈的json
		JSONObject json=new JSONObject();
		//测试验证手机号
		if(!mu.teltest(tel)){
			//设置失败的json
			json.accumulate("resultCode",0 );
			json.accumulate("resultMsg", "telError");
			json.accumulate("resultData", null);
		}else{
			//生成验证码并且发送
			String code=mu.creatCode();
			mu.request(mu.creatTemp(tel, code));
			//设置成功的json
			json.accumulate("resultCode",code );
			json.accumulate("resultMsg", "success");
			json.accumulate("resultData", null);
		}
		//写入response作出响应
		mu.renderData(response,json.toString());
	}
	//页面请求地址
	@RequestMapping(value="/hello")
	public ModelAndView show(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/hello");
		return mv;
	}
}
