package main;

import javax.swing.*;
import java.awt.*;

public class Panel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Final Project");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setPreferredSize(new Dimension(500, 500));
	    
	    JPanel panel = new CreatorPanel();
	    frame.add(panel,BorderLayout.CENTER);
	    frame.setLayout(new BoxLayout (frame.getContentPane(), BoxLayout.Y_AXIS));
	    
	    frame.pack();
	    frame.setVisible(true);
	}

}
