package com.ldl575.c9.exam.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.ldl575.c9.exam.dto.common.ComunicatedDto;
import com.ldl575.c9.exam.entity.UserEntity;
import com.ldl575.c9.exam.page.Document;


public class BtnDocumentListener implements ActionListener {

	private JFrame frame;
	private UserEntity userEntity;
	
	public BtnDocumentListener() {
	}
	
	public BtnDocumentListener(ComunicatedDto comunicatedDto) {
		this.frame = comunicatedDto.getFrame();
		this.userEntity = comunicatedDto.getUserEntity();
	}

	public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
		new Document(userEntity).start();		
	}
}
