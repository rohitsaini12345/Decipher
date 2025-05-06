<%@ page import="java.sql.*" %>
<%
    String email = request.getParameter("email");
    String name = "", gender = "", city = "" , phone_no ="";

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
    PreparedStatement pst = con.prepareStatement("SELECT * FROM register WHERE email=?");
    pst.setString(1, email);
    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
        name = rs.getString("name");
        gender = rs.getString("gender");
        city = rs.getString("city");
        phone_no=rs.getString("phone_no");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>
    <form action="edit" method="post">
        <input type="hidden" name="email" value="<%= email %>" required/>
        Name: <input type="text" name="name" pattern="[A-Za-z\s]+" value="<%= name %>" required/><br/><br/>
        Password: <input type="password" name="pass" required/><br/><br/>
        Gender:
        <input type="radio" name="gender" value="male" <%= gender.equals("male") ? "checked" : "" %> required/> Male
        <input type="radio" name="gender" value="female" <%= gender.equals("female") ? "checked" : "" %>/ required> Female<br/><br/>
        City: <select name="city" value="<%= city %>" required>
				<option disabled selected>Select City</option>
				<option>Rajasthan</option>
				<option>Delhi</option>
				<option>Mumbai</option>
				<option>Chennai</option>
			</select><br/><br/><br/>
        Phone_no:<input type="tel" name="phone_no" pattern="[0-9]{10}" value="<%= phone_no %>" required/><br/><br/>
        <input type="submit" value="Update"/>
    </form>
</body>
</html>
