package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mylogin")   //annotation means without web.xml file
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// backend
	
		String myemail=req.getParameter("name1");
		String mypass=req.getParameter("pass1");
		
		if(myemail.equals("rohit@gmail.com")&& mypass.equals("rohit@123")) {
			System.out.println("success");
		}
		else {
			System.out.println("failed");
		}
	}
}