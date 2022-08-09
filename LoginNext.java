package com.uttamsoft.jdbc;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class LoginNext implements ActionListener 
{
	
	JFrame f;
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b3;
	LoginNext()
	{
		
		f=new JFrame();
		ImageIcon icon = new ImageIcon();
		JLabel l=new JLabel(icon);
		l.setIcon(new ImageIcon(new ImageIcon
				("C:\\\\Users\\\\pragati\\\\eclipse-workspace\\\\EMS\\\\src\\\\com\\\\uttamsoft\\\\jdbc\\\\image6.jpg")
				.getImage().getScaledInstance(1400,900, Image.SCALE_DEFAULT)));
	  	f.add(l);
	  	
	  	Border emptyBorder = BorderFactory.createEmptyBorder();
	  	b1=new JButton("Add Event ");
		b1.setFont(Font.decode("Arial-BOLD-24"));
		b1.setForeground(Color.BLACK);
        b1.setBorder(emptyBorder);
        b1.setFocusPainted(false);
        b1.setOpaque(false);
        b1.setContentAreaFilled(true);
        b1.setBorderPainted(false);
		l.add(b1);
		
	  	b2=new JButton("Delete Event");
	  	b2.setFont(Font.decode("Arial-BOLD-24"));
		b2.setForeground(Color.BLACK);
        b2.setBorder(emptyBorder);
        b2.setFocusPainted(false);
        b2.setOpaque(false);
        b2.setContentAreaFilled(true);
        b2.setBorderPainted(false);
		l.add(b2);
	  
	  	b1.setBounds(170,100,200,60);
	  	b2.setBounds(170,250,200,60);
	  	
	  	b1.addActionListener(this);
	  	b2.addActionListener(this);
	  
	  	l.add(b1);
	  	l.add(b2);
	  	
	  	f.setSize(600,600);
	  	f.setBounds(380,130,600,500);
	  	f.setVisible(true);
	}
	public static void main(String a[])
	{
		LoginNext n=new LoginNext();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			Add_Event event=new Add_Event();
		}
		else if(e.getSource()==b2)
		{
			DeleteEvent de=new DeleteEvent();
		}
	}
}