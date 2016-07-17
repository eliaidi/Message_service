package com.springMVC.MessageService;

import org.junit.Test;

public class testMessagesService {
	
	@Test
	public void send(){
		MessageUtilImpl ml=new MessageUtilImpl();
		String arg=ml.creatTemp("13863638369", ml.creatCode());
		ml.request(arg);
	}

}
