package com.client.main.ui;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.SelectableChannel;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AdminLogin {

	JFrame loginframe;
	JLabel user_label;
	JLabel password_label;
	JTextField user_text;
	JPasswordField password_text;
	JPanel login_panel;
	JButton loginBtn, forgetBtn, signupBtn;

	public AdminLogin() {

		loginframe = new JFrame("ADMIN LOGIN PAGE");
		login_panel = new JPanel();

		user_label = new JLabel("Enter the Username");
		password_label = new JLabel("Enter the password");
		user_text = new JTextField(15);
		password_text = new JPasswordField(15);
		loginBtn = new JButton("Login");
		signupBtn = new JButton("Sign Up");
		forgetBtn = new JButton("Forgot Password");
		// gbc = new GridBagConstraints();
		init();

	}

	void init() {

		loginframe.setAlwaysOnTop(true);
		loginframe.setSize(350, 270);
		/*
		 * Dimension windowSize = loginframe.getSize(); GraphicsEnvironment ge =
		 * GraphicsEnvironment.getLocalGraphicsEnvironment(); Point centerPoint
		 * = ge.getCenterPoint();
		 * 
		 * int dx = centerPoint.x - windowSize.width / 2; int dy = centerPoint.y
		 * - windowSize.height / 2; loginframe.setLocation(dx, dy);
		 */

		loginframe.setLocationRelativeTo(null);

		// loginframe.setBackground(Color.BLUE);
		loginframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loginframe.setVisible(true);
		loginframe.setResizable(false);
		loginframe.setLayout(new GridBagLayout());
		loginframe.add(login_panel);
		design();
		addAllActionListeners();
	}

	void design() {
		login_panel.setPreferredSize(new Dimension(350, 270));
		/*
		 * panel1.setPreferredSize(new Dimension(60, 10));
		 * panel1.setBackground(Color.RED);
		 */
		// login_panel.setBackground(Color.YELLOW);
		login_panel.setLayout(new GridBagLayout());
		user_text.setToolTipText("Email id");
		password_text.setToolTipText("Password");

		login_panel.add(user_text, new GridBagConstraints(0, 0, 0, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 300, 12));
		login_panel.add(password_text, new GridBagConstraints(0, 2, 0, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 300, 12));
		login_panel.add(loginBtn, new GridBagConstraints(2, 5, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 50, 5));
		login_panel.add(forgetBtn, new GridBagConstraints(0, 7, 0, 0, 0, 0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 5, 5));
		login_panel.add(signupBtn, new GridBagConstraints(2, 7, 0, 0, 0, 0, GridBagConstraints.SOUTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 30, 5));

		signupBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		forgetBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		loginBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		placeholderLogin();
	}

	private void placeholderLogin() {
		user_text.setLayout(new FlowLayout());
		password_text.setLayout(new FlowLayout());
		user_text.add(user_label);
		password_text.add(password_label);

		user_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					user_label.setVisible(false);
				} else {
					if (user_text.getText().equals(""))
						user_label.setVisible(true);
				}
			}

		});

		password_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					password_label.setVisible(false);
				} else {
					if (password_text.getText().equals(""))
						password_label.setVisible(true);
				}
			}

		});
	}

	void addAllActionListeners() {
		signupBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				loginframe.setVisible(false);
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						new SignUp();

					}
				});
			}
		});
		forgetBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(loginframe, "Mail has been sent on your gmail account ",
						"Forget Password", JOptionPane.INFORMATION_MESSAGE);
				loginframe.setVisible(false);
			}

		});

		loginBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String value1 = user_text.getText();
				String value2 = password_text.getText();
				if (value1.equals("v") && value2.equals("v")) {
					loginframe.setVisible(false);
					new LoginPage();
				} else {
					JOptionPane.showMessageDialog(loginframe, "Enter valid username and password", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}
}
