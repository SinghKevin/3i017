package ma_bd;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import servicesTools.ServiceRefused;
import servicesTools.ServiceAccepted;

import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class UserTools {

	/* Permet de faire toutes les opérations sur la bd. */

	public static boolean userExists(String login) throws SQLException {

		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "SELECT login FROM user WHERE login='" + login + "';";
		ResultSet curseur = lecture.executeQuery(query);
		boolean retour;
		if (curseur.next())
			retour = true;
		else
			retour = false;
		curseur.close();
		lecture.close();
		c.close();
		return retour;
	}

	public static JSONObject deleteUser(String login) throws SQLException {

		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "DELETE from user where login='" + login + "';";
		JSONObject retour = ServiceAccepted.ServiceAccepted();
		try {
			lecture.executeUpdate(query);
		} catch (SQLException e) {
			retour = ServiceRefused.serviceRefused("KO", 100);
		}
		lecture.close();
		c.close();
		return retour;
	}

	public static JSONObject createUser(String login, String pwd,
			String prenom, String nom) throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "insert into user values (NULL,'" + login
				+ "',PASSWORD('" + pwd + "'),'" + prenom + "','" + nom + "');";
		JSONObject retour = ServiceAccepted.ServiceAccepted();
		try {
			lecture.executeUpdate(query);
		} catch (SQLException e) {
			retour = ServiceRefused.serviceRefused("KO", 100);
		}
		lecture.close();
		c.close();
		return retour;
	}

	public static boolean checkPassword(String login, String pwd)
			throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "select * from user where login='" + login + "';";
		ResultSet cursor = lecture.executeQuery(query);
		boolean retour;
		if (!cursor.next())
			retour = false;
		else
			retour = cursor.getString("pwd").equals(pwd);
		lecture.close();
		c.close();
		return retour;
	}

	public static boolean is_root(String login) throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "select * from session where login='" + login + "';";
		ResultSet cursor = lecture.executeQuery(query);
		boolean retour;
		boolean reponse;
		reponse = cursor.getBoolean("is_root");
		if (reponse)
			retour = true;
		else
			retour = false;
		lecture.close();
		c.close();
		return retour;
	}

	public static int getUserId(String login) throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "select * from user where login='" + login + "';";
		ResultSet cursor = lecture.executeQuery(query);
		int user_id = 0;
		while (cursor.next())
			user_id = cursor.getInt("Id");
		lecture.close();
		c.close();
		return user_id;
	}

	public static int getUserId2(String key) throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "select * from session s where s.key='" + key + "';";
		ResultSet cursor = lecture.executeQuery(query);
		int user_id = 0;
		while (cursor.next())
			user_id = cursor.getInt("id_user");
		lecture.close();
		c.close();
		return user_id;
	}

	public static String generate_key() {
		String key = "";
		char c;
		for (int i = 0; i < 32; i++) {
			Random r = new Random();
			if (Math.random() < 0.5)
				c = (char) (r.nextInt(26) + 'A');
			else
				c = (char) (r.nextInt(26) + 'a');
			key += c;
		}
		return key;
	}

	public static String insertConnection(String login) throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String key = generate_key();
		int id_user = getUserId(login);
		String query = "INSERT into session values (" + id_user
				+ ",CURRENT_TIMESTAMP,'" + key + "',false,0);";
		lecture.executeUpdate(query);
		lecture.close();
		c.close();
		return key;
	}

	public static String insertConnection(String login, boolean root)
			throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String key = generate_key();
		int id_user = getUserId(login);
		String query = "INSERT into session values (" + id_user
				+ ",CURRENT_TIMESTAMP,'" + key + "','" + root + "',0);";
		lecture.executeUpdate(query);
		lecture.close();
		c.close();
		return key;
	}

	public static JSONObject insertDisconnection(String key)
			throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "update session s set expiration_value=true where s.key='"
				+ key + "';";
		lecture.executeUpdate(query);
		lecture.close();
		c.close();
		return ServiceAccepted.ServiceAccepted();
	}

	public static JSONObject AddFriend(String key, int id_friend)
			throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		int user_id = getUserId2(key);
		String query = "insert into friend values (" + user_id + ","
				+ id_friend + ",CURRENT_TIMESTAMP)";
		JSONObject retour = ServiceAccepted.ServiceAccepted();
		try {
			lecture.executeUpdate(query);
		} catch (SQLException e) {
			retour = ServiceRefused.serviceRefused("KO", 100);
		}
		lecture.close();
		c.close();
		return retour;
	}

	public static JSONObject RemoveFriend(String key, int id_friend)
			throws SQLException {
		Connection c = ma_bd.Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		int user_id = getUserId2(key);
		String query = "delete from friend where id_user=" + user_id
				+ " and id_friend=" + id_friend + ";";
		JSONObject retour = ServiceAccepted.ServiceAccepted();
		try {
			lecture.executeUpdate(query);
		} catch (SQLException e) {
			retour = ServiceRefused.serviceRefused("KO", 100);
		}
		lecture.close();
		c.close();
		return retour;
	}

	public static String ListMessage(String users) {
		// TODO Auto-generated method stub
		return null;
	}

	public static DBCollection AddMessage(String key, String message)
			throws UnknownHostException, SQLException {
		DBCollection message_co = Database.getCollection("message");
		BasicDBObject bdo = new BasicDBObject();
		String random=UserTools.generate_key();
		int id_user = UserTools.getUserId2(key);
		if (id_user == 0) {

			System.out.println("Unvalid key !!!");
		} else {
			bdo.put("id_user", id_user);
			bdo.put("content", message);
			bdo.put("id_message", random);
			message_co.insert(bdo);
		}
		return message_co;
	}

	public static DBCollection DeleteMessage(String key, String id_message) throws UnknownHostException, SQLException {
		DBCollection message = Database.getCollection("message");
		int id_user = UserTools.getUserId2(key);
		if (id_user == 0) {
			System.out.println("Unvalid key !!!");
		} else {
			BasicDBObject query = new BasicDBObject();
			query.append("id_user", id_user);
			query.append("id_message", id_message);
			message.remove(query);
		}
		return message;
	}

}
