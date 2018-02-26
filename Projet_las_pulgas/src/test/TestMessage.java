package test;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

public class TestMessage {
	public static void main(String[] args) throws SQLException, JSONException, ClassNotFoundException, UnknownHostException {
	Connection c=ma_bd.Database.getMySQLConnection();
	System.out.println("Add Message: "+services.Messages.AddMessage("uneclef","monmessage"));
	 String l= "Messi";
	System.out.println("Remove Message: "+services.Messages.ListMessage(l));
	c.close();
	}
}