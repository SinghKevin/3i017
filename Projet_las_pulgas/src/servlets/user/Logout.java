package servlets.user;

package servlets.user;

package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class ServletLogout extends HttpServlet {
	public class Logout {

	}
	 protected void doGet(HttpServletRequest request,
			 			HttpServletResponse response) throws ServletException, IOException {
		 		 
		    response.setContentType(" text / plain " );
			String logout = request.getParameter("key");
			JSONObject ret;
			
			try{
				ret = services.UserServices.Logout(logout);
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter ();
			response.setContentType("/text/plain");
			out.println(ret.toString() );
		 }
		 

}

	 }
	
		 
