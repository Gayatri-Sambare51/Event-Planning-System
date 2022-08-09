package com.uttamsoft.jdbc;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class RegisterAdminn extends JFrame implements ActionListener
{
	JLabel name,l1,l2;
	JFrame f;
	JTextField username,Password;
	JPanel heading;
	JButton signup,login_button;
	DatabaseConnection db=new DatabaseConnection();
	RegisterAdminn()
	{
		Font f = new Font("Serif",Font.BOLD,40);
		JPanel heading;
		heading = new JPanel();
		
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(500,35,450,70);
		JLabel name = new JLabel("Register");
		name.setForeground(Color.WHITE);
		name.setBounds(180,45,400,50);
		name.setFont(f);
		heading.add(name);

		//login panel
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setSize(500,450);
		login.setBackground(new Color(0,0,0,80));
		login.setBounds(500,37,450,650);
		JLabel l1=new JLabel("Full Name :  ");
		l1.setForeground(Color.BLACK);
		l1.setFont(Font.decode("Arial-BOLD-24"));
		l1.setBounds(20,110,300,50);
		login.add(l1);
		JTextField firstname = new JTextField();	
		firstname.setBounds(180,110,250,40);
		firstname.setFont(Font.decode("Arial-BOLD-21"));
		firstname.setBackground(new Color(210,180,140));
		login.add(firstname);	
		
		JLabel l2=new JLabel("Email : ");
		l2.setForeground(Color.BLACK);
		l2.setFont(Font.decode("Arial-BOLD-24"));
		l2.setBounds(20,180,300,50);
		login.add(l2);
		JTextField lastname = new JTextField();	
		lastname.setBounds(180,180,250,40);
		lastname.setFont(Font.decode("Arial-BOLD-21"));
		lastname.setBackground(new Color(210,180,140));
		login.add(lastname);	
		
		JLabel l3=new JLabel("Username : ");
		l3.setForeground(Color.BLACK);
		l3.setFont(Font.decode("Arial-BOLD-24"));
		l3.setBounds(20,250,300,50);
		login.add(l3);
		JTextField username = new JTextField();	
		username.setBounds(180,250,250,40);
		username.setFont(Font.decode("Arial-BOLD-21"));
		username.setBackground(new Color(210,180,140));
		login.add(username);	
		
		JLabel l4=new JLabel("Password: ");
		l4.setForeground(Color.BLACK);
		l4.setFont(Font.decode("Arial-BOLD-24"));
		l4.setBounds(20,320,300,50);
		login.add(l4);
		JPasswordField Password = new JPasswordField();
		Password.setEchoChar('*');
		Password.setFont(Font.decode("Arial-BOLD-21"));
		Password.setBounds(180,320,250,40);
		Password.setBackground(new Color(210,180,140));
		login.add(Password);	
		
		JLabel l5=new JLabel("College : ");
		l5.setForeground(Color.BLACK);
		l5.setFont(Font.decode("Arial-BOLD-24"));
		l5.setBounds(20,390,300,50);
		login.add(l5);
		JTextField clg = new JTextField();	
		clg.setBounds(180,390,250,40);
		clg.setFont(Font.decode("Arial-BOLD-21"));
		clg.setBackground(new Color(210,180,140));
		login.add(clg);	
		
		JLabel l6=new JLabel("Address : ");
		l6.setForeground(Color.BLACK);
		l6.setFont(Font.decode("Arial-BOLD-24"));
		l6.setBounds(20,460,300,50);
		login.add(l6);
		JTextField address = new JTextField();	
		address.setBounds(180,460,250,100);
		address.setFont(Font.decode("Arial-BOLD-21"));
		address.setBackground(new Color(210,180,140));
		login.add(address);	
		
		
		JButton signup = new JButton("Sign Up");
		signup.setBounds(30,580,120,40);
		signup.setFont(Font.decode("Arial-BOLD-20"));
		signup.setBackground(new Color(160,182,45));
		login.add(signup);
		setSize(1700,900);
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String a=firstname.getText();
				String b=lastname.getText();
				String c=username.getText();
				String d=Password.getText();
				String e=clg.getText();
				String f=address.getText();
				if(ae.getSource()==signup)
				{
					if(firstname.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Full Name...");  
					}
					else if(lastname.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Email ...");  
					}
					else if(username.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter UserName...");  
					}
					else if(Password.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Password...");  
					}
					else if(clg.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter College Name...");  
					}
					else if(address.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Address...");  
					}
					else
					{
						try
						{
							//System.out.println("HEllo1");
							DatabaseConnection db=new DatabaseConnection();
							
							String g="insert into RegisterAdmin values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')";
							//System.out.println("HEllo3");
							db.stmt.executeUpdate(g);
							
						}
						catch(SQLException h)
						{
							System.out.println("Insert error");
							h.printStackTrace();
						}
					 JOptionPane.showMessageDialog(new Frame(),"Registration Successful"); 
					 new LoginAdmin();
					}
				}
			}
		});
		
		JButton login_button = new JButton("login");
		login_button.setBounds(170,580,120,40);
		login_button.setFont(Font.decode("Arial-BOLD-20"));
		login_button.setBackground(new Color(160,182,45));
		login.add(login_button);
		
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new LoginAdmin();
			}
		});
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(310,580,120,40);
		cancel.setFont(Font.decode("Arial-BOLD-20"));
		cancel.setBackground(new Color(160,182,45));
		login.add(cancel);
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new Frame1();
			}
		});
		setSize(1500,900);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon background_image = new ImageIcon("C:\\\\\\\\Users\\\\\\\\pragati\\\\\\\\eclipse-workspace\\\\\\\\EMS\\\\\\\\src\\\\\\\\com\\\\\\\\uttamsoft\\\\\\\\jdbc\\\\\\\\download3.jpg");
		
		Image img  = background_image.getImage();
		Image temp_img = img.getScaledInstance(1600,900,Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("",background_image,JLabel.CENTER);

		background.add(login);
		background.add(heading);
		background.setBounds(0,0,1600,900);
		add(background);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new RegisterAdminn();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
		
