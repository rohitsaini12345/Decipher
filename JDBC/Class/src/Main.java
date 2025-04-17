import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
           String insert ="insert into class(id,name,year,branch) values (?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(insert);

            System.out.println("Enter values");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("id");
            int id=Integer.parseInt(br.readLine());

            System.out.println("name");
            String name=br.readLine();

            System.out.println("year");
            String year=br.readLine();

            System.out.println("branch");
            String branch=br.readLine();

            pst.setInt(1,id);
            pst.setString(2,name);
            pst.setString(3,year);
            pst.setString(4,branch);

            pst.executeUpdate();

            //retrieve
            String query="select * from class";
            ResultSet rst=con.prepareStatement(query).executeQuery();


                System.out.println("id: "+id);
                System.out.println("name: "+name);
                System.out.println("year: "+year);
                System.out.println("branch: "+branch);

              //delete
                 System.out.println("name for delete:");
                 String delName = br.readLine();

                 String del = "delete from class where name=?";
                PreparedStatement ps = con.prepareStatement(del);
                ps.setString(1, delName);
                ps.executeUpdate();
                System.out.println("Deleted records where name = " + delName);

                //update
            System.out.println("Enter name to update:");
            String updateName = br.readLine();

            System.out.println("Enter id:");
            String newid = br.readLine();

            String update = "UPDATE class SET name=? WHERE id=?";
            PreparedStatement p = con.prepareStatement(update);
            p.setString(1, newid);
            p.setString(2, updateName);

            ps.executeUpdate();

            con.close();
            pst.close();
            ps.close();
            rst.close();
            p.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}