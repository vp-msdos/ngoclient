package com.client.main.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Search {
	JFrame searchframe;
	JLabel nameLabel, gmailLabel, phoneLabel;
	JTextField nameSearch, gmailSearch, phoneSearch;
	JButton searchBtn;

	public Search() {
		searchframe = new JFrame("Search");
		nameSearch = new JTextField(15);
		gmailSearch = new JTextField(15);
		phoneSearch = new JTextField(15);
		nameLabel = new JLabel("Search with Name");
		gmailLabel = new JLabel("Search with GmailId");
		phoneLabel = new JLabel("Search with Phone Number");
		searchBtn = new JButton("Search");
		init();

	}

	void init() {
		searchframe.setSize(380, 200);
		searchframe.setLocationRelativeTo(null);
		searchframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		placeholderSearch();
	}

	private void placeholderSearch() {
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
	}
}