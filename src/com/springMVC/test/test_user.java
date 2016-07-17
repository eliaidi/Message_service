package com.springMVC.test;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.entity.User_basic;
import com.springMVC.userService.UserDao;

public class test_user {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(com.springMVC.Config.UserBeanConfiguration.class);
		User_basic user=new User_basic("name", "pwd", 12, null, "se","123@163.com", "123323");
		UserDao bean=applicationContext.getBean(UserDao.class);
		bean.AddUser(user);
//		ArrayList<User_basic> users=bean.FindAll();
//		for(int i=0;i<users.size();i++){
//	    System.out.println(users.get(i).toString());
//		}
		
	}

}
