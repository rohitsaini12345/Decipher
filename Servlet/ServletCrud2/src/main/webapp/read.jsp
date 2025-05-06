<%@ page import="java.sql.*" %>
<%@ page import="java.lang.Math" %>
<%
    int currentPage = 1;
    int recordsPerPage = 5;
    
    if (request.getParameter("page") != null) {
        try {
        	currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
        	currentPage = 1; 
        }
    }

    int start = (currentPage  - 1) * recordsPerPage;

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");

    
    PreparedStatement ps = con.prepareStatement("SELECT * FROM register LIMIT ?, ?");
    ps.setInt(1, start);
    ps.setInt(2, recordsPerPage);
    ResultSet rs = ps.executeQuery();

    
    Statement countSt = con.createStatement();
    ResultSet countRs = countSt.executeQuery("SELECT COUNT(*) FROM register");
    int totalRecords = 0;
    if (countRs.next()) {
        totalRecords = countRs.getInt(1);
    }

    int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
%>

<html>
<head><title>All Users</title></head>
<body>
    <h2>Registered Users</h2>
    <table border="1">
        <tr><th>Name</th><th>Email</th><th>Gender</th><th>City</th><th>Phone_no</th><th>Actions</th></tr>
        <%
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("email") %></td>
            <td><%= rs.getString("gender") %></td>
            <td><%= rs.getString("city") %></td>
            <td><%= rs.getString("phone_no") %></td>
            <td>
                <a href="update.jsp?email=<%= rs.getString("email") %>">Edit</a> |
                <a href="delete?email=<%= rs.getString("email") %>" onclick="return confirm('Are you sure?')">Delete</a> |
                <a href="view.jsp?email=<%= rs.getString("email") %>">View</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <br/>
    
    <!-- Pagination Links -->
    
    <div>
        <%
            if (currentPage  > 1) {
        %>
            <a href="read.jsp?page=<%= currentPage  - 1 %>">Previous</a>
        <%
            }

            for (int i = 1; i <= totalPages; i++) {
        %>
            <a href="read.jsp?page=<%= i %>"><%= i %></a>
        <%
            }

            if (currentPage  < totalPages) {
        %>
            <a href="read.jsp?page=<%=currentPage  + 1 %>">Next</a>
        <%
            }
        %>
    </div>

    <br/><br/>
    <form action="register.jsp">
        For Registration -> <input type="submit" value="Click here"/>
    </form>

</body>
</html>
