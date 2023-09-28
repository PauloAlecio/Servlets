package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/showError")
public class ShowErrorController extends HttpServlet {
	 
	   private static final long serialVersionUID = 1L;

	// Method to handle GET method request.
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      // Set error code and reason.
	      response.sendError(407, "Need authentication!!!" );
	   }
	   
	   // Method to handle POST method request.
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      doGet(request, response);
	   }
	
}
