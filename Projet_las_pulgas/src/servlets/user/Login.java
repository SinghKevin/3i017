package servlets.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.User;

public class Login extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	 											ServletException, IOException {
		 		 
			String login = request.getParameter("login");
			String pwd = request.getParameter("pwd");
			JSONObject retour = new JSONObject();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				retour= services.User.Login(login, pwd);
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
