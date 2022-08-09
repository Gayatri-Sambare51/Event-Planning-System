package com.uttamsoft.jdbc;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;

import com.mysql.jdbc.Statement;
public class DeleteEvent implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b3;
	JTextField t1;
	DeleteEvent()
	{
		f=new JFrame();
		ImageIcon icon = new ImageIcon();
		JLabel l=new JLabel(icon);
		l.setIcon(new ImageIcon(new ImageIcon("C:\\\\Users\\\\pragati\\\\eclipse-workspace\\\\EMS\\\\src\\\\com\\\\uttamsoft\\\\jdbc\\\\image6.jpg").getImage().getScaledInstance(1400,900, Image.SCALE_DEFAULT)));
	  	f.add(l);
	  	Border emptyBorder = BorderFactory.createEmptyBorder();
	  	l1=new JLabel("Enter Event Name you want to delete ");
		l1.setFont(Font.decode("Arial-BOLD-24"));
		l1.setForeground(Color.BLACK);
        l1.setBorder(emptyBorder);
		l.add(l1);
		t1=new JTextField(20);
		t1.setFont(Font.decode("Arial-BOLD-24"));
		t1.setForeground(Color.BLACK);
		t1.setBounds(120,150,280,50);
		l.add(t1);
	  	b2=new JButton("Submit");
	  	b2.setFont(Font.decode("Arial-BOLD-24"));
		b2.setForeground(Color.BLACK);
        b2.setBorder(emptyBorder);
        b2.setFocusPainted(false);
        b2.setOpaque(false);
        b2.setContentAreaFilled(true);
        b2.setBorderPainted(true);
		l.add(b2);
	  	
	  	l1.setBounds(80,50,450,60);
	  	b2.setBounds(170,250,150,50);
	  
	  
	  	b2.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
				try {
					String user=t1.getText();
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Eventt", "root", "");
		            String sql="delete from AddEvent where Event_name='Cultural Event'";
		            java.sql.Statement stmt=con.createStatement();
		            int r=stmt.executeUpdate(sql);
		            System.out.println(r);
		        } 
				catch (Exception ex) {
		            System.out.println(ex);
		        }
				
			}
	  	});
	  	f.setSize(600,600);
	  	f.setBounds(380,130,600,500);
	  	f.setTitle("Delete Event");
	  	f.setVisible(true);
	}
	public static void main(String a[])
	{
		DeleteEvent n=new DeleteEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
}