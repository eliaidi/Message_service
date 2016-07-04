package com.springMVC.shortMessage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBeanConfiguration {
	@Bean
	public SendMessage sendMessage(){
		SendMessageImpl bean=new SendMessageImpl();
		return bean;
	}
	@Bean
	public MessageTemplate messageTemplate(){
		MessageTemplate bean=new MessageTemplate();
		return bean;
	}
	@Bean
	public MessageUtils messageUtils(){
		MessageUtilImpl bean=new MessageUtilImpl();
		return bean;
	}

}
