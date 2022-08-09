package com.uttamsoft.jdbc;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.Border;

import com.mysql.jdbc.Statement;

public class StudentNext extends LoginStudent implements ActionListener 
{
	JFrame f;
	JLabel ll,l1,l2,l3,l4,l5,l6,l7,ll2,ll3,ll4,ll5,ll6,ll7;
	JButton b1,b2,b3;
	StudentNext(String user)
	{
		f=new JFrame();
		ImageIcon icon = new ImageIcon();
		JLabel l=new JLabel(icon);
		l.setIcon(new ImageIcon(new ImageIcon("C:\\\\Users\\\\pragati\\\\eclipse-workspace\\\\EMS\\\\src\\\\com\\\\uttamsoft\\\\jdbc\\\\image6.jpg").getImage().getScaledInstance(1400,900, Image.SCALE_DEFAULT)));
	  	f.add(l);
	  	
	  	
	  	l1=new JLabel(" Event Register Student Information ");
	  	l1.setBounds(20,20,550,40);
	  	l1.setFont(Font.decode("Arial-BOLD-25"));
		l1.setForeground(Color.RED);
	  	l.add(l1);
	  	
	  	l2=new JLabel("Student Name");
	  	l2.setBounds(30,70,200,60);
	  	l2.setFont(Font.decode("Arial-BOLD-20"));
		l2.setForeground(Color.BLACK);
	  	l.add(l2);
	  	
	  	l3=new JLabel("Email");
	  	l3.setBounds(30,140,200,60);
	  	l3.setFont(Font.decode("Arial-BOLD-20"));
		l3.setForeground(Color.BLACK);
	  	l.add(l3);
	  	
	  	l4=new JLabel("Username");
	  	l4.setBounds(30,210,550,40);
	  	l4.setFont(Font.decode("Arial-BOLD-20"));
		l4.setForeground(Color.BLACK);
	  	l.add(l4);
	  	
	  	l5=new JLabel("College");
		l5.setBounds(30,280,550,40);
	  	l5.setFont(Font.decode("Arial-BOLD-20"));
		l5.setForeground(Color.BLACK);
	  	l.add(l5);
	  	
	  	l6=new JLabel("Event Register");
		l6.setBounds(30,350,550,40);
	  	l6.setFont(Font.decode("Arial-BOLD-20"));
		l6.setForeground(Color.BLACK);
	  	l.add(l6);
	  	
	  	ll2=new JLabel("Student Name");
	  	ll2.setBounds(270,70,200,60);
	  	ll2.setFont(Font.decode("Arial-BOLD-20"));
		ll2.setForeground(Color.BLACK);
	  	l.add(ll2);
	  	
	  	ll3=new JLabel("Email");
	  	ll3.setBounds(270,140,200,60);
	  	ll3.setFont(Font.decode("Arial-BOLD-20"));
		ll3.setForeground(Color.BLACK);
	  	l.add(ll3);
	  	
	  	ll4=new JLabel("Username");
	  	ll4.setBounds(270,210,550,40);
	  	ll4.setFont(Font.decode("Arial-BOLD-20"));
		ll4.setForeground(Color.BLACK);
	  	l.add(ll4);
	  	
	  	ll5=new JLabel("College");
		ll5.setBounds(270,280,550,40);
	  	ll5.setFont(Font.decode("Arial-BOLD-20"));
		ll5.setForeground(Color.BLACK);
	  	l.add(ll5);
	  	
	  	ll6=new JLabel("Event Register");
		ll6.setBounds(270,350,550,40);
	  	ll6.setFont(Font.decode("Arial-BOLD-20"));
		ll6.setForeground(Color.BLACK);
	  	l.add(ll6);
	  	
	  	b1=new JButton("Back");
	  	b1.setBounds(480,10,100,30);
	  	b1.setFont(Font.decode("Arial-BOLD-20"));
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.pink);
	  	l.add(b1);
	  	b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Frame1();
			}
	  	});
	  	f.setSize(600,600);
	  	f.setBounds(10,10,600,500);
	  	f.setTitle("Display Student Register Events");
	  	f.setVisible(true);
	  	try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Eventt", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from regStudent where username = (?)");
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            	int i = 1;
                while (rs.next()) 
                {
                    String name = rs.getString(1);
                    String email = rs.getString(2);
                    String username = rs.getString(3);
                    String college = rs.getString(5);
                    String event = rs.getString(6);
                    ll2.setText(name);
                    ll3.setText(email);
                    ll4.setText(username);
                    ll5.setText(college);
                    ll6.setText(event);
                    JOptionPane.showMessageDialog(new Frame(),"Click For Next Event");
                      
                    } 
        } 
	  	catch (Exception ex) 
	  	{
            System.out.println(ex);
        }
		}
	public static void main(String a[])
	{
		StudentNext n=new StudentNext("Events");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		}
	}

