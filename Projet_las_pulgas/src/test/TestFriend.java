package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;

public class TestFriend {

	public static void main(String[] args) throws JSONException, SQLException 
	{
		Connection c=ma_bd.Database.getMySQLConnection();
		System.out.println("Login: "+services.Friend.AddFriend("test",38));
		System.out.println("Login: "+services.Friend.RemoveFriend("ByEjjWBWcxrcEVBNewsiWfTjMqErbEHT",38));
		c.close();
	}

}