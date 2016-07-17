package com.springMVC.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.entity.Goods;
import com.springMVC.entity.ShoppingCart;

public class OrderTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(com.springMVC.Config.UserBeanConfiguration.class);
		EntityManagerFactory entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
//		ShoppingCart sp=new ShoppingCart();
//		sp.setId("4");
		Goods g1=new Goods();
		g1.setSku("113523");
		g1.setName("2");
//		sp.getGoods().add(g1);
		entityManager.persist(g1);
//		entityManager.persist(sp);
		transaction.commit();
		entityManager.close();
		
	}

}
