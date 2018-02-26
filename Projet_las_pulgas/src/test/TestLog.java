package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;

public class TestLog {
	public static void main(String[] args) throws SQLException, JSONException, ClassNotFoundException {
	Connection c=ma_bd.Database.getMySQLConnection();
	System.out.println("Login: "+services.User.Login("3408748","monmdp"));
	System.out.println("Logout: "+services.User.Logout("vVRXCntuLKHqQHCYGUXiRLzxWABECalt"));
	c.close();
	}
}