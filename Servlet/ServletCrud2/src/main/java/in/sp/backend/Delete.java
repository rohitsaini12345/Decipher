package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");

            PreparedStatement pst = con.prepareStatement("DELETE FROM register WHERE email = ?");
            pst.setString(1, email);
            int row = pst.executeUpdate();

            if (row > 0) {
                out.print("<script>alert('User deleted successfully'); window.location='read.jsp';</script>");
            } else {
                out.print("<script>alert('User not found'); window.location='read.jsp';</script>");
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('Error occurred: " + e.getMessage() + "'); window.location='read.jsp';</script>");
        }
    }
}
