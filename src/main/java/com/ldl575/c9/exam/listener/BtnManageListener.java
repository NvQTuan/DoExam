package com.ldl575.c9.exam.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.ldl575.c9.exam.page.ManageExam;

public class BtnManageListener implements ActionListener {

	private JFrame frame;
	public BtnManageListener() {
	}
	
	public BtnManageListener(JFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		new ManageExam().start();
	}
}
