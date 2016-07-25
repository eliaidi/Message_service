package com.springMVC.OrderService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.entity.Goods;
import com.springMVC.entity.Goods_Cart;
import com.springMVC.entity.ShoppingCart;

public class Goods_CountDao {
	private static AnnotationConfigApplicationContext applicationContext;
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		applicationContext = new AnnotationConfigApplicationContext(com.springMVC.Config.Hibernate_configBeanConfiguration.class);
		entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
	}
	//增加一个商品数量
	public int addGoodToCart(String id, String sku,int count) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Goods_Cart gc=new Goods_Cart(id,  sku, count);
		entityManager.persist(gc);
		transaction.commit();
		entityManager.close();
		return 1;
	}
	//修改一个商品数量
	public int updateGoodToCart(String id, String sku,int count) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods_Cart g where g.id like ? and Goods_Cart g where g.sku like ?";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, id);
		query.setParameter(2, sku);
		List<Goods_Cart> g=query.getResultList();
		g.get(0).setCount(count);
		transaction.commit();
		entityManager.close();
		return 1;
	}
	//删除一个商品
	public int deleteGoodToCart(String id, String sku,int count) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods_Cart g where g.id like ? and Goods_Cart g where g.sku like ?";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, id);
		query.setParameter(2, sku);
		List<Goods_Cart> g=query.getResultList();
		entityManager.remove(g.get(0));
		transaction.commit();
		entityManager.close();
		return 1;
	}

}
