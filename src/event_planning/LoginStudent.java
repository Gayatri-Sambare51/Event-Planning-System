package event_planning;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;/*
class LoginStudent extends JFrame implements ActionListener
{
	JLabel name,l1,l2;
	JFrame f;
	JTextField username,Password;
	JPanel heading;
	JButton signup,login_button;
	LoginStudent()
	{
		Font f = new Font("Serif",Font.BOLD,40);
		setSize(1000,1000);
		pack();
		JPanel heading;
		heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		
		heading.setBounds(0,0,1600,100);
		JLabel name = new JLabel("Login");
		name.setForeground(Color.WHITE);
		name.setBounds(180,45,400,50);
		name.setFont(f);
		heading.add(name);

		JPanel login = new JPanel();
		login.setLayout(null);
		login.setSize(500,450);
		login.setBackground(new Color(0,0,0,60));
		login.setBounds(500,175,500,450);
		JLabel l1=new JLabel("Enter Username ");
		l1.setForeground(Color.BLACK);
		l1.setFont(Font.decode("Arial-BOLD-24"));
		l1.setBounds(80,45,300,50);
		login.add(l1);
		JTextField username = new JTextField();	
		username.setBounds(80,100,330,50);
		username.setFont(Font.decode("Arial-BOLD-21"));
		username.setBackground(new Color(210,180,140));
		login.add(username);	
		JLabel l2=new JLabel("Enter password... ");
		l2.setForeground(Color.BLACK);
		l2.setFont(Font.decode("Arial-BOLD-24"));
		l2.setBounds(80,170,300,50);
		login.add(l2);
		JPasswordField Password = new JPasswordField();	
		Password.setBounds(80,225,330,50);
		Password.setFont(Font.decode("Arial-BOLD-21"));
		Password.setBackground(new Color(210,180,140));
		login.add(Password);	
		
		JButton signup = new JButton("Sign Up");
		signup.setBounds(90,330,140,45);
		signup.setFont(Font.decode("Arial-BOLD-20"));
		signup.setBackground(new Color(160,182,45));
		login.add(signup);
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new RegisterAdminn();
			}
		});
		
		JButton login_button = new JButton("login");
		login_button.setBounds(270,330,140,50);
		login_button.setFont(Font.decode("Arial-BOLD-20"));
		login_button.setBackground(new Color(160,182,45));
		login.add(login_button);
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed1(ActionEvent ae) {
				String c=username.getText();
				String d=Password.getText();
				try
				{
					//System.out.println("HEllo1");
					DatabaseConnection db=new DatabaseConnection();
					
					String g="select username,password from RegisterStudent";
					//System.out.println("HEllo3");
					ResultSet rs=db.stmt.executeQuery(g);
					while(db.rs.next())
					{
						if(rs.getString("username")==c && rs.getString("password")==d)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Login Successful...");
						}
						else
						{
							JOptionPane.showMessageDialog(new JFrame(), "Invalid login Details");
						}
					}
					
					
				}
				catch(SQLException h)
				{
					System.out.println("Insert error");
					h.printStackTrace();
				}
				
		/*login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userText;
	            String pwdText;
	            userText = username.getText();
	            pwdText = Password.getText();
	            if (userText.equalsIgnoreCase("Gayatri_51") && pwdText.equalsIgnoreCase("12345")) {
	                JOptionPane.showMessageDialog(new JFrame(), "Login Successful");
	                new LoginNext();
	            } else {
	                JOptionPane.showMessageDialog(new JFrame(), "Invalid Username or Password");
	            }
			}
		});
		setSize(1400,900);
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
		new LoginStudent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new Demo();
		
	}
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}*/



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class LoginStudent extends JFrame implements ActionListener
{
	JLabel name,l1,l2;
	JFrame f;
	JTextField username,Password;
	JPanel heading;
	JButton signup,login_button;
	public int flag=0;
	LoginStudent()
	{
		Font f = new Font("Serif",Font.BOLD,40);
		setSize(1000,1000);
		setTitle("Login As Student");
		pack();
		JPanel heading;
		heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		
		heading.setBounds(0,0,1600,100);
		JLabel name = new JLabel("Login");
		name.setForeground(Color.WHITE);
		name.setBounds(180,45,400,50);
		name.setFont(f);
		heading.add(name);

		//login panel
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setSize(500,450);
		login.setBackground(new Color(0,0,0,60));
		login.setBounds(500,175,500,450);
		JLabel l1=new JLabel("Enter Username ");
		l1.setForeground(Color.BLACK);
		l1.setFont(Font.decode("Arial-BOLD-24"));
		l1.setBounds(80,45,300,50);
		login.add(l1);
		final JTextField username = new JTextField();	
		username.setBounds(80,100,330,50);
		username.setFont(Font.decode("Arial-BOLD-21"));
		username.setBackground(new Color(210,180,140));
		login.add(username);	
		JLabel l2=new JLabel("Enter password... ");
		l2.setForeground(Color.BLACK);
		l2.setFont(Font.decode("Arial-BOLD-24"));
		l2.setBounds(80,170,300,50);
		login.add(l2);
		final JPasswordField Password = new JPasswordField();	
		Password.setBounds(80,225,330,50);
		Password.setFont(Font.decode("Arial-BOLD-21"));
		Password.setBackground(new Color(210,180,140));
		login.add(Password);	
		
		JButton signup = new JButton("Sign Up");
		signup.setBounds(90,330,140,45);
		signup.setFont(Font.decode("Arial-BOLD-20"));
		signup.setBackground(new Color(160,182,45));
		login.add(signup);
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new RegisterStudent();
			}
		});
		
		JButton login_button = new JButton("login");
		login_button.setBounds(270,330,140,50);
		login_button.setFont(Font.decode("Arial-BOLD-20"));
		login_button.setBackground(new Color(160,182,45));
		login.add(login_button);
		login_button.addActionListener(this);
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		String a=username.getText();
		String b=Password.getText();
		
		try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Eventt", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from RegisterStudent");
            ResultSet rs = ps.executeQuery();
          
            	
            	String str = username.getText(); 
            	String str1 =Password.getText(); 
            	
                while (rs.next()) {
                	String compareTo = rs.getString("username"); 
                    String Password1 = rs.getString("password"); 
                    if(str.equals(compareTo ) && str1.equals(Password1)){ 
                      
                       JOptionPane.showMessageDialog(new Frame(),"Login Successful");
                       flag=1;
                       setVisible(false);
                       dispose();
                       StudentNext st=new StudentNext(username.getText());
                       
                       break; 
                    } 
            }
                if(flag==0){
                	JOptionPane.showMessageDialog(new Frame(),"Invalid Credentials");
                }
           
        } catch (Exception ex) {
            System.out.println(ex);
        }
		}
	});
		setSize(1400,900);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon background_image = new ImageIcon(".\\src\\img\\download3.jpg");
		
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
		new LoginStudent();
	}
	public void actionPerformed(ActionEvent e) {
	}
}
		

