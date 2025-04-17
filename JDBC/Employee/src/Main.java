import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/college";
        String user="root";
        String password="root";
        try{
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connector
            Connection con= DriverManager.getConnection(url,user,password);

            //create statement
            String insert ="insert into employee(id,name,salary,email) values (?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(insert);

            System.out.println("Enter values");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("id");
            int id=Integer.parseInt(br.readLine());

            System.out.println("name");
            String name=br.readLine();

            System.out.println("salary");
            float salary= Float.parseFloat(br.readLine());

            System.out.println("email");
            String email=br.readLine();

            pst.setInt(1,id);
            pst.setString(2,name);
            pst.setFloat(3,salary);
            pst.setString(4,email);

            pst.executeUpdate();

            //retrieve
            String query="select * from employee";
            ResultSet rst=con.prepareStatement(query).executeQuery();


            System.out.println("id: "+id);
            System.out.println("name: "+name);
            System.out.println("salary: "+salary);
            System.out.println("email: "+email);

            //Alter
            System.out.println("Enter a column name:");
            String address=br.readLine();

            String alter="alter table employee add column" + address + " VARCHAR(100)";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(alter);
            System.out.println("Column added successfully.");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}