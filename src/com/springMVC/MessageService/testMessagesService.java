package com.springMVC.MessageService;

public class testMessagesService {

	public static void main(String[] args) {
		MessageUtilImpl ml=new MessageUtilImpl();
		String arg=ml.creatTemp("18058519203", ml.creatCode());
		ml.request(arg);
	}

}
