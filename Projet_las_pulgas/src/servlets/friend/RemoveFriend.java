package servlets.friend;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import java.io.IOException;

import services.friend.RemoveFriend;

public class ServletRemoveFriend extends HttpServlet {
	public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
		String key = requete.getParameter("key"); 
		String id_friend = requete.getParameter("id_friend"); 
			
		JSONObject retour = RemoveFriend.RemoveFriend(key, id_friend);
		reponse.setContentType("application/json");
		reponse.getWriter().print(retour);	
	}
}




