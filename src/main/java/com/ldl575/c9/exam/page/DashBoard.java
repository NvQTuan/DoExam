package com.ldl575.c9.exam.page;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ldl575.c9.exam.Menu;
import com.ldl575.c9.exam.dto.common.ComunicatedDto;
import com.ldl575.c9.exam.entity.UserEntity;
import com.ldl575.c9.exam.listener.BtnDocumentListener;
import com.ldl575.c9.exam.listener.BtnManageListener;
import com.ldl575.c9.exam.listener.BtnTestExamListener;

public class DashBoard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Ứng dụng thi";
	private JFrame self;
	private JPanel controlPanel;
	private UserEntity userEntity;
	
	public DashBoard() {
	}
	
	public DashBoard(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	public void start() {
		self = this;
		this.setSize(1000, 600);
		controlPanel = new JPanel();
		showScreen();
		settingFrame();
	}
	
	public void showScreen() {
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
		btnManage.addActionListener(new BtnManageListener(getComunicatedDto()));
		btnTestExam.addActionListener(new BtnTestExamListener(getComunicatedDto()));
		btnDocument.addActionListener(new BtnDocumentListener(getComunicatedDto()));
		controlPanel.add(jPanel);
	}
	
	private void settingFrame() {
		this.add(controlPanel);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setJMenuBar(new Menu(getComunicatedDto(), TITLE).getMenu());
		this.setTitle("");
	}
	
	private ComunicatedDto getComunicatedDto() {
		return ComunicatedDto.builder()
				.frame(self)
				.userEntity(userEntity)
				.build();
	}
}
