package event_planning;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Contact_Us {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton b1,b2,b3;
	Date d;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	Contact_Us()
	{
	JFrame f=new JFrame();
	
	JLabel l = new JLabel();
	l.setIcon(new ImageIcon(new ImageIcon(".\\src\\img\\image8.jpg").getImage().getScaledInstance(1400,900, Image.SCALE_DEFAULT)));
	f.add(l);
	JPanel p=new JPanel();
	p.setBackground(new Color(0,0,0,80));
	p.setBounds(500, 100, 570, 570);
	
	l1 = new JLabel();
	l1.setBounds(0,0,900,700);
	l1.setLayout(null);

	l2 = new JLabel("Contact Us ");
	l2.setBounds(650,30,500,50);
	l2.setForeground(Color.BLACK);
	l2.setFont(new Font("serif",Font.BOLD,35));
	l2.setBackground(Color.yellow);
	l.add(l2);
	
	l3 = new JLabel(" Name ");
	l3.setBounds(550,150,200,40);
	l3.setFont(new Font("serif",Font.BOLD,25));
	l.add(l3);
	
	t1 = new JTextField();
	t1.setBounds(770,150,250,37);
	t1.setFont(new Font("serif",Font.BOLD,20));
	l.add(t1);
	
	
	l4 = new JLabel("Mobile No. ");
	l4.setBounds(550,220,200,30);
	l4.setFont(new Font("serif",Font.BOLD,25));
	l.add(l4);
	t2 = new JTextField();
	t2.setBounds(770,220,250,37);
	t2.setFont(new Font("serif",Font.BOLD,20));
	l.add(t2);
	
	l5 = new JLabel("Date ");
	l5.setBounds(550,290,200,40);
	l5.setFont(new Font("serif",Font.BOLD,25));
	l.add(l5);
	
	d=new Date();
	SimpleDateFormat ft=new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss ");
	String date=ft.format(d);
	t3 = new JTextField();
	t3.setText(date);
	t3.setBounds(770,290,250,37);
	t3.setFont(new Font("serif",Font.BOLD,20));
	l.add(t3);
	
	l6 = new JLabel(" Address ");
	l6.setBounds(550,360,180,40);
	l6.setFont(new Font("serif",Font.BOLD,25));
	l.add(l6);
	
	t4 = new JTextField();
	t4.setBounds(770,360,270,80);
	t4.setFont(new Font("serif",Font.BOLD,20));
	l.add(t4);
	
	t5=new JTextField("Message");
	t5.setBounds(550,470,490,110);
	t5.setFont(new Font("serif",Font.BOLD,20));
	l.add(t5);
	
	b1=new JButton("Submit");
	b1.setBounds(650,600,110,50);
	b1.setBackground(Color.lightGray);
	b1.setFont(new Font("serif",Font.BOLD,20));
	b1.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			 JOptionPane.showMessageDialog(new Frame(),"Ok...."); 

			
		}
		
	});
	l.add(b1);
	
	b2=new JButton("Back");
	b2.setBounds(800,600,110,50);
	b2.setBackground(Color.lightGray);
	b2.setFont(new Font("serif",Font.BOLD,20));
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 new Home();
		}
		
	});
	l.add(b2);
	

	f.setSize(1500,800);
	l.add(p);
	f.add(l);
	p.setLayout(new FlowLayout());
	l.setBounds(200,200,200,200);
	f.setVisible(true);
	}
	
}
