package servicesTools;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceAccepted {
	
	public static JSONObject ServiceAccepted () {
		JSONObject response = new JSONObject();
		
		try {
			
			response.put("Status","OK");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
}



