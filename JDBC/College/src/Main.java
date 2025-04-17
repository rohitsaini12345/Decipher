import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "root";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Insert a record
            String insertQuery = "INSERT INTO teacher (id, name, address, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertQuery);
            pst.setInt(1, Integer.parseInt("1"));
            pst.setString(2, "Mahesh");
            pst.setString(3, "Pratap Nagar");
            pst.setFloat(4, Float.parseFloat("30000.0"));
            pst.executeUpdate();

            // Retrieve all records
            String selectQuery = "SELECT * FROM teacher";
            ResultSet rs = con.prepareStatement(selectQuery).executeQuery();

            System.out.println("All teachers:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                float salary = Float.parseFloat(rs.getString("salary"));

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Salary: " + salary);
                System.out.println("------------");
            }

            // Close resources
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
