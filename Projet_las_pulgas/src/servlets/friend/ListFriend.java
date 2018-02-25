package servlets.friend;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.friend.listFriend;

public class ServletListFriend extends HttpServlet {
	public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException { 
		
		String key= requete.getParameter("key"); 
		String id_user = requete.getParameter("id_user"); 
		String index_debut = requete.getParameter("index_debut");
		String nb_demandes = requete.getParameter("nb_demandes");
		
		JSONObject retour = ListFriend.ListFriend(key, id_user, index_debut, nb_demandes);
		reponse.setContentType("text/plain");
		reponse.getWriter().print(retour);
	}
}
