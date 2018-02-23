package servlets.friend;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import services.friend.RemoveFriend;

public class ServletRemoveFriend extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws 								ServletException, IOException {
			

			String key = requete.getParameter("key"); 
			String id_friend = requete.getParameter("id_friend"); 	
			JSONObject retour= new JSONObject();
			
			try{
				retour = services.AddMessage(key, id_friend);
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.setContentType("/text/plain");
			PrintWriter out = response.getWriter ();
			out.println(retour.toString() );	
		 }
		 

}
