<%@ page import="java.sql.*" %>
<html>
<head><title>All Users</title></head>
<body>
    <h2>Registered Users</h2>
    	<table border="1">
        <tr><th>Name</th><th>Email</th><th>Gender</th><th>City</th><th>Phone_no</th><th>Actions</th></tr>
        <%
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from register");

            while(rs.next()) {
        %>
            <tr>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getString("email") %></td>
                <td><%= rs.getString("gender") %></td>
                <td><%= rs.getString("city") %></td>
                <td><%= rs.getString("phone_no") %></td>
                <td>
                    <a href="update.jsp?email=<%= rs.getString("email") %>">Edit</a> |
                    <a href="delete?email=<%= rs.getString("email") %>" onclick="return confirm('Are you sure?')">Delete</a>|
                    <a href="view.jsp?email=<%= rs.getString("email") %>">View</a>
                </td>
            </tr>
        <%
            }
        %>
    </table>
    
</body>
</html>
