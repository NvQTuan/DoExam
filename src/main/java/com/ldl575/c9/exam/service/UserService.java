package com.ldl575.c9.exam.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ldl575.c9.exam.HibernateUtil;
import com.ldl575.c9.exam.entity.UserEntity;

public class UserService {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public void save(UserEntity userEntity) {

		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			session.save(userEntity);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UserEntity findById(Long id) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(getQueryById());
			query.setParameter("id", id);
			UserEntity res = (UserEntity) query.getSingleResult();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String getQueryById() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u ")
			.append("FROM UserEntity u ")
			.append("WHERE u.id = :id ");
		return sql.toString();
	}
	
	public UserEntity findByUserName(String userName) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(getQueryByUserName());
			query.setParameter("userName", userName);
			UserEntity res = (UserEntity) query.getSingleResult();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String getQueryByUserName() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u ")
			.append("FROM UserEntity u ")
			.append("WHERE u.userName = :userName ");
		return sql.toString();
	}
}
