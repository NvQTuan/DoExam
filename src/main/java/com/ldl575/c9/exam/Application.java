package com.ldl575.c9.exam;

import org.hibernate.SessionFactory;

import com.ldl575.c9.exam.page.Login;

public class Application {
	
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
//	public static void main(String[] args) {
//		SessionFactory sessionFatory = HibernateUtils.getSessionFactory();
//		Session session = sessionFatory.getCurrentSession();
//		try {
//			session.getTransaction().begin();
//			Query query = session.createQuery("select u from UserEntity u");
//			List list = query.getResultList();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.LoginPage();
	}

//	private void settingFrame() {
//		this.add(controlPanel);
//		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setVisible(true);
//		this.setTitle("Ứng dụng thi");
//	}

	private void LoginPage() {
		Login login = new Login();
		login.start();
	}
}
