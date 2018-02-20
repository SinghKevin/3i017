package servlets.message;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import services.DeleteMessage;

public class ServletDeleteMessage extends HttpServlet {
	 protected void doGet(HttpServletRequest request,
			 			HttpServletResponse response) throws ServletException, IOException {
		 		 
		    response.setContentType(" text / plain " );
			String key = request.getParameter("key");
			String id_message = request.getParameter("id_message");
			JSONObject ret;
			
			try{
				ret = services.Message(key,id_message);
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter ();
			response.setContentType("/text/plain");
			out.println(ret.toString() );
		 }
		 

}
