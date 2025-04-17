import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url= "jdbc:mysql://localhost:3306/college";
        String user="root";
        String password="root";
        try{
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connection
            Connection con= DriverManager.getConnection(url,user,password);

            //insert
            String insertQuery="insert into student(serial_no,name,phone_no,branch,section,city)values(?,?,?,?,?,?)";
            PreparedStatement pst= con.prepareStatement(insertQuery);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter a details: ");

            System.out.println("enter serial_no:");
            int serial_no=Integer.parseInt(br.readLine());
            System.out.println("enter name:");
            String name=br.readLine();
            System.out.println("phone_no");
            String phone_no=br.readLine();
            System.out.println("branch");
            String branch=br.readLine();
            System.out.println("section");
            String section=br.readLine();
            System.out.println("city");
            String city=br.readLine();

            pst.setInt(1,serial_no);
            pst.setString(2,name);
            pst.setString(3,phone_no);
            pst.setString(4,branch);
            pst.setString(5,section);
            pst.setString(6,city);

            pst.executeUpdate();

            //retrive records
            String query="select * from student";
            ResultSet rst=con.prepareStatement(query).executeQuery();

            System.out.println("All students list: ");
            while (rst.next()){


                System.out.println("serial_no: "+serial_no);
                System.out.println("name: "+name);
                System.out.println("Phone: "+phone_no);
                System.out.println("branch: "+branch);
                System.out.println("section: "+section);
                System.out.println("city: "+city);
                System.out.println("------------");
            }

            //for delete
            String q="delete from student where serial_no=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1,serial_no);


            pst.close();
            rst.close();
            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}