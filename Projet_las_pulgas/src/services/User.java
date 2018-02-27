package services;
//import servicesTools;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import ma_bd.UserTools;
 

public class User {
	

	public static JSONObject createUser(String login, String pwd, String nom, String prenom) throws JSONException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
			
				if (login == null || pwd == null || nom == null || prenom == null)
					return servicesTools.ServiceRefused.serviceRefused("Missing as",100);
				if(ma_bd.UserTools.userExists(login))
					return servicesTools.ServiceRefused.serviceRefused("user already exists",10);
				return ma_bd.UserTools.createUser(login, pwd, nom, prenom);
				
				
	
	}
	
	
	public static JSONObject DeleteUser(String login) throws JSONException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (login == null)
			return servicesTools.ServiceRefused.serviceRefused("Missing arg",100);
		if (!ma_bd.UserTools.userExists(login))
			return servicesTools.ServiceRefused.serviceRefused("User doesn't exist", 100);
		
        return ma_bd.UserTools.deleteUser(login);
	}
	
	
	public static JSONObject Login(String login, String pwd) throws JSONException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		JSONObject retour = new JSONObject();
		
	
			if(login == null || pwd == null){
				return servicesTools.ServiceRefused.serviceRefused("Wrong Argument", -1);
			}
			
			if(!ma_bd.UserTools.userExists(login)){
				retour.put("Status", "KOKOKO");
				retour.put("Error", "User doesn't exist ! Join us :) ");
				return retour;
			
			}
			if(!ma_bd.UserTools.checkPassword(login,pwd)){
				retour.put("Status", "KOKO");
				retour.put("Error", "Wrong Password ! Please try again");
				return retour;
			}
			
	
			//boolean root=bd.UserTools.isRoot(login);
			//String key = bd.UserTools.insererConnexion(login,root);
			String key = ma_bd.UserTools.insertConnection(login);
			retour.put("Status","OK");
			retour.put("Key",key);
			return retour;
			
//		boolean root=ma_bd.UserTools.is_root(login);
//		if (root){
//			String key = ma_bd.UserTools.insertConnection(login,root);
//			retour.put("Status","OK");
//			retour.put("Key",key);
//			return retour;
//		} else {
//		String key_2 = ma_bd.UserTools.insertConnection(login);
//		retour.put("Status","OK");
//		retour.put("Key",key_2);
//		return retour;
//		}
	}
	
		 

		public static JSONObject Logout(String key) throws JSONException,SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
			if (key == null)
				return servicesTools.ServiceRefused.serviceRefused("key manquant",100);
			return ma_bd.UserTools.insertDisconnection(key);
		}

}

