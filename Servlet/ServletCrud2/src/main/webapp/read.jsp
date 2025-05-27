<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.lang.Math"%>
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

	int start = (currentPage - 1) * recordsPerPage;

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");

	String search = request.getParameter("search");
	String query = "select * from register";
	String countQuery = "select count(*) from register";
	String field = request.getParameter("field");
	
	if (field == null || field.trim().isEmpty()) {
	    field = "name"; 
	}

	if (search != null && !search.trim().isEmpty()) {
	    search = "%" + search.trim() + "%";
	    query += " where " + field + " like ?";
	    countQuery += " where " + field + " like ?";
	}

	query += " limit ?, ?";


	PreparedStatement ps;
	
	if (search != null && !search.trim().isEmpty()) {
    ps = con.prepareStatement(query);
    ps.setString(1, search);
    ps.setInt(2, start);
    ps.setInt(3, recordsPerPage);
	}
	else {
    ps = con.prepareStatement("select * from register limit ?, ?");
    ps.setInt(1, start);
    ps.setInt(2, recordsPerPage);
	}
	ResultSet rs = ps.executeQuery();

	PreparedStatement countSt;
	
	if (search != null && !search.trim().isEmpty()) {
    countSt = con.prepareStatement(countQuery);
    countSt.setString(1, search);
	}
	else {
    countSt = con.prepareStatement("select count(*) from register");
	}
	ResultSet countRs = countSt.executeQuery();

	int totalRecords = 0;
	if (countRs.next()) {
	totalRecords = countRs.getInt(1);
	}

	int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
%>

<html>
<head>
<title>All Users</title>
</head>
<body>
	<h2>Registered Users</h2>

	<form method="get" action="read.jsp">
		Search: <select name="field">
			<option disabled selected>Search</option>
			<option value="name"
				<%="name".equals(request.getParameter("field")) ? "selected" : ""%>>Name</option>
			<option value="email"
				<%="email".equals(request.getParameter("field")) ? "selected" : ""%>>Email</option>
			<option value="city"
				<%="city".equals(request.getParameter("field")) ? "selected" : ""%>>City</option>
			<option value="gender"
				<%="gender".equals(request.getParameter("field")) ? "selected" : ""%>>Gender</option>
		</select> <input type="text" name="search"
			value="<%=request.getParameter("search") != null ? request.getParameter("search") : ""%>" />
		<input type="submit" value="Search" />       
	</form>

	<br />


	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Gender</th>
			<th>City</th>
			<th>Phone_no</th>
			<th>Actions</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("email")%></td>
			<td><%=rs.getString("gender")%></td>
			<td><%=rs.getString("city")%></td>
			<td><%=rs.getString("phone_no")%></td>
			<td><a href="update.jsp?email=<%=rs.getString("email")%>">Edit</a>
				| <a href="delete?email=<%=rs.getString("email")%>"
				onclick="return confirm('Are you sure?')">Delete</a> | <a
				href="view.jsp?email=<%=rs.getString("email")%>">View</a></td>
		</tr>
		<%
		}
		%>
	</table>

	<br />


	<div>
		<%
		if (currentPage > 1) {
		%>
		<a href="read.jsp?page=<%=currentPage - 1%>">Previous</a>
		<%
		}

		for (int i = 1; i <= totalPages; i++) {
		%>
		<a href="read.jsp?page=<%= i %>&search=<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>&field=<%= request.getParameter("field") != null ? request.getParameter("field") : "name" %>"><%= i %></a>


		<%
		}

		if (currentPage < totalPages) {
		%>
		<a href="read.jsp?page=<%=currentPage + 1%>">Next</a>
		<%
		}
		%>
	</div>

	<br />
	<br />
	<form action="register.jsp">
		For Registration -> <input type="submit" value="Click here" />
	</form>

</body>
</html>


