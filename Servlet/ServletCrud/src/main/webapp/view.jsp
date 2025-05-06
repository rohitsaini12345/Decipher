<%@ page import="java.sql.*" %>
<%
    String email = request.getParameter("email");
    String name = "", gender = "", city = "", phone_no = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");

        PreparedStatement pst = con.prepareStatement("SELECT * FROM register WHERE email = ?");
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            name = rs.getString("name");
            gender = rs.getString("gender");
            city = rs.getString("city");
            phone_no = rs.getString("phone_no");
        }

        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <h2>User Details</h2>
    <table border="1" cellpadding="10">
        <tr><th>Name</th><td><%= name %></td></tr>
        <tr><th>Email</th><td><%= email %></td></tr>
        <tr><th>Gender</th><td><%= gender %></td></tr>
        <tr><th>City</th><td><%= city %></td></tr>
        <tr><th>Phone_no</th><td><%= phone_no %></td></tr>
    </table>
    <br/>
    <a href="read.jsp">Back to Table</a>
</body>
</html>


