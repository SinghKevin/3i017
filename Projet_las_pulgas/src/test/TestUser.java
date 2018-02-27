
package test;

import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import org.json.JSONException;


public class TestUser
{
	public static void main(String[] args) throws SQLException, UnknownHostException, JSONException, InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		System.out.println("Create user: "+services.User.createUser("123456789987654321","eopfj","zsolfol","edki"));
		System.out.println("Create user: "+services.User.createUser("123456789987654321","sdfksmdkf","sdfmsdofk","sùdgfvmsdl,gk"));
		System.out.println("Delete user: "+services.User.DeleteUser("123456789987654321"));
		System.out.println("----------------------------");		
		Connection c=ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		ResultSet curseur = lecture.executeQuery("Select * from user;");
		while (curseur.next())
		{
			System.out.println("id: "+curseur.getString("id"));
			System.out.println("login: "+curseur.getString("login"));
			System.out.println("pwd: "+curseur.getString("pwd"));
			System.out.println("nom: "+curseur.getString("nom"));
			System.out.println("prenom: "+curseur.getString("prenom"));

		}
		curseur.close();
		lecture.close();
		c.close();
		//bd.MessageTools.addMessage(3520543,"mow");
	}
}