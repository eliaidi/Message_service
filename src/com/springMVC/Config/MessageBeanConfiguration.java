package com.springMVC.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springMVC.MessageService.MessageUtilImpl;
import com.springMVC.MessageService.MessageUtils;
import com.springMVC.MessageService.SendMail;
import com.springMVC.MessageService.SendMailImpl;

@Configuration
public class MessageBeanConfiguration {
	@Bean
	public MessageUtils messageUtils(){
		MessageUtilImpl bean=new MessageUtilImpl();
		return bean;
	}
	@Bean
	public SendMail sendMail(){
		SendMailImpl bean=new SendMailImpl();
		return bean;
	}

}
