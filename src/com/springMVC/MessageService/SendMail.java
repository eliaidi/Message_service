package com.springMVC.MessageService;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

public interface SendMail {
	
	public void setFrom(String from);
	public void setTo(String to);
	public String getFrom();
	public String getTo();
	public void sendTextEmail(String title,String text) throws Exception ;
	public void sendHtmlEmail(String title,String content,MyAuthenticator ma,InternetAddress ia,Date date) throws Exception ;
	//待修改
    public void sendHtmlWithInnerImageEmail(SendMailImpl sm,MyAuthenticator ma,String title,InternetAddress ia) throws MessagingException;
    //待修改
    public void sendMultipleEmail(String title,InternetAddress ia) throws Exception;
}
