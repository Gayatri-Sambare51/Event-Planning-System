package event_planning;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class LoginAdmin extends JFrame implements ActionListener
{
	JLabel name,l1,l2;
	
	
	JTextField username,Password;
	JPanel heading;
	JButton signup,login_button;
	LoginAdmin()
	{
		Font f = new Font("Serif",Font.BOLD,40);
		setSize(1000,1000);
		setTitle("Home Page");
		pack();
		JPanel heading;
		heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		
		heading.setBounds(0,0,1600,100);
		JLabel name = new JLabel("Login As Admin");
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
		
		JButton back = new JButton("Back");
		
		back.setBounds(270,330,140,50);
		back.setFont(Font.decode("Arial-BOLD-20"));
		back.setBackground(new Color(160,182,45));
		login.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new Home();
			}
		});
		
		JButton login_button = new JButton("login");
		login_button.setBounds(90,330,140,45);
		login_button.setFont(Font.decode("Arial-BOLD-20"));
		login_button.setBackground(new Color(160,182,45));
		login.add(login_button);
		
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userText;
	            String pwdText;
	            userText = username.getText();
	            pwdText = Password.getText();
	            if ((userText.equalsIgnoreCase("Gayatri_51") && pwdText.equalsIgnoreCase("12345")) ||(userText.equalsIgnoreCase("Abhishek_51") && pwdText.equalsIgnoreCase("12345"))) {
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
		ImageIcon background_image = new ImageIcon(".\\src\\img\\download3.jpg");
		
		Image img  = background_image.getImage();
		Image temp_img = img.getScaledInstance(1600,900,Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("",background_image,JLabel.CENTER);

		background.add(login);
		background.add(heading);
		background.setBounds(0,0,1600,900);
		add(background);
		setTitle("Login As Admin");
		setVisible(true);
	}
	public static void main(String args[])
	{
		new LoginAdmin();
	}
	public void actionPerformed(ActionEvent e) {
		
	}
}
		
