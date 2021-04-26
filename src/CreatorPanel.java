package main;

import javax.swing.*;
import java.awt.*;

public class CreatorPanel extends JPanel{
	private JLabel label1, label2, username, password;
	private JTextField user, pass;
	private JButton login, createUser, createEmploy;



	public CreatorPanel(){
	  label1 = new JLabel("Student Store");
	  label2 = new JLabel("Login to Account");
	  username = new JLabel("Username");
	  password = new JLabel("Password");
	  user = new JTextField();
	  pass = new JTextField();
	  login = new JButton("Login");
	  createUser = new JButton("Create Customer Account");
	  createEmploy = new JButton("Create Employee Account");
	  this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	  this.add(label1);
	  this.add(label2);
	  this.add(username);
	  this.add(user);
	  this.add(password);
	  this.add(pass);
	  this.add(login);
	  this.add(createUser);
	  this.add(createEmploy);
	}
	
}
