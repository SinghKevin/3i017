package servlets.message;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.Messages;


public class AddMessage extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			
			String key = request.getParameter("key");
			String content = request.getParameter("content");
			String retour=servicesTools.ServiceRefused.serviceRefused("AddMessage Fail", 100).toString();
			
				try {
					retour = services.Messages.AddMessage(key, content).toString();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter ();
			out.println(retour.toString() );
		 }
		 

}
