package servlets.user;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.User;

public class CreateUser extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
				String login = request.getParameter("login");
				String pwd = request.getParameter("pwd");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				JSONObject retour = new JSONObject();
				
				try{
					retour = services.User.CreateUser(login,pwd,prenom,nom);
				}catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.setContentType("/text/plain");
				PrintWriter out = response.getWriter ();
				out.println(retour.toString() );
			 }
			 

}


