package com.springMVC.Config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.springMVC.userService.UserDao;
import com.springMVC.userService.UserDaoImpl;
import com.springMVC.userService.UserManager;
import com.springMVC.userService.UserManagerImpl;

@Configuration
public class UserBeanConfiguration {
    
	@Bean
	public UserDao userDao(){
		UserDao bean=new UserDaoImpl();
		return bean;
	}
	
	@Bean
	public UserManager userManager(){
		UserManager bean=new UserManagerImpl();
		return bean;
	}
	

}
