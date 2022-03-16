package com.ldl575.c9.exam.page.user;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.mindrot.jbcrypt.BCrypt;

import com.ldl575.c9.exam.common.ShowMessage;
import com.ldl575.c9.exam.entity.UserEntity;
import com.ldl575.c9.exam.page.Login;
import com.ldl575.c9.exam.service.UserService;

public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String TITLE = "Đăng ký";
	
	private JFrame self;
	private JPanel controlPanel;
	
	private UserService userService;
	
	public Register() {
	}
	
	// DI
	public Register(UserService userService) {
		this.userService = userService;
	}
	
	private JTextField txtUserName;
	private JTextField txtFullName;
	private JTextField txtPassword;
	private JTextField txtRePassword;

	public void start() {
		self = this;
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
		txtUserName = new JTextField(20);
		txtUserName.setName("userName");
		panel.add(txtUserName, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblFullName = new JLabel();
		lblFullName.setText("Tên đầy đủ");
		panel.add(lblFullName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		txtFullName = new JTextField(20);
		txtFullName.setName("fullName");
		panel.add(txtFullName, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblPassword = new JLabel();
		lblPassword.setText("Mật khẩu");
		panel.add(lblPassword, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		txtPassword = new JTextField(20);
		txtUserName.setName("password");
		panel.add(txtPassword, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 3;
		JLabel lblRePassword = new JLabel();
		lblRePassword.setText("Nhập lại mật khẩu");
		panel.add(lblRePassword, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		txtRePassword = new JTextField(20);
		txtRePassword.setName("re-password");
		panel.add(txtRePassword, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		JButton btnRegister = new JButton("Đăng ký");
		panel.add(btnRegister, gbc);
		
		btnRegisterListener(btnRegister);
		
		panel.setPreferredSize(getSize());
		controlPanel.add(panel);
	}
	
	private void btnRegisterListener(JButton btnRegister) {
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = txtUserName.getText();
				String fullName = txtFullName.getText();
				String password = txtPassword.getText();
				String rePassword = txtRePassword.getText();
				if (!password.equals(rePassword)) {
					ShowMessage.error(self, "Mật khẩu không trùng khớp");
				}
				String hassPassword = BCrypt.hashpw(password, BCrypt.gensalt());
				
				UserEntity userEntity = UserEntity.builder()
						.userName(userName)
						.fullName(fullName)
						.password(hassPassword)
						.build();
				
				userService.save(userEntity);
				
				ShowMessage.info(self, "Đăng ký thành công!");
				redirectToLogin();
			}
		});
	}
	
	private void settingFrame() {
		this.add(controlPanel);
		this.setPreferredSize(getSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle(TITLE);
	}
	
	private void redirectToLogin() {
		self.dispose();
		new Login().start();
	}
}
