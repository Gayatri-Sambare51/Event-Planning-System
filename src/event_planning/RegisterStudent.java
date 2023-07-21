package event_planning;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
class RegisterStudent extends JFrame implements ActionListener
{
	JLabel name,l1,l2;
	JFrame frame;
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
		final JTextField fullname = new JTextField();	
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
		final JTextField email = new JTextField();	
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
		final JTextField username = new JTextField();	
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
		final JPasswordField Password = new JPasswordField();
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
		final JTextField clg = new JTextField();	
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
		
		final JButton signup = new JButton("Sign Up");
		signup.setBounds(30,580,120,40);
		signup.setForeground(Color.WHITE);
		signup.setFont(Font.decode("Arial-BOLD-20"));
		signup.setBackground(new Color(160,182,45));
		login.add(signup);
		setSize(1700,900);
		try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Eventt", "root", "");
            PreparedStatement ps = con.prepareStatement("select eventname from Add_event");

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
							System.out.println("gayatri Sambare");
							String g="insert into RegisterStudent values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')";
							db.stmt.executeUpdate(g);
							
							String retrieve="select fullname,events from registerstudent where email ='"+b+"'";
							db.stmt.executeQuery(retrieve);						
							System.out.println("*********"+retrieve);
							
							Class.forName("com.mysql.jdbc.Driver");
				            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Eventt", "root", "");
				            
							PreparedStatement ps = con.prepareStatement("select distinct fullname,email,events, eventdate from registerstudent,add_event where events in(select events from registerstudent where events='"+f+"')");
				            System.out.println("aaartrt");
				            ResultSet rs = ps.executeQuery();
				            System.out.println("aaartrt111");
				                while (rs.next()) 
				                {
				                    String fullname = rs.getString(1);
				                    String email=rs.getString(2);
				                    String events = rs.getString(3);
				                    Date eventdate=rs.getDate(4);
				                    System.out.println(	fullname+" "+events);	
				                    sendMail(fullname,email,events,eventdate);
				                }
				                
						}
						catch(SQLException h)
						{
							System.out.println("Insert error");
							h.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 //JOptionPane.showMessageDialog(new Frame(),"Event Registration Successful"); 
					
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
					frame.dispose();
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
					new Home();
					frame.dispose();
			}
		});
		setSize(1500,900);
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
	
	
	static void sendMail(String name, String email,String event ,Date eventdate)
	{
		
	String to = email;
    String from = "gsa5851@gmail.com";
    LocalDate currentDate = LocalDate.now();
    
    // Get the given date dynamically (you can replace this with your own logic)
    Date givenDate = eventdate;
    LocalDate givenLocalDate = givenDate.toLocalDate();
    LocalDate oneDayBefore = givenLocalDate.minusDays(1);
    java.util.Date deliveryDate = Date.from(oneDayBefore.atStartOfDay(ZoneId.systemDefault()).toInstant());
    
    
    Properties properties = System.getProperties();
    // Setup mail server
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

    // Get the Session object.// and pass username and password
    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("gsa58571@gmail.com", "tdkdsictntwpdvpi");
        }

    });

    // Used to debug SMTP issues
    session.setDebug(true);

    try {
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //Date date=eventdate;
        //Date yesterday=new Date(date.getTime()-(1000*60*60*1));
        
        // Set Subject: header field
        message.setSubject("'"+event+"' reminder mail !");
        System.out.println("***********************");

        System.out.println("***********************");

        // Now set the actual message
        String ss="Dear '"+name+"'\nThank you for your interest in '"+event+"'";
        message.setText(ss);
        
        // Send message
        message.setSentDate(deliveryDate);
        Transport.send(message);
        System.out.println("Sent message successfully....");
    } 
    catch (MessagingException mex) {
        mex.printStackTrace();
    }
	}
	
	
	public static void main(String args[])
	{
		new RegisterStudent();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
		
