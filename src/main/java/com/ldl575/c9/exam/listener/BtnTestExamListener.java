package com.ldl575.c9.exam.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.ldl575.c9.exam.page.DoTest;

public class BtnTestExamListener implements ActionListener {

	private JFrame frame;
	public BtnTestExamListener() {
	}
	
	public BtnTestExamListener(JFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		new DoTest().start();
	}
	
}
