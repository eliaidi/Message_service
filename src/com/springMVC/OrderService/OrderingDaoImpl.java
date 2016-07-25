package com.springMVC.OrderService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.entity.Goods;
import com.springMVC.entity.Ordering;

public class OrderingDaoImpl implements OrderingDao {
	private static AnnotationConfigApplicationContext applicationContext;
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		applicationContext = new AnnotationConfigApplicationContext(com.springMVC.Config.Hibernate_configBeanConfiguration.class);
		entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
	}

	@Override
	public int addOrder(Ordering order) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(order);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int deleteOrder(String id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String sql="select o from Ordering o where id like ?";
		Query query=entityManager.createQuery(sql);
		List<Ordering> o=query.getResultList();
		entityManager.remove(o.get(0));
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int updateOrderAddress(String id, String address) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String sql="select o from Ordering o where id like ?";
		Query query=entityManager.createQuery(sql);
		List<Ordering> o=query.getResultList();
		o.get(0).setAddress(address);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int updateOrderTel(String id, String tel) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String sql="select o from Ordering o where id like ?";
		Query query=entityManager.createQuery(sql);
		List<Ordering> o=query.getResultList();
		o.get(0).setTel(tel);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public Ordering findOne(String id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String sql="select o from Ordering o where id like ?";
		Query query=entityManager.createQuery(sql);
		List<Ordering> o=query.getResultList();
		transaction.commit();
		entityManager.close();
		return o.get(0);
	}

	@Override
	public List<Ordering> findall() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String sql="select o from Ordering o where id like ?";
		Query query=entityManager.createQuery(sql);
		List<Ordering> o=query.getResultList();
		transaction.commit();
		entityManager.close();
		return o;
	}

	@Override
	public int addGoods(ArrayList<Goods> goods) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String sql="select o from Ordering o where id like ?";
		Query query=entityManager.createQuery(sql);
		List<Ordering> o=query.getResultList();
		for(int i=0;i<goods.size();i++){
		o.get(0).getGoods().add(goods.get(i));
		}
		transaction.commit();
		entityManager.close();
		return 1;
	}
	
}
