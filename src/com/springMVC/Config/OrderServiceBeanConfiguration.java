package com.springMVC.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springMVC.OrderService.GoodsDao;
import com.springMVC.OrderService.GoodsDaoImpl;
import com.springMVC.OrderService.OrderLastDao;
import com.springMVC.OrderService.OrderLastDaoImpl;
import com.springMVC.OrderService.OrderingDao;
import com.springMVC.OrderService.OrderingDaoImpl;
import com.springMVC.OrderService.ShoppingCartDao;
import com.springMVC.OrderService.ShoppingCartDaoImpl;

@Configuration
public class OrderServiceBeanConfiguration {
	
	@Bean
	public GoodsDao goodsDao(){
		GoodsDao bean=new GoodsDaoImpl();
		return bean;
	}
	
	@Bean
	public OrderingDao orderingDao(){
		OrderingDao bean=new OrderingDaoImpl();
		return bean;
	}
	
	@Bean
	public OrderLastDao orderLastDaoImpl(){
		OrderLastDao bean= new OrderLastDaoImpl();
		return bean;
	}
	
	@Bean
	public ShoppingCartDao shoppingCartDao(){
		ShoppingCartDao bean = new ShoppingCartDaoImpl();
		return bean;
	}

}
