package com.springMVC.userService;

import java.sql.Blob;
import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.entity.User_basic;

public class UserManagerImpl implements UserManager {

	@Override
	public int AddUser(String name, String pwd, int age, Blob image, String sex, String mail,String tel) {
		User_basic user = new User_basic(name,pwd,age,image,sex,mail,tel);
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(UserBeanConfiguration.class);
		UserDao bean=applicationContext.getBean(UserDao.class);
		return bean.AddUser(user);
	}

	@Override
	public int DeleteUser(String id) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(UserBeanConfiguration.class);
		UserDao bean=applicationContext.getBean(UserDao.class);
		return bean.DeleteUser(id);
	}

	@Override
	public User_basic FindOne(String id) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(UserBeanConfiguration.class);
		UserDao bean=applicationContext.getBean(UserDao.class);
		return bean.FindOne(id);
	}

	@Override
	public ArrayList<User_basic> FindAll() {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(UserBeanConfiguration.class);
		UserDao bean=applicationContext.getBean(UserDao.class);
		return bean.FindAll();
	}

	@Override
	public int UserToMember(String id) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(UserBeanConfiguration.class);
		UserDao bean=applicationContext.getBean(UserDao.class);
		if(bean.FindOne(id)!=null){//此处并上订单服务返回值
			bean.AddMember(id);
			return 1;
		}
		else{
		return 0;
		}
	}

	@Override
	public int UpdatePower(String id) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(UserBeanConfiguration.class);
		UserDao bean=applicationContext.getBean(UserDao.class);
		if(bean.FindOne(id)!=null){//此处并上订单服务返回值
			int power = 1;//权限控制策略
			bean.updatePower(power, id);
			return 1;
		}
		else{
		return 0;
		}
	}
	
	@Override
	public int UpdatePwd(String pwd,String id){
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(UserBeanConfiguration.class);
		UserDao bean=applicationContext.getBean(UserDao.class);
		if(bean.FindOne(id)!=null){
			bean.updatePwd(pwd, id);
			return 1;
		}
		else{
			return 0;
		}
	}

}
