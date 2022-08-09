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

public class Frame1Next implements ActionListener 
{
	JFrame f;
	JLabel ll,l1,l2,l3,l4,l5,l6,l7,ll2,ll3,ll4,ll5,ll6,ll7;
	JButton b1,b2,b3;
	Frame1Next()
	{
		f=new JFrame();
		ImageIcon icon = new ImageIcon();
		JLabel l=new JLabel(icon);
		l.setIcon(new ImageIcon(new ImageIcon("C:\\\\Users\\\\pragati\\\\eclipse-workspace\\\\EMS\\\\src\\\\com\\\\uttamsoft\\\\jdbc\\\\image6.jpg").getImage().getScaledInstance(1400,900, Image.SCALE_DEFAULT)));
	  	f.add(l);
	  	
	  	l1=new JLabel(" Event Information ");
	  	l1.setBounds(20,20,350,40);
	  	l1.setFont(Font.decode("Arial-BOLD-30"));
		l1.setForeground(Color.RED);
	  	l.add(l1);
	  	
	  	l2=new JLabel("Event Name");
	  	l2.setBounds(30,70,200,60);
	  	l2.setFont(Font.decode("Arial-BOLD-20"));
		l2.setForeground(Color.BLACK);
	  	l.add(l2);
	  	
	  	l3=new JLabel("Event date");
	  	l3.setBounds(30,140,200,60);
	  	l3.setFont(Font.decode("Arial-BOLD-20"));
		l3.setForeground(Color.BLACK);
	  	l.add(l3);
	  	
	  	l4=new JLabel("Event Time");
	  	l4.setBounds(30,210,550,40);
	  	l4.setFont(Font.decode("Arial-BOLD-20"));
		l4.setForeground(Color.BLACK);
	  	l.add(l4);
	  	
	  	l5=new JLabel("Event Address");
		l5.setBounds(30,280,550,40);
	  	l5.setFont(Font.decode("Arial-BOLD-20"));
		l5.setForeground(Color.BLACK);
	  	l.add(l5);
	  	
	  	l6=new JLabel("Event Organizer Name");
		l6.setBounds(30,350,550,40);
	  	l6.setFont(Font.decode("Arial-BOLD-20"));
		l6.setForeground(Color.BLACK);
	  	l.add(l6);
	  	
	  	l7=new JLabel("Contact No.");
	  	l7.setBounds(30,410,550,40);
	  	l7.setFont(Font.decode("Arial-BOLD-20"));
		l7.setForeground(Color.BLACK);
	  	l.add(l7);
	  	
	  	ll2=new JLabel("Event Name");
	  	ll2.setBounds(270,70,200,60);
	  	ll2.setFont(Font.decode("Arial-BOLD-20"));
		ll2.setForeground(Color.BLACK);
	  	l.add(ll2);
	  	
	  	ll3=new JLabel("Event date");
	  	ll3.setBounds(270,140,200,60);
	  	ll3.setFont(Font.decode("Arial-BOLD-20"));
		ll3.setForeground(Color.BLACK);
	  	l.add(ll3);
	  	
	  	ll4=new JLabel("Event Time");
	  	ll4.setBounds(270,210,550,40);
	  	ll4.setFont(Font.decode("Arial-BOLD-20"));
		ll4.setForeground(Color.BLACK);
	  	l.add(ll4);
	  	
	  	ll5=new JLabel("Event Address");
		ll5.setBounds(270,280,550,40);
	  	ll5.setFont(Font.decode("Arial-BOLD-20"));
		ll5.setForeground(Color.BLACK);
	  	l.add(ll5);
	  	
	  	ll6=new JLabel("Event Organizer Name");
		ll6.setBounds(270,350,550,40);
	  	ll6.setFont(Font.decode("Arial-BOLD-20"));
		ll6.setForeground(Color.BLACK);
	  	l.add(ll6);
	  	
	  	ll7=new JLabel("Contact No.");
	  	ll7.setBounds(270,410,550,40);
	  	ll7.setFont(Font.decode("Arial-BOLD-20"));
		ll7.setForeground(Color.BLACK);
	  	l.add(ll7);
	  	b1=new JButton("Back");
	  	b1.setBounds(480,10,100,30);
	  	b1.setFont(Font.decode("Arial-BOLD-20"));
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.pink);
	  	l.add(b1);
	  	b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Frame1();
			}
	  	});
	  	f.setSize(600,600);
	  	f.setBounds(10,10,600,500);
	  	f.setVisible(true);
	  	try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Eventt", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from AddEvent ");
           
            System.out.println("aaartrt");
            ResultSet rs = ps.executeQuery();
                while (rs.next()) 
                {
                    String eventname = rs.getString(1);
                    String eventdate = rs.getString(2);
                    String eventtime = rs.getString(3);
                    String eventaddress = rs.getString(4);
                    String Organizername = rs.getString(5);
                    String contactno = rs.getString(6);
                    ll2.setText(eventname);
                    ll3.setText(eventdate);
                    ll4.setText(eventtime);
                    ll5.setText(eventaddress);
                    ll6.setText(Organizername);
                    ll7.setText(contactno);
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
		Frame1Next n=new Frame1Next();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		}
	}

