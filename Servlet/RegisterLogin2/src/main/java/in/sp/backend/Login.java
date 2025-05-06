package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		String myemail=req.getParameter("email");
		String mypass=req.getParameter("pass");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
			
			PreparedStatement pst=con.prepareStatement("select * from register where email=? and password=?");
			pst.setString(1, myemail);
			pst.setString(2, mypass);
			
			ResultSet rst=pst.executeQuery();
			if(rst.next()) {
				
				HttpSession session=req.getSession();
				session.setAttribute("session_name", rst.getString("name"));
				
				RequestDispatcher rd=req.getRequestDispatcher("profile.jsp");
				rd.include(req, resp);
			}
			else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> Email id and password didn't match</h3>");
				
				RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
			}
			
		}
		catch(Exception e)	{
			e.printStackTrace();
			
			resp.setContentType("text/html");
			out.print("<h3 style='color=red'>"+e.getMessage()+"</h3>");
			
			RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
		}
		}
}
