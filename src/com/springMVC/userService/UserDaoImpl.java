package com.springMVC.userService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springMVC.entity.User_basic;
import com.springMVC.entity.User_member;
import com.springMVC.entity.User_service;

public class UserDaoImpl implements UserDao {
	private static AnnotationConfigApplicationContext applicationContext;
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		applicationContext = new AnnotationConfigApplicationContext(com.springMVC.userService.UserBeanConfiguration.class);
		entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
	}

	@Override
	public int AddUser(User_basic user) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(user);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int DeleteUser(String id) {
		
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select u from User_basic u where u.id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<User_basic> users=query.getResultList();
		entityManager.remove(users.get(0));
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int UpdateUser(User_basic user) {
		
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select u from User_basic u where u.id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, user.getId());
		List<User_basic> users=query.getResultList();
		users.get(0).allset(user);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public User_basic FindOne(String id) {
		
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select u from User_basic u where u.id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<User_basic> users=query.getResultList();
		transaction.commit();
		entityManager.close();
		return users.get(0);
	}

	@Override
	public ArrayList<User_basic> FindAll() {
		
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select u from User_basic u";
		Query query=entityManager.createQuery(sql);
		List<User_basic> users=query.getResultList();
		transaction.commit();
		entityManager.close();
		return (ArrayList<User_basic>) users;
	}
	
	@Override
	public int updatePower(int power,String id){
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select u from User_basic u where u.id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<User_basic> users=query.getResultList();
		users.get(0).setPower(power);
		return 1;
	}

	@Override
	public int updatePwd(String pwd,String id){
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select u from User_basic u where u.id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<User_basic> users=query.getResultList();
		users.get(0).setPwd(pwd);
		return 1;
	}
	@Override
	public int UpdateUserService(User_service suser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User_service FindOneService(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User_service> FindAllService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int AddMember(String id) {

		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		User_member member=new User_member(id);
		entityManager.persist(member);
		transaction.commit();
		entityManager.close();
		return 1;
	}

	@Override
	public int DeleteMember(String id) {
	
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String sql="select u from User_member m where m.id like ?";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, id);
		List<User_member> members=query.getResultList();
		entityManager.remove(members.get(0));
		transaction.commit();
		entityManager.close();
		return 1;
	}

}
