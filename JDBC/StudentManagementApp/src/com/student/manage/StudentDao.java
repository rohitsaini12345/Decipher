package com.student.manage;

import java.sql.*;

public class StudentDao {
    public static  boolean insertStudentToDB(Student st){
        boolean f=false;
        try{
            //jdbc code
            Connection con=CP.createC();
            String q="insert into student values(?,?,?,?)";

            //prepared statement
            PreparedStatement pstmt=con.prepareStatement(q);

            //set values of parameter
            pstmt.setInt(1,st.getStudent_Id());
            pstmt.setString(2, st.getStudent_Name());
            pstmt.setString(3,st.getStudent_Phoneno());
            pstmt.setString(4,st.getStudent_City());

            //execute
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {
        boolean f=false;
        try{
            //jdbc code
            Connection con=CP.createC();
            String q="delete from student where id=?";

            //prepared statement
            PreparedStatement pstmt=con.prepareStatement(q);

            //set values of parameter
            pstmt.setInt(1,userId);

            //execute
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void showAllStudents() {
        boolean f=false;
        try{
            //jdbc code
            Connection con=CP.createC();
            String q="select * from student";
            //statement
            Statement stmt=con.createStatement();

            //execute
            ResultSet set=stmt.executeQuery(q);
            while (set.next()){
                int id=set.getInt(1);
                String name=set.getString(2);
                String phoneno=set.getString(3);
                String city=set.getString(4);

                System.out.println("Id: "+id);
                System.out.println("name: "+name);
                System.out.println("Phone: "+phoneno);
                System.out.println("city: "+city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
