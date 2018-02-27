package servlets.message;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.Messages;

public class DeleteMessage extends HttpServlet {
	 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 		 
			String key=request.getParameter("key");
			String id_message=request.getParameter("id_message");
			String retour= servicesTools.ServiceRefused.serviceRefused("DeleteMessage Fail", 100).toString();
			try{
				retour=services.Messages.DeleteMessage(key,id_message).toString();
			}catch(Exception e){
				retour=servicesTools.ServiceRefused.serviceRefused("DeleteMessage Fail", 100).toString();
			}
			
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.print(retour);
		 }
		 

}

