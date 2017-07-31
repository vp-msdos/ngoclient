package com.client.main.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class LoginPage {

	JFrame loginPageframe;
	JMenuBar menuBar;
	JMenu fileMenu, editMenu, uploadMenu;
	JTabbedPane tabbedPane;

	public LoginPage() {

		loginPageframe = new JFrame("Login Page");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		loginPageframe.setBounds(0, 0, screenSize.width, screenSize.height);
		loginPageframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loginPageframe.setLayout(new GridLayout());
		loginPageframe.setVisible(true);
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		uploadMenu = new JMenu("Upload");
		design();
	}

	public static JComponent membershipPanel() {
		JPanel panel = new JPanel();

		final JLabel fNameLabel = new JLabel("Enter First Name ");
		final JLabel lNameLabel = new JLabel("Enter Last Name");
		final JLabel fatherLabel = new JLabel("Enter Father's Name");
		final JLabel religionLabel = new JLabel("Enter Religion");
		final JLabel addressLabel = new JLabel("Enter Residential Address");
		final JLabel levelLabel = new JLabel("Level of Activity ");
		final JLabel genderLabel = new JLabel("Gender ");
		final JLabel typeLabel = new JLabel("Membership Category ");
		final JLabel donationLabel = new JLabel("Donation Amount ");
		final JLabel paymentLabel = new JLabel("Choose Payment Type");

		final JTextField fNameText = new JTextField(15);
		final JTextField lNameText = new JTextField(15);
		final JTextField fatherText = new JTextField(15);
		final JTextField religionText = new JTextField(15);
		final JTextField addressText = new JTextField(15);
		final JTextField donationText = new JTextField(15);

		final JRadioButton maleRB = new JRadioButton("Male");
		// maleRB.setBounds(100, 50, 100, 30);
		final JRadioButton femaleRB = new JRadioButton("Female");
		// femaleRB.setBounds(100, 100, 100, 30);
		JRadioButton localRB = new JRadioButton("Local");
		// localRB.setBounds(100, 100, 100, 30);
		JRadioButton nationalRB = new JRadioButton("National");
		// nationalRB.setBounds(100, 100, 100, 30);
		JRadioButton interRB = new JRadioButton("International");
		// interRB.setBounds(100, 100, 100, 30);
		JRadioButton basicRB = new JRadioButton("Basic ");
		basicRB.setBounds(100, 100, 100, 30);
		JRadioButton premRB = new JRadioButton("Premium");
		// premRB.setBounds(100, 100, 100, 30);

		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(maleRB);
		bg1.add(femaleRB);
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(localRB);
		bg2.add(nationalRB);
		bg2.add(interRB);
		ButtonGroup bg3 = new ButtonGroup();
		bg3.add(basicRB);
		bg3.add(premRB);

		JButton submitBtm = new JButton("Submit");

		fNameText.setToolTipText("First Name");
		lNameText.setToolTipText("Last Name");
		fatherText.setToolTipText("Father's Name");
		religionText.setToolTipText("Religion");
		addressText.setToolTipText("Residential address");
		donationText.setToolTipText("Donation Amount");

		panel.setLayout(new GridBagLayout());
		panel.add(fNameText, new GridBagConstraints(0, 0, 2, 2, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 80, 10));
		panel.add(lNameText, new GridBagConstraints(0, 2, 2, 2, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 80, 10));
		panel.add(fatherText, new GridBagConstraints(0, 4, 2, 2, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 80, 10));
		panel.add(religionText, new GridBagConstraints(0, 6, 2, 2, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		panel.add(addressText, new GridBagConstraints(0, 8, 2, 2, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		panel.add(donationText, new GridBagConstraints(0, 10, 2, 2, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		panel.add(levelLabel, new GridBagConstraints(5, 0, 2, 2, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 150, 10));
		panel.add(localRB, new GridBagConstraints(6, 2, 2, 2, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 30, 6));
		panel.add(nationalRB, new GridBagConstraints(7, 2, 2, 2, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 30, 6));
		// panel.add(interRB, new GridBagConstraints(8, 2, 2, 0, 0, 0,
		// GridBagConstraints.WEST,
		// GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 30, 6));
		panel.add(genderLabel, new GridBagConstraints(4, 4, 2, 2, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 180, 10));
		panel.add(maleRB, new GridBagConstraints(6, 6, 2, 2, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 80, 10));
		panel.add(femaleRB, new GridBagConstraints(7, 6, 2, 2, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 80, 10));
		panel.add(typeLabel, new GridBagConstraints(5, 8, 2, 2, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 110, 10));
		panel.add(basicRB, new GridBagConstraints(6, 10, 2, 2, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 80, 10));
		panel.add(premRB, new GridBagConstraints(7, 10, 2, 2, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 80, 10));

		panel.add(paymentLabel, new GridBagConstraints(5, 12, 2, 2, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 120, 10));
		panel.add(submitBtm, new GridBagConstraints(1, 15, 0, 0, 0, 0, GridBagConstraints.SOUTH,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 30, 6));

		levelLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		genderLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		typeLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		paymentLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		submitBtm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		// placeholder

		fNameText.setLayout(new FlowLayout());
		lNameText.setLayout(new FlowLayout());
		fatherText.setLayout(new FlowLayout());
		addressText.setLayout(new FlowLayout());
		religionText.setLayout(new FlowLayout());
		donationText.setLayout(new FlowLayout());

		fNameText.add(fNameLabel);
		lNameText.add(lNameLabel);
		fatherText.add(fatherLabel);
		addressText.add(addressLabel);
		religionText.add(religionLabel);
		donationText.add(donationLabel);

		fNameText.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					fNameLabel.setVisible(false);
				} else {
					if (fNameText.getText().equals(""))
						fNameLabel.setVisible(true);
				}
			}

		});

		lNameText.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					lNameLabel.setVisible(false);
				} else {
					if (lNameText.getText().equals(""))
						lNameLabel.setVisible(true);
				}
			}

		});

		fatherText.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					fatherLabel.setVisible(false);
				} else {
					if (fatherText.getText().equals(""))
						fatherLabel.setVisible(true);
				}
			}

		});
		addressText.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					addressLabel.setVisible(false);
				} else {
					if (addressText.getText().equals(""))
						addressLabel.setVisible(true);
				}
			}

		});
		religionText.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					religionLabel.setVisible(false);
				} else {
					if (religionText.getText().equals(""))
						religionLabel.setVisible(true);
				}
			}

		});
		donationText.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					donationLabel.setVisible(false);
				} else {
					if (donationText.getText().equals(""))
						donationLabel.setVisible(true);
				}
			}

		});

		return panel;
	}

	public static JComponent paymentRenewal() {
		JPanel searchframe;
		final JLabel nameLabel, gmailLabel, phoneLabel;
		final JTextField nameSearch, gmailSearch, phoneSearch;
		JButton searchBtn;

		searchframe = new JPanel();
		nameSearch = new JTextField(15);
		gmailSearch = new JTextField(15);
		phoneSearch = new JTextField(15);
		nameLabel = new JLabel("Search with Name");
		gmailLabel = new JLabel("Search with Gmail Id");
		phoneLabel = new JLabel("Search with Phone Number");
		searchBtn = new JButton("Search");

		searchframe.setSize(380, 200);
		// searchframe.setLocationRelativeTo(null);
		// searchframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		searchframe.setVisible(true);

		searchframe.setLayout(new GridBagLayout());
		searchframe.add(nameSearch, new GridBagConstraints(0, 0, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 100, 10));
		searchframe.add(gmailSearch, new GridBagConstraints(0, 2, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 100, 10));
		searchframe.add(phoneSearch, new GridBagConstraints(0, 4, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 100, 10));
		searchframe.add(searchBtn, new GridBagConstraints(0, 6, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 60, 10));
		searchBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		nameSearch.setLayout(new FlowLayout());
		gmailSearch.setLayout(new FlowLayout());
		phoneSearch.setLayout(new FlowLayout());

		nameSearch.add(nameLabel);
		gmailSearch.add(gmailLabel);
		phoneSearch.add(phoneLabel);

		nameSearch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					nameLabel.setVisible(false);
				} else {
					if (nameSearch.getText().equals(""))
						nameLabel.setVisible(true);
				}
			}

		});
		gmailSearch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					gmailLabel.setVisible(false);
				} else {
					if (gmailSearch.getText().equals(""))
						gmailLabel.setVisible(true);
				}
			}

		});
		phoneSearch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					phoneLabel.setVisible(false);
				} else {
					if (phoneSearch.getText().equals(""))
						phoneLabel.setVisible(true);
				}
			}

		});

		actionListener(searchBtn, searchframe,phoneSearch,gmailSearch);

		return searchframe;
	}

	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	static void actionListener(final JButton btn, final JPanel searchframe, final JTextField phone, final JTextField gmail) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(!(gmail.getText().contains("@") & gmail.getText().contains(".com"))){
					 JOptionPane.showMessageDialog(searchframe, "invalid Email Id", "Email Error", JOptionPane.ERROR_MESSAGE);
				       gmail.requestFocus();
				}
			if (!(isNumeric(phone.getText())) || (phone.getText().length() != 10 )) {
					  System.out.println(isNumeric(phone.getText()));   
						JOptionPane.showMessageDialog(searchframe, "Invalid Mobile Number", "Mobile Error", JOptionPane.ERROR_MESSAGE);
					       phone.requestFocus();
					     }
					  
					
					else{
				JTable table = new JTable(3, 3);
				JScrollPane scrollpane = new JScrollPane(table);
				
				table.setLayout(new GridBagLayout());
				searchframe.add(scrollpane, new GridBagConstraints(0, 8, 0, 0, 0, 0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 60, 4));
					}

			}
		});
	}

	private void design() {
		// Build the File Menu
		fileMenu.setMnemonic(KeyEvent.VK_A);
		fileMenu.getAccessibleContext().setAccessibleDescription("File menu");
		menuBar.add(fileMenu);
		// Build the Edit Menu
		editMenu.setMnemonic(KeyEvent.VK_B);
		editMenu.getAccessibleContext().setAccessibleDescription("Edit menu");
		menuBar.add(editMenu);
		// Build the Upload Menu
		uploadMenu.setMnemonic(KeyEvent.VK_C);
		uploadMenu.getAccessibleContext().setAccessibleDescription("Upload menu");
		menuBar.add(uploadMenu);

		loginPageframe.setJMenuBar(menuBar);

		// TabbedPane
		tabbedPane = new JTabbedPane();
		// ImageIcon icon = createImageIcon("images/middle.gif");
		// Tab1
		JComponent panel1 = membershipPanel();
		tabbedPane.addTab("Membership", null, panel1, "Membership Details");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		// Tab2
		JComponent panel = paymentRenewal();
		tabbedPane.addTab("Payment", null, panel, "Payment");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		loginPageframe.add(tabbedPane);
		// tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

	}

}