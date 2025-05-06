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

@WebServlet("/edit")
public class Update extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        String gender = req.getParameter("gender");
        String city = req.getParameter("city");
        String phone_no=req.getParameter("phone_no");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");

            // Update query — only update changed fields
            PreparedStatement pst = con.prepareStatement(
                "UPDATE register SET name=?, password=?, gender=?, city=?, phone_no=? WHERE email=?"
            );
            pst.setString(1, name);
            pst.setString(2, password);
            pst.setString(3, gender);
            pst.setString(4, city);
            pst.setString(5, phone_no);
            pst.setString(6, email);

            int count = pst.executeUpdate();
            if (count > 0) {
                out.print("<script>alert('Record updated successfully'); window.location='read.jsp';</script>");
            } else {
                out.print("<script>alert('Update failed'); window.location='read.jsp';</script>");
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('Exception: " + e.getMessage() + "'); window.location='read.jsp';</script>");
        }
    }
}
