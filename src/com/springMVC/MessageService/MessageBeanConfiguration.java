package com.springMVC.MessageService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBeanConfiguration {
	@Bean
	public MessageUtils messageUtils(){
		MessageUtilImpl bean=new MessageUtilImpl();
		return bean;
	}

}
