package com.uttamsoft.jdbc;
import java.sql.*;
public class DatabaseConnection {
	public Connection con;
	public Statement stmt;
	public ResultSet rs;
	public DatabaseConnection() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Eventt","root","");
			stmt=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
