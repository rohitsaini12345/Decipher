package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitForm")   //annotation means without web.xml file
public class MyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// backend
	
		String myname=req.getParameter("name1");
		String myemail=req.getParameter("email");
		
		PrintWriter out=resp.getWriter();
		out.println("name1: "+myname);
		out.println("email: "+myemail);
	}
}
