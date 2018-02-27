package servicesTools;

import org.json.JSONException;
import org.json.JSONObject;

public  class ServiceRefused{

	public static JSONObject serviceRefused (String n , int idError) {

	

	JSONObject reponse = new JSONObject();
	try {
		reponse.put("Status","KO ServiceRefused");
		reponse.put("Message",n);
		reponse.put("idError",""+idError);
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return reponse;
	
	}	
}