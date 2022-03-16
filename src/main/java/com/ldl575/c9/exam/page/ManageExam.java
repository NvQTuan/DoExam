package com.ldl575.c9.exam.page;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ldl575.c9.exam.Menu;
import com.ldl575.c9.exam.dto.common.ComunicatedDto;
import com.ldl575.c9.exam.entity.UserEntity;

public class ManageExam extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "Quản lý bài thi";
	private JPanel controlPanel;
	private UserEntity userEntity;

	public ManageExam() {
		
	}
	public ManageExam(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	public void start() {
		this.setSize(1000, 600);
		this.setLayout(new GridLayout(1, 1));
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		settingFrame();
	}
	
	private void settingFrame() {
		this.add(controlPanel);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setJMenuBar(new Menu(getComunicatedDto(), TITLE).getMenu());
		this.setTitle(TITLE);
	}
	
	private ComunicatedDto getComunicatedDto() {
		return ComunicatedDto.builder()
			.frame(this)
			.userEntity(userEntity)
			.build();
	}
}
