package com.ldl575.c9.exam.page.user;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ldl575.c9.exam.Menu;

public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String TITLE = "Đăng ký";
	
	private JPanel controlPanel;

	public void start() {
		this.setSize(1000, 600);
		controlPanel = new JPanel();
		showScreen();
		settingFrame();
	}
	
	private void showScreen() {
		JPanel panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		panel.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblUserName = new JLabel();
		lblUserName.setText("Tài khoản");
		panel.add(lblUserName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		JTextField txtUserName = new JTextField(20);
		txtUserName.setName("userName");
		panel.add(txtUserName, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblPassword = new JLabel();
		lblPassword.setText("Mật khẩu");
		panel.add(lblPassword, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		JTextField txtPassword = new JTextField(20);
		txtUserName.setName("password");
		panel.add(txtPassword, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblRePassword = new JLabel();
		lblRePassword.setText("Nhập lại mật khẩu");
		panel.add(lblRePassword, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		JTextField txtRePassword = new JTextField(20);
		txtRePassword.setName("re-password");
		panel.add(txtRePassword, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		JButton btnLogin = new JButton("Đăng ký");
		panel.add(btnLogin, gbc);
		
		panel.setPreferredSize(getSize());
		controlPanel.add(panel);
	}
	
	private void settingFrame() {
		this.add(controlPanel);
		this.setPreferredSize(getSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setJMenuBar(new Menu(this, TITLE).getMenu());
		this.setTitle(TITLE);
	}
	
}
