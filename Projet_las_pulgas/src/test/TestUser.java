
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
	public static void main(String[] args) throws SQLException, UnknownHostException, JSONException 
	{
		System.out.println("Create user: "+services.User.createUser("3408748","monmdp","Fabien","Tang"));
		System.out.println("Create user: "+services.User.createUser("1234567","deagle","Juan","Montoya"));
		System.out.println("Delete user: "+services.User.DeleteUser("1234567"));
		System.out.println("----------------------------");		
		Connection c=ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		ResultSet curseur = lecture.executeQuery("Select * from Users;");
		while (curseur.next())
		{
			System.out.println("id: "+curseur.getString("id"));
			System.out.println("login: "+curseur.getString("login"));
			System.out.println("nom: "+curseur.getString("nom"));
			System.out.println("prenom: "+curseur.getString("prenom"));
			System.out.println("password: "+curseur.getString("password"));
		}
		curseur.close();
		lecture.close();
		c.close();
		//bd.MessageTools.addMessage(3520543,"mow");
	}
}