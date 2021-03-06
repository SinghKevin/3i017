package servlets.friend;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.Friend;

public class RemoveFriend extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

			String key = request.getParameter("key"); 
			String id_friend = request.getParameter("id_friend"); 	
			int id = Integer.parseInt(id_friend);	
			JSONObject retour= new JSONObject();

				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					retour = services.Friend.RemoveFriend(key, id);
				} catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			
				
				response.setContentType("text/plain");
				PrintWriter out = response.getWriter ();
				out.println(retour.toString() );
			 }

}
