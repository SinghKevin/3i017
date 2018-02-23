package servlets.message;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.JSONException;

import services.ListMessage;

public class ServletListMessage extends HttpServlet {
	 protected void doGet(HttpServletRequest request,
			 			HttpServletResponse response) throws ServletException, IOException {
		 		 
		    response.setContentType(" text / plain " );
			String key = request.getParameter("key");
			String list_id_user = request.getParameter("list_id_user");	
			JSONObject ret;
			
			try{
				ret = services.ListMessage(key, list_id_user);
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter ();
			response.setContentType("/text/plain");
			out.println(ret.toString() );
		 }
		 

}
