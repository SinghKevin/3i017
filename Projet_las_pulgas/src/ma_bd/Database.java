package ma_bd;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class Database {
	private DataSource dataSource;
	private static Database database=null;
	public Database(String jndiname) throws SQLException {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/" + jndiname);
		} catch (NamingException e) {
			// Handle error that it’s not configured in JNDI.
		    throw new SQLException(jndiname + " is missing in JNDI! : "+e.getMessage());
			
		}
	}
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
		
	}
	
	public static DBCollection getCollection(String nom_collection) throws UnknownHostException{
		Mongo m=new Mongo("localhost");
		DB db=m.getDB("ma_mongo_bd");
		DBCollection message = db.getCollection(nom_collection);
		return message;
								
		
	}

	
	public static Connection getMySQLConnection() throws SQLException {
		if (DBStatic.mysql_pooling==false) {
			return(DriverManager.getConnection("jdbc:mysql://" + DBStatic.mysql_host + "/" +
					DBStatic.mysql_db, DBStatic.mysql_username, DBStatic.mysql_password));
		}
		else {
			if (database==null) {
				database=new Database("jdbc/db");
			}
			return(database.getConnection());
				
		}
	}
}

