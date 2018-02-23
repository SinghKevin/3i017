package servlets.message;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import services.AddMessage;

public class ServletAddMessage extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws 								ServletException, IOException {
		 		 
			String key = request.getParameter("key");
			String content = request.getParameter("content");	
			JSONObject ret;
			
			try{
				ret = services.AddMessage(key, content);
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.setContentType("/text/plain");
			PrintWriter out = response.getWriter ();
			out.println(retour.toString() );
		 }
		 

}
