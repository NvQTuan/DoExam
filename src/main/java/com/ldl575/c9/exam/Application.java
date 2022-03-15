package com.ldl575.c9.exam;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ld575.exam.Application;
import com.ld575.exam.db.Database;
import com.ld575.exam.page.DashBoard;

public class Application {
	
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel controlPanel;
	private static Database db;

	public static void main(String[] args) {
		Application app = new Application();
		connectDB();
		app.start();
	}

	private static void connectDB() {
		db = new Database();
		db.openConnection();
	}
	
	private void start() {
		this.setSize(1000, 600);
		controlPanel = new JPanel();
		BoxLayout layout = new BoxLayout(controlPanel, BoxLayout.X_AXIS);
		controlPanel.setLayout(layout);
		dashBoardPage();
		settingFrame();
	}

	private void settingFrame() {
		this.add(controlPanel);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Ứng dụng thi");
	}

	private void dashBoardPage() {
		DashBoard dashBoard = new DashBoard(this, controlPanel);
		dashBoard.show(controlPanel);
	}
}
