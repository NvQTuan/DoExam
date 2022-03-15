package com.ldl575.c9.exam.page;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ldl575.c9.exam.Menu;

public class Document extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "Tài liệu";
	private JPanel controlPanel;

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
		this.setJMenuBar(new Menu(this, TITLE).getMenu());
		this.setTitle(TITLE);
	} 
}
