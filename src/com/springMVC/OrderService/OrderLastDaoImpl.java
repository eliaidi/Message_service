package com.springMVC.OrderService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.entity.OrderLast;
import com.springMVC.entity.Ordering;

public class OrderLastDaoImpl implements OrderLastDao {
	private static AnnotationConfigApplicationContext applicationContext;
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		applicationContext = new AnnotationConfigApplicationContext(com.springMVC.Config.Hibernate_configBeanConfiguration.class);
		entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
	}

	@Override
	public int addOrder(OrderLast order) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(order);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public OrderLast findOrder(String id) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select o from OrderLast o where id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<OrderLast> o=query.getResultList();
		transaction.commit();
		entityManager.close();
		return o.get(0);
	}

	@Override
	public List<OrderLast> findAllOrder() {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select o from OrderLast o ";
		Query query=entityManager.createQuery(sql);
		List<OrderLast> o=query.getResultList();
		transaction.commit();
		entityManager.close();
		return o;	
	}

}
