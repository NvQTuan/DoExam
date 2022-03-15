package com.ldl575.c9.exam;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.ld575.exam.listener.BtnDocumentListener;
import com.ld575.exam.listener.BtnLoginListener;
import com.ld575.exam.listener.BtnManageListener;
import com.ld575.exam.listener.BtnTestExamListener;

public class Menu {

	private boolean isAdmin = true;
	
	private JFrame frame;
	
	private static final String MANAGE = "Quản lý";
	private static final String USER = "Người dùng";
	private static final String MANAGE_EXAM = "Quản lý bài thi"; 
	
	private static final String DO_EXAM = "Làm bài thi";
	private static final String DOCUMENT = "Tài liệu";
	private static final String INFOR = "Thông tin";
	private static final String LOGIN = "Đăng nhập";
	private static final String LOGOUT = "Đăng xuất";
	
	private String currentMenu;
	
	public MenuExam() {
	}
	
	public MenuExam(JFrame frame, String currentMenu) {
		this.frame = frame;
		this.currentMenu = currentMenu;
	}
	
	public JMenuBar getMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu manageMenu = new JMenu(MANAGE);
		JMenu inforMenu = new JMenu(USER);
		
		manageExam(manageMenu);
		doExam(manageMenu);
		document(manageMenu);
		
		infor(inforMenu);
		access(inforMenu);
		
		menuBar.add(manageMenu);
		menuBar.add(inforMenu);
		return menuBar;
	}
	
	private void manageExam(JMenu manageMenu) {
		if (!currentMenu.equals(MANAGE_EXAM)) {
			JMenuItem itemManageExam = new JMenuItem("Quản lý bài thi");
			itemManageExam.addActionListener(new BtnManageListener(frame));
			manageMenu.add(itemManageExam);
		}
	}
	
	private void doExam(JMenu manageMenu) {
		if (!currentMenu.equals(DO_EXAM)) {
			JMenuItem itemDoExam = new JMenuItem("Làm bài thi");
			itemDoExam.addActionListener(new BtnTestExamListener(frame));
			manageMenu.add(itemDoExam);
		}
	}
	
	private void document(JMenu manageMenu) {
		if (!currentMenu.equals(DOCUMENT)) {
			JMenuItem itemDocument = new JMenuItem("Tài liệu");
			itemDocument.addActionListener(new BtnDocumentListener(frame));
			manageMenu.add(itemDocument);
		}
	}
	
	private void infor(JMenu inforMenu) {
		if (!currentMenu.equals(INFOR)) {
			JMenuItem itemInfor = new JMenuItem("Thông tin");
			inforMenu.add(itemInfor);
		}
	}
	
	private void access(JMenu inforMenu) {
		JMenuItem itemAccess;
		if (isAdmin) {
			itemAccess = new JMenuItem(LOGIN);
			itemAccess.addActionListener(new BtnLoginListener(frame));
		} else {
			itemAccess = new JMenuItem(LOGOUT);
		}
		inforMenu.add(itemAccess);
	}
}
