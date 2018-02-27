package servlets.message;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.Messages;

public class ListMessage extends HttpServlet {
	 protected void doGet(HttpServletRequest request,
			 			HttpServletResponse response) throws ServletException, IOException {
		 		 
		   
			String key = request.getParameter("key");
			String list_id_user = request.getParameter("list_id_user");	
			JSONObject retour = new JSONObject();
			
			try{
				retour = services.Messages.ListMessage(key, list_id_user);
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter ();
			response.setContentType("text/plain");
			out.println(retour.toString() );
		 }
		 

}
