package com.ldl575.c9.exam.page;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ldl575.c9.exam.listener.BtnDocumentListener;
import com.ldl575.c9.exam.listener.BtnManageListener;
import com.ldl575.c9.exam.listener.BtnTestExamListener;

public class DashBoard {

	private JFrame frame;
	private JPanel controlPanel;
	
	public DashBoard() {
	}
	
	public DashBoard(JFrame frame, JPanel controlPanel) {
		this.frame = frame;
		this.controlPanel = controlPanel;
	}
	
	public void show(JPanel controlPanel) {
		JPanel jPanel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		jPanel.setLayout(layout);
		
		JButton btnManage = new JButton("Quản lý thi");
		btnManage.setSize(200, 200);
		JButton btnTestExam = new JButton("Thi");
		btnTestExam.setSize(200, 200);
		JButton btnDocument = new JButton("Tài liệu");
		btnDocument.setSize(200, 200);
		jPanel.add(btnManage);
		jPanel.add(btnTestExam);
		jPanel.add(btnDocument);
		btnManage.addActionListener(new BtnManageListener(frame));
		btnTestExam.addActionListener(new BtnTestExamListener(frame));
		btnDocument.addActionListener(new BtnDocumentListener(frame));
		controlPanel.add(jPanel);
	}
}
