package event_planning;
import java.sql.*;
public class DatabaseConnection {
	public Connection con;
	public Statement stmt;
	public ResultSet rs;
	public DatabaseConnection() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Hello1");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Eventt","root","");
			System.out.println("Hello1");
			stmt=con.createStatement();
			System.out.println("Hello1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Hello1");
		}
	}
}
