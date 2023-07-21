package event_planning;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Add_Event  
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;
	JFrame f = new JFrame("Frame 2");
	
	Add_Event()
	{
		JLabel l = new JLabel();
		l.setIcon(new ImageIcon(new ImageIcon(".\\src\\img\\download2.jpg").getImage().getScaledInstance(1400,900, Image.SCALE_DEFAULT)));
		f.add(l);
		
		l1 = new JLabel();
		l1.setBounds(0,0,900,700);
		l1.setLayout(null);

		l2 = new JLabel("Add Event ");
		l2.setBounds(500,30,500,50);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("serif",Font.BOLD,35));
		l2.setForeground(Color.blue);
		l2.setBackground(Color.yellow);
		l.add(l2);
		
		l3 = new JLabel("Event Name ");
		l3.setBounds(300,150,200,40);
		l3.setFont(new Font("serif",Font.BOLD,25));
		l.add(l3);
		
		t1 = new JTextField();
		t1.setBounds(650,150,250,37);
		t1.setFont(new Font("serif",Font.BOLD,20));
		l.add(t1);
		
		
		l4 = new JLabel("Event Date ");
		l4.setBounds(300,220,200,30);
		l4.setFont(new Font("serif",Font.BOLD,25));
		l.add(l4);
		t2 = new JTextField();
		t2.setBounds(650,220,250,37);
		t2.setFont(new Font("serif",Font.BOLD,20));
		l.add(t2);
		
		l5 = new JLabel("Event Time ");
		l5.setBounds(300,290,200,40);
		l5.setFont(new Font("serif",Font.BOLD,25));
		l.add(l5);
		
		t3 = new JTextField();
		t3.setBounds(650,290,250,37);
		t3.setFont(new Font("serif",Font.BOLD,20));
		l.add(t3);
		
		l6 = new JLabel("Event Address ");
		l6.setBounds(300,360,200,40);
		l6.setFont(new Font("serif",Font.BOLD,25));
		l.add(l6);
		
		t4 = new JTextField();
		t4.setBounds(650,360,300,80);
		t4.setFont(new Font("serif",Font.BOLD,20));
		l.add(t4);
		
		l7 = new JLabel("Event Organizer Name ");
		l7.setBounds(300,480,300,40);
		l7.setFont(new Font("serif",Font.BOLD,25));
		l.add(l7);
		
		t5=new JTextField();
		t5.setBounds(650,480,250,37);
		t5.setFont(new Font("serif",Font.BOLD,20));
		l.add(t5);
		
		l8=new JLabel("Contact No. ");
		l8.setBounds(300,550,200,40);
		l8.setFont(new Font("serif",Font.BOLD,25));
		l.add(l8);
		
		t6=new JTextField();
		t6.setBounds(650,550,250,37);
		t6.setFont(new Font("serif",Font.BOLD,20));
		l.add(t6);
		
		b1=new JButton("Add");
		b1.setBounds(390,620,200,40);
		b1.setFont(new Font("Verdana",Font.BOLD,27));
		b1.setForeground(Color.blue);
		b1.setBackground(Color.cyan);
		l.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String a=t1.getText();
				String b=t2.getText();
				String c=t3.getText();
				String d=t4.getText();
				String e=t5.getText();
				String f=t6.getText();
				if(ae.getSource()==b1)
				{
					if(t1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Event Name...");  
					}
					else if(t2.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Event Date ...");  
					}
					else if(t3.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Event Time...");  
					}
					else if(t4.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Event Address...");  
					}
					else if(t5.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Event Organizer name...");  
					}
					else if(t6.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Contact No...");  
					}
					else
					{
						try
						{
							//System.out.println("HEllo1");
							DatabaseConnection db=new DatabaseConnection();
							
							String g="insert into Add_Event values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')";
							db.stmt.executeUpdate(g);
							String ss="delete from add_event where eventdate < CURDATE()";
							db.stmt.execute(ss);
							
						}
						catch(SQLException h)
						{
							System.out.println("Insert error");
							h.printStackTrace();
						}
					 JOptionPane.showMessageDialog(new Frame(),"Event Added Successfully..."); 
					 new Home();
					}
				}

			}
			
		});
		b2=new JButton("Back");
		b2.setBounds(610,620,200,40);
		b2.setFont(new Font("Verdana",Font.BOLD,27));
		b2.setForeground(Color.blue);
		b2.setBackground(Color.cyan);
		l.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new Home();
				f.dispose();
			}
		});
	
		f.setSize(1500,900);
		f.setTitle("Add Event");
		f.setVisible(true);	
	}
	
	public static void main(String a[])
	{
		new Add_Event();
	}
}
