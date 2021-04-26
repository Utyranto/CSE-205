package main;

import javax.swing.*;
import java.awt.*;

public class CustomerPanel extends JPanel{
	private JLabel label1, label2, username, password, verify, email, mail;
	private JTextField user, pass, verpass, eaddress, address;
	private JButton createAcc, back;
	
	public CustomerPanel() {
		label1 = new JLabel("Student Store");
		label2 = new JLabel ("Create a Customer Account");
		username = new JLabel("Username");
		password = new JLabel("Password");
		verify = new JLabel("Verify Password");
		email = new JLabel("Email Address");
		mail = new JLabel("Mailing Address");
		user = new JTextField();
		pass = new JTextField();
		verpass = new JTextField();
		eaddress = new JTextField();
		address = new JTextField();
		createAcc = new JButton("Create Account");
		back = new JButton("Back");
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(label1);
		this.add(label2);
		this.add(username);
		this.add(user);
		this.add(password);
		this.add(pass);
		this.add(verify);
		this.add(verpass);
		this.add(email);
		this.add(eaddress);
		this.add(mail);
		this.add(address);
		this.add(createAcc);
		this.add(back);
		
	}
}
