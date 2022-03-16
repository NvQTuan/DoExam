package com.ldl575.c9.exam.common;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShowMessage {

	private static String TITLE_MESSAGE = "Thông báo";

	public static void error(JFrame frame, String message) {
		JOptionPane.showMessageDialog(frame, message, 
				TITLE_MESSAGE, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void info(JFrame frame, String message) {
		JOptionPane.showMessageDialog(frame, message, TITLE_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
	}
}
