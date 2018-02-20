package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class CreateUser extends HttpServlet {
	public CreateUser(){
		super();
	}
	
	 protected void doGet(HttpServletRequest request,
			 HttpServletResponse response) throws ServletException, IOException {
			 
				response.setContentType(" text / plain " );
				String login = request.getParameter("login");
				String prenom = request.getParameter("prenom");
				String nom = request.getParameter("nom");
				String mdp = request.getParameter("mdp");
				JSONObject ret;
				
				try{
					ret = services.UserServices.CreateUser(login,prenom,nom,mdp);
				}catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				PrintWriter out = response.getWriter ();
				response.setContentType("/text/plain");
				out.println(ret.toString() );
			 }
			 

}


