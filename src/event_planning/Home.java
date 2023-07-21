package event_planning;

import java.awt.Color;              
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Home implements ActionListener
{

	private static final boolean flase = false;
	JFrame f=new JFrame("Main Page");
	JLabel ll, ll1, ll2,l1,l2,l3,l4,l5,l6,l7;
	JButton b,b1,b2,b3,b4,b5,b6,b7;
	JTextField tf1, tf2, tf3, tf4;
    JPanel p1,p2;
    String str;
	public JMenuBar menubar;
	
	Home()
	{
		ImageIcon icon = new ImageIcon();
		JLabel l=new JLabel(icon);
		l.setIcon(new ImageIcon(new ImageIcon(".\\src\\img\\image4.jpg").getImage().getScaledInstance(1400,900, Image.SCALE_DEFAULT)));
	  	f.add(l);
	  	p1=new JPanel();
		JLabel l2=new JLabel("Welcome to Event Planning System !!!",JLabel.CENTER);
		l2.setFont(new Font("Verdana", Font.BOLD, 45));
		l2.setForeground(Color.red);
		l2.setBounds(140,140,1200,50);
	    l2.setBackground(new Color(85, 20, 70));
		l.add(l2);
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		JMenuBar menubar = new JMenuBar();
		
		b3=new JButton(" Events     ");
		b3.setFont(Font.decode("Arial-BOLD-24"));
		b3.setForeground(Color.BLACK);
		
        b3.setBorder(emptyBorder);
        b3.setFocusPainted(false);
        b3.setOpaque(false);
        b3.setContentAreaFilled(false);
        b3.setBorderPainted(false);
        b3.addActionListener(this);
		p1.add(b3);
		
		
		b4=new JButton(" About    ");
		b4.setFont(Font.decode("Arial-BOLD-24"));
		b4.setForeground(Color.BLACK);
		b4.setBorder(emptyBorder);
        b4.setFocusPainted(false);
        b4.setOpaque(false);
        b4.setContentAreaFilled(false);
        b4.setBorderPainted(false);
		l.add(b4);
		b4.addActionListener(this);
		b5=new JButton(" Contact Us   ");
		
		b5.setFont(Font.decode("Arial-BOLD-24"));
		b5.setForeground(Color.BLACK);
		b5.setBorder(emptyBorder);
        b5.setFocusPainted(false);
        b5.setOpaque(false);
        b5.setContentAreaFilled(false);
        b5.setBorderPainted(false);
		b5.addActionListener(this);
		
        JMenu menu1 = new JMenu("   Login As ");
        menu1.setMnemonic(KeyEvent.VK_R);
        menu1.setPreferredSize(new java.awt.Dimension(140, 40));
        menu1.setOpaque(true);
        menu1.setFont(Font.decode("Arial-BOLD-24"));
        JMenuItem log1 = new JMenuItem("Admin");
        JMenuItem log2 = new JMenuItem("Student");
       
        log1.setFont(Font.decode("Arial-BOLD-24"));
        log2.setFont(Font.decode("Arial-BOLD-24"));
        
        
        menubar.add(b3);
        menubar.add(b4);
        menubar.add(b5);
        menubar.add(menu1);
        menu1.add(log1);
        menu1.add(log2);
       
        log1.addActionListener(this);
        log2.addActionListener(this);
       
        f.setJMenuBar(menubar);
       
        JPanel panel=new JPanel();
        panel.setBounds(5,5,1000,100);
        panel.setOpaque(flase);
        l.add(panel);
        menubar.setOpaque(flase);
        JMenu menu2 = new JMenu("  Register As   ");
        menu2.setPreferredSize(new java.awt.Dimension(160, 40));
        menu2.setHorizontalAlignment(JMenu.RIGHT);
        menu2.setOpaque(true);
        menu2.setFont(Font.decode("Arial-BOLD-24"));
        
        JMenuItem reg2 = new JMenuItem("Student");
      
       
        reg2.setFont(Font.decode("Arial-BOLD-24"));
      
        menu2.add(reg2);
       
        menubar.add(menu2);
        f.setJMenuBar(menubar);
        menubar.add(Box.createHorizontalGlue());
        menubar.setAlignmentX(1000);
        JMenu jMenu = new JMenu();
		jMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
       
	
		menubar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		menubar.setOpaque(true);
		menubar.setBackground(Color.YELLOW);
		menu1.setOpaque(true);
		menu1.setBackground(Color.yellow);
		menu2.setOpaque(true);
		menu2.setBackground(Color.yellow);
		log1.setBackground(Color.yellow);
		log2.setBackground(Color.yellow);
		
		reg2.setBackground(Color.yellow);
		
		f.setBounds(0,0,1500,800);
		f.setVisible(true);
		
		
		log1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin l=new LoginAdmin();
			}
		});
		log2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginStudent();
			}
		});
		
		reg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterStudent();
			}
		});
		
	}
	public static void main(String[] args) {
		new Home();
	}
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(e.getSource()==b)
		{
			new Frame1Next();
		}
		else if(e.getSource()==b4)
		{
			new About();
		}
		else if(e.getSource()==b5)
		{
			new Contact_Us();
		}
		else if(e.getSource()==b3)
		{
			new Frame1Next();
		}
	}
}

