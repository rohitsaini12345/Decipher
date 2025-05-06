package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String myname=req.getParameter("name1");
		String myemail=req.getParameter("email1");
		String mypass=req.getParameter("pass1");
		String mygender=req.getParameter("gender1");
		String mycity=req.getParameter("city1");
		String myphoneno=req.getParameter("phone_no1");
		
		if (myname == null || myemail == null || mypass == null || mygender == null ||mycity==null|| myphoneno == null) {
	            out.print("<h3 style='color:red'>All fields are required!</h3>");
	            req.getRequestDispatcher("/read.jsp").include(req, resp);
	            return;
	        }
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
			
			PreparedStatement pst=con.prepareStatement("insert into register values(?,?,?,?,?,?)");
			pst.setString(1,myname);
			pst.setString(2, myemail);
			pst.setString(3, mypass);
			pst.setString(4, mygender);
			pst.setString(5, mycity);
			pst.setString(6, myphoneno);
			
			int count=pst.executeUpdate();
			if(count>0) {
				
				out.print("<h3 style='color:green'>success</h3>");
				
			}
			else {
				
				out.print("<h3 style='color:red'> not success</h3>");
				
			}
			RequestDispatcher rd=req.getRequestDispatcher("/read.jsp");
			rd.include(req, resp);
		}
		catch(Exception e){
			e.printStackTrace();
			
			out.print("<h3 style='color:red'> Exception Occured : "+ e.getMessage()+"</h3>");
			
			RequestDispatcher rd=req.getRequestDispatcher("/read.jsp");
			rd.include(req, resp);
		}
	}
}
