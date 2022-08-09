package com.uttamsoft.jdbc;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class RegisterStudent extends JFrame implements ActionListener
{
	JLabel name,l1,l2;
	JFrame f;
	JTextField username,Password;
	JPanel heading;
	JButton signup,login_button;
    public JComboBox bx;

	DatabaseConnection db=new DatabaseConnection();
	RegisterStudent()
	{
		Font f = new Font("Serif",Font.BOLD,40);
		JPanel heading;
		setTitle("Register as Student");
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
		l1.setForeground(Color.WHITE);
		l1.setFont(Font.decode("Arial-BOLD-24"));
		l1.setBounds(20,110,300,50);
		login.add(l1);
		JTextField fullname = new JTextField();	
		fullname.setBounds(180,110,250,40);
		fullname.setForeground(Color.WHITE);
		fullname.setFont(Font.decode("Arial-BOLD-21"));
		fullname.setBackground(new Color(210,180,140));
		login.add(fullname);	
		
		JLabel l2=new JLabel("Email : ");
		l2.setForeground(Color.WHITE);
		l2.setFont(Font.decode("Arial-BOLD-24"));
		l2.setBounds(20,180,300,50);
		login.add(l2);
		JTextField email = new JTextField();	
		email.setBounds(180,180,250,40);
		email.setForeground(Color.WHITE);
		email.setFont(Font.decode("Arial-BOLD-21"));
		email.setBackground(new Color(210,180,140));
		login.add(email);	
	
		JLabel l3=new JLabel("Username : ");
		l3.setForeground(Color.WHITE);
		l3.setFont(Font.decode("Arial-BOLD-24"));
		l3.setBounds(20,250,300,50);
		login.add(l3);
		JTextField username = new JTextField();	
		username.setBounds(180,250,250,40);
		username.setForeground(Color.WHITE);
		username.setFont(Font.decode("Arial-BOLD-21"));
		username.setBackground(new Color(210,180,140));
		login.add(username);	
		
		JLabel l4=new JLabel("Password: ");
		l4.setForeground(Color.WHITE);
		l4.setFont(Font.decode("Arial-BOLD-24"));
		l4.setBounds(20,320,300,50);
		login.add(l4);
		JPasswordField Password = new JPasswordField();
		Password.setEchoChar('*');
		Password.setForeground(Color.WHITE);
		Password.setFont(Font.decode("Arial-BOLD-21"));
		Password.setBounds(180,320,250,40);
		Password.setBackground(new Color(210,180,140));
		login.add(Password);	
		
		JLabel l5=new JLabel("College : ");
		l5.setForeground(Color.WHITE);
		l5.setFont(Font.decode("Arial-BOLD-24"));
		l5.setBounds(20,390,300,50);
		login.add(l5);
		JTextField clg = new JTextField();	
		clg.setBounds(180,390,250,40);
		clg.setForeground(Color.WHITE);
		clg.setFont(Font.decode("Arial-BOLD-21"));
		clg.setBackground(new Color(210,180,140));
		login.add(clg);	
		
		JLabel l6=new JLabel("Events : ");
		l6.setForeground(Color.WHITE);
		l6.setFont(Font.decode("Arial-BOLD-24"));
		l6.setBounds(20,460,300,50);
		login.add(l6);
		
		JButton signup = new JButton("Sign Up");
		signup.setBounds(30,580,120,40);
		signup.setForeground(Color.WHITE);
		signup.setFont(Font.decode("Arial-BOLD-20"));
		signup.setBackground(new Color(160,182,45));
		login.add(signup);
		setSize(1700,900);
		try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Eventt", "root", "");
            PreparedStatement ps = con.prepareStatement("select event_name from Addevent");

            ResultSet rs = ps.executeQuery();
            Vector v = new Vector();
            while (rs.next()) {
                String s = rs.getString(1);
                v.add(s);
            }
            bx = new JComboBox(v);
            bx.setBounds(180, 470, 250, 35);
            bx.setFont(Font.decode("Arial-BOLD-21"));
            bx.setForeground(Color.WHITE);
    		bx.setBackground(new Color(210,180,140));
            login.add(bx);

        } catch (Exception ex) {
            System.out.println(ex);
        }
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String a=fullname.getText();
				String b=email.getText();
				String c=username.getText();
				String d=Password.getText();
				String e=clg.getText();
				String f=(String) bx.getSelectedItem();
				
				if(ae.getSource()==signup)
				{
					if(fullname.getText().equals(""))
					{
						JOptionPane.showMessageDialog(new Frame(),"Please Enter Full Name...");  
					}
					else if(email.getText().equals(""))
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
					
					else
					{
						try
						{
							DatabaseConnection db=new DatabaseConnection();
							
							String g="insert into RegStudent values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')";
							
							db.stmt.executeUpdate(g);
							
						}
						catch(SQLException h)
						{
							System.out.println("Insert error");
							h.printStackTrace();
						}
					 JOptionPane.showMessageDialog(new Frame(),"Event Registration Successful"); 
					
					}
				}
			}
		});
		
		JButton login_button = new JButton("login");
		login_button.setBounds(170,580,120,40);
		login_button.setForeground(Color.WHITE);
		login_button.setFont(Font.decode("Arial-BOLD-20"));
		login_button.setBackground(new Color(160,182,45));
		login.add(login_button);
		
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new LoginStudent();
			}
		});
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(310,580,120,40);
		cancel.setForeground(Color.WHITE);
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
		new RegisterStudent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
		
