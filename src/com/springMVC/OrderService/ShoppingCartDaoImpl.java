package com.springMVC.OrderService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.entity.Goods;
import com.springMVC.entity.ShoppingCart;

public class ShoppingCartDaoImpl implements ShoppingCartDao {
	
	private static AnnotationConfigApplicationContext applicationContext;
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		applicationContext = new AnnotationConfigApplicationContext(com.springMVC.Config.Hibernate_configBeanConfiguration.class);
		entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
	}

	@Override
	public int DeleteCart(String id) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select c from ShoppingCart c where c.id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<ShoppingCart> c=query.getResultList();
		entityManager.remove(c.get(0));
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int AddCart(String id) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		ShoppingCart cart=new ShoppingCart();
		cart.setId(id);
		entityManager.persist(cart);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public ShoppingCart FindCart(String id) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select c from ShoppingCart c where c.id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<ShoppingCart> c=query.getResultList();
		transaction.commit();
		entityManager.close();
		return c.get(0);
	}

	@Override
	public int UpdateTotal() {
		return 0;
	}

	@Override
	public int addGoodToCart(String id, String sku) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, sku);
		List<Goods> g=query.getResultList();
		sql="select c from ShoppingCart c where c.id like ?";
		Query query1=entityManager.createQuery(sql);
		query1.setParameter(1, id);
		List<ShoppingCart> cart=query1.getResultList();
		cart.get(0).getGoods().add(g.get(0));
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int addGoodsToCart(String id, String[] sku) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, sku);
		List<Goods> g=query.getResultList();
		for(int i=0;i<sku.length;i++){
		sql="select c from ShoppingCart c where c.id like ?";
		Query query1=entityManager.createQuery(sql);
		query1.setParameter(1, id);
		List<ShoppingCart> cart=query1.getResultList();
		cart.get(0).getGoods().add(g.get(0));
		}
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int deleteGoodFromCart(String id, String sku) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, sku);
		List<Goods> g=query.getResultList();
		sql="select c from ShoppingCart c where c.id like ?";
		Query query1=entityManager.createQuery(sql);
		query1.setParameter(1, id);
		List<ShoppingCart> cart=query1.getResultList();
		cart.get(0).getGoods().remove(g.get(0));
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int deleteGoodsFromCart(String id, String sku[]) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select g from Goods g where g.sku like ?";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, sku);
		List<Goods> g=query.getResultList();
		for(int i=0;i<sku.length;i++){
		sql="select c from ShoppingCart c where c.id like ?";
		Query query1=entityManager.createQuery(sql);
		query1.setParameter(1, id);
		List<ShoppingCart> cart=query1.getResultList();
		cart.get(0).getGoods().remove(g.get(0));
		}
		transaction.commit();
		entityManager.close();
		return 1;		
	}

	@Override
	public List<Goods> FindAllGoods(String id) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select c from ShoppingCart c where c.id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<ShoppingCart> c=query.getResultList();
		List<Goods> goods=(List<Goods>) c.get(0).getGoods();
		return goods;
	}

}
