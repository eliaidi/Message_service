package com.springMVC.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.OrderService.GoodsDao;
import com.springMVC.OrderService.GoodsDaoImpl;
import com.springMVC.OrderService.ShoppingCartDao;
import com.springMVC.OrderService.ShoppingCartDaoImpl;
import com.springMVC.entity.Goods;
import com.springMVC.entity.ShoppingCart;

public class OrderTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(com.springMVC.Config.OrderServiceBeanConfiguration.class);
		GoodsDao d=applicationContext.getBean(GoodsDaoImpl.class);
		
		Goods g=new Goods("sku3", "name", 0, 0,"n","description",
				null, null,null, 1,"kind", 1);
		Goods g2=new Goods("sku2", "name", 0, 0,"n","description",
				null, null,null, 1,"kind", 1);
		ShoppingCart s= new ShoppingCart();
		ShoppingCartDao sCart=applicationContext.getBean(ShoppingCartDaoImpl.class);
//		sCart.DeleteCart("2"); 购物车增删改查没问题
//		d.AddGoods(g);   商品添加没问题
//		d.FindAll();   商品查找没问题
//		d.DeleteGoods("sku2");   商品删除没问题
//		d.UpdateCount("sku3", 100);  商品信息修改没问题
//		sCart.addGoodToCart("1", "sku3");
		
	}

}
