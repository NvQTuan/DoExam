package com.ldl575.c9.exam.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.ldl575.c9.exam.page.Document;


public class BtnDocumentListener implements ActionListener {

	private JFrame frame;
	
	public BtnDocumentListener() {
	}
	
	public BtnDocumentListener(JFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
		new Document().start();		
	}
}
