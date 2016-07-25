package com.springMVC.OrderService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.entity.Goods;
import com.springMVC.entity.User_basic;

public class GoodsDaoImpl implements GoodsDao {
	private static AnnotationConfigApplicationContext applicationContext;
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		applicationContext = new AnnotationConfigApplicationContext(com.springMVC.Config.Hibernate_configBeanConfiguration.class);
		entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
	}

	@Override
	public int AddGoods(Goods goods) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(goods);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int DeleteGoods(String id) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<Goods> goods=query.getResultList();
		entityManager.remove(goods.get(0));
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public List<Goods> FindAll() {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g";
		Query query=entityManager.createQuery(sql);
		List<Goods> goods=query.getResultList();
		entityManager.remove(goods.get(0));
		transaction.commit();
		entityManager.close();
		return goods;
	}

	@Override
	public List<Goods> NameFind(String name) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.name like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1,name);
		List<Goods> goods=query.getResultList();
		transaction.commit();
		entityManager.close();
		return goods;
	}

	@Override
	public Goods IdFind(String Id) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, Id);
		List<Goods> goods=query.getResultList();
		transaction.commit();
		entityManager.close();
		return goods.get(0);
	}

	@Override
	public int UpdateName(String name,String sku) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, sku);
		List<Goods> goods=query.getResultList();
		Goods gg=goods.get(0);
		gg.setName(name);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int UpdatePrice(String sku,double price) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, sku);
		List<Goods> goods=query.getResultList();
		Goods gg=goods.get(0);
		gg.setShopPrice(price);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int UpdateCount(String sku,int count) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, sku);
		List<Goods> goods=query.getResultList();
		Goods gg=goods.get(0);
		gg.setStock(count);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int UpdateIsOnSale(String sku,String isOnSale) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, sku);
		List<Goods> goods=query.getResultList();
		Goods gg=goods.get(0);
		gg.setName(isOnSale);
		transaction.commit();
		entityManager.close();
		return 1;
	}

}
