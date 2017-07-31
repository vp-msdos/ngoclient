package com.client.main.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp {
	
	private static final String EXIT_ON_CLOSE = null;
	//ImageIcon img = new ImageIcon("C:\Users\Ghous\Documents\9.png");
	JFrame signupframe;
	JLabel n_label, p_label, rep_label, ph_label,gmail_label ,add_label, city_label, coun_label;
	JTextField name_text, phone_text, gmail_text, address_text, city_text, country_text;
	JPasswordField password_text, retype_text;
	JButton  signinBtn;
	JComboBox  dd, mm, yy;

    JLabel doblbl;

    Container dob_text;


	public SignUp() {
		signupframe = new JFrame("SIGN UP PAGE");
		
		 //String[] shapes ={"(no shape selected)","Circle","Equilateral Triangle","Square"};  
		// comboBox=new JComboBox(shapes);

	     
		n_label = new JLabel("Enter username *");
		p_label = new JLabel("Enter password *");
		rep_label = new JLabel("Retype password *");
		ph_label = new JLabel("Enter your phone number *");
		gmail_label = new JLabel("Enter your gmail account *");
		add_label = new JLabel("Enter your address");
		city_label = new JLabel("Enter your city");
		coun_label = new JLabel("Enter your country");
		//dob_label = new JLabel("Enter your date of birth");

		name_text = new JTextField(15);
		phone_text = new JTextField(15);
		gmail_text = new JTextField(15);
		address_text = new JTextField(15);
		city_text = new JTextField(15);
		country_text = new JTextField(15);
		password_text = new JPasswordField(15);
		retype_text = new JPasswordField(15);
		dob_text = new JTextField(15);

		signinBtn = new JButton("Sign in");

		/*
		 * String[] description = { "Ebullient", "Obtuse", "Recalcitrant",
		 * "Brilliant", "Somnescent", "Timorous", "Florid", "Putrescent" };
		 * JComboBox c = new JComboBox();
		 * 
		 * int count =0;
		 * 
		 * for(int i = 0; i < description.length; i++)
		 * c.addItem(description[count++]); city_text.setEditable(false);
		 * 
		 * c.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { city_text.setText("You Selected : "
		 * + ((JComboBox)e.getSource()).getSelectedItem()); } });
		 */

		init();
	}

	void init() {
		signupframe.setSize(500, 500);
		signupframe.setLocationRelativeTo(null);
		signupframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		signupframe.setVisible(true);
		// signupframe.setResizable(false);
		
		/*Set forwardKeys = signupframe.getFocusTraversalKeys(
			    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
			Set newForwardKeys = new HashSet(forwardKeys);
			newForwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
			signupframe.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
			    newForwardKeys);*/


		
		  
		signupframe.setLayout(new GridBagLayout());
		name_text.setToolTipText("Username");
		password_text.setToolTipText("Password");
		retype_text.setToolTipText("Retype Password");
		phone_text.setToolTipText("Phone Number");
		password_text.setToolTipText("Password");
		gmail_text.setToolTipText("Gmail");
		//dob_text.setToolTipText("Date of Birth");
		country_text.setToolTipText("Country");
		city_text.setToolTipText("City");
		address_text.setToolTipText("Address");
		
		signupframe.add(name_text, new GridBagConstraints(0, 0, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 80, 10));
		signupframe.add(password_text, new GridBagConstraints(0, 2, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		signupframe.add(retype_text, new GridBagConstraints(0, 4, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		signupframe.add(phone_text, new GridBagConstraints(0, 6, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		signupframe.add(gmail_text, new GridBagConstraints(0, 8, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		signupframe.add(dob_text, new GridBagConstraints(0, 10, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 14));
		signupframe.add(country_text, new GridBagConstraints(0, 12, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		signupframe.add(city_text, new GridBagConstraints(0, 14, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		signupframe.add(address_text, new GridBagConstraints(0, 16, 2, 2, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 80, 10));
		signupframe.add(signinBtn, new GridBagConstraints(1, 18, 0, 0, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 30, 8));
		//signupframe.add(comboBox);
		
		signinBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
	  

	      /*  UtilDateModel model = new UtilDateModel();
	        Properties p = new Properties();
	        p.put("text.today", "Today");
	        p.put("text.month", "Month");
	        p.put("text.year", "Year");
	        //model.setDate(20,04,2014);
	        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new AbstractFormatter() {
				
	            private String datePattern = "yyyy-MM-dd";
	            private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	            @Override
	            public Object stringToValue(String text) throws ParseException {
	                return dateFormatter.parseObject(text);
	            }

	            @Override
	            public String valueToString(Object value) throws ParseException {
	                if (value != null) {
	                    Calendar cal = (Calendar) value;
	                    return dateFormatter.format(cal.getTime());
	                }

	                return "";
	            }

	        }  );      
	        
	        city_text.add(datePicker);*/
		
		Pro1();
		placeholderSignUp();
		addAllActionListeners();
	}
	
	  void Pro1()
	    {
	  
	        doblbl = new JLabel("Date of Birth : ");
	     
	        dd = new JComboBox();
	        mm = new JComboBox();
	        yy = new JComboBox();

	        for(int i = 1; i<=31; i++)
	            dd.addItem("" + i);

	        for(int i = 1; i<=12; i++)
	            mm.addItem("" + i);

	        for(int i = 1960; i<=2017; i++)
	            yy.addItem("" + i);


	        dob_text.setLayout(new FlowLayout());    

	      int i = 120;

	        doblbl.setBounds(30,i+=40,270,30);

	        int j = 120;

	        dd.setBounds(350,j+=40,50,30);
	        mm.setBounds(420,j,50,30);
	        yy.setBounds(480,j,70,30);

	        dob_text.add(doblbl);
	        dob_text.add(dd);
	        dob_text.add(mm);
	        dob_text.add(yy);



	       // dob_text.setBackground(new Color(125,80,140));           
	    }

	private void placeholderSignUp() {
		name_text.setLayout(new FlowLayout());
		password_text.setLayout(new FlowLayout());
		retype_text.setLayout(new FlowLayout());
		phone_text.setLayout(new FlowLayout());
		gmail_text.setLayout(new FlowLayout());
		//dob_text.setLayout(new FlowLayout());
		country_text.setLayout(new FlowLayout());
		city_text.setLayout(new FlowLayout());
		address_text.setLayout(new FlowLayout());

		name_text.add(n_label);
		password_text.add(p_label);
		retype_text.add(rep_label);
		phone_text.add(ph_label);
		gmail_text.add(gmail_label);
		//dob_text.add(dob_label);
		country_text.add(coun_label);
		city_text.add(city_label);
		address_text.add(add_label);

		name_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					n_label.setVisible(false);
				} else {
					if (name_text.getText().equals(""))
						n_label.setVisible(true);
				}
			}

		});

		password_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					p_label.setVisible(false);
				} else {
					if (password_text.getText().equals(""))
						p_label.setVisible(true);
				}
			}

		});

		retype_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					rep_label.setVisible(false);
				} else {
					if (retype_text.getText().equals(""))
						rep_label.setVisible(true);
				}
			}

		});

		phone_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					ph_label.setVisible(false);
				} else {
					if (phone_text.getText().equals(""))
						ph_label.setVisible(true);
				}
			}

		});

		gmail_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					gmail_label.setVisible(false);
				} else {
					if (gmail_text.getText().equals(""))
						gmail_label.setVisible(true);
				}
			}

		});
		
	/*	dob_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					dob_label.setVisible(false);
				} else {
					if (dob_text.getText().equals(""))
						dob_label.setVisible(true);
				}
			}

		});*/

		country_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					coun_label.setVisible(false);
				} else {
					if (country_text.getText().equals(""))
						coun_label.setVisible(true);
				}
			}

		});

		city_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					city_label.setVisible(false);
				} else {
					if (city_text.getText().equals(""))
						city_label.setVisible(true);
				}
			}

		});

		address_text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					add_label.setVisible(false);
				} else {
					if (add_label.getText().equals(""))
						p_label.setVisible(true);
				}
			}

		});
	}
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	void addAllActionListeners() {
		signinBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(signupframe, "Are you sure? ", "Please Confirm", JOptionPane.INFORMATION_MESSAGE);
				
				if(name_text.getText().isEmpty()){
					JOptionPane.showMessageDialog(signupframe, "Enter Username *", "Username Error", JOptionPane.ERROR_MESSAGE);
			       name_text.requestFocus();
			     }
				else if(password_text.getText().isEmpty()){
					JOptionPane.showMessageDialog(signupframe, "Enter Password *", "Password Error", JOptionPane.ERROR_MESSAGE);
				       password_text.requestFocus();
				     }
				else if(retype_text.getText().isEmpty()){
					JOptionPane.showMessageDialog(signupframe, "Retype Password *", "Password Error", JOptionPane.ERROR_MESSAGE);
				       retype_text.requestFocus();
				     }
				else if(!(password_text.getText().equals(retype_text.getText()))){
					JOptionPane.showMessageDialog(signupframe, "Password doesn't match *", "Password Error", JOptionPane.ERROR_MESSAGE);
				       retype_text.requestFocus();
				}
				
				else if (!(isNumeric(phone_text.getText())) || (phone_text.getText().length() != 10 )) {
				  System.out.println(isNumeric(phone_text.getText()));   
					JOptionPane.showMessageDialog(signupframe, "Invalid Mobile Number", "Mobile Error", JOptionPane.ERROR_MESSAGE);
				       phone_text.requestFocus();
				     }
				  
				else if(!(gmail_text.getText().contains("@") & gmail_text.getText().contains(".com"))){
					 JOptionPane.showMessageDialog(signupframe, "invalid Email Id", "Email Error", JOptionPane.ERROR_MESSAGE);
				       gmail_text.requestFocus();
				}
				else{
					new LoginPage();
				}
		}
	});
	
}
}
