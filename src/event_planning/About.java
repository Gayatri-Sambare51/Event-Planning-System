package event_planning;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class About {
	JFrame f;
	JLabel l,l1;
	JTextArea t;
	About()
	{
		f=new JFrame();
		l=new JLabel("About");
		l.setFont(new Font("Verdana", Font.BOLD, 35));
		l.setForeground(Color.red);
		l.setBounds(600,50,200,200);
		t=new JTextArea("Event Management System is develop in Java programming\n language. It facilitates online registration  cum \nfeedback evaluation for different  kinds  of  events \nsuch as games,  workshops, and  seminars. The project�s \n main is to control or manage the activities and \n duties to be performed  by various event conductors \nsuch as attendees, organizer, and event reviewers.");
		t.setEditable(false);
		t.setFont(new Font("Verdana", Font.PLAIN, 20));
		t.setForeground(Color.BLACK);
		t.setBounds(450,200,610,200);
		t.setBackground(new Color(0,0,0,80));
		f.add(t);
		f.add(l);
		
	    f.setBackground(new Color(225, 120, 90));
		f.setLayout(null);
		f.setBounds(200,100,300,300);
		f.setVisible(true);
		f.setBounds(0,0,1500,800);
	}
	public static void main(String a[])
	{
		new About();
	}

}
