package in.smartprogramming.SpringjdbcCrudOperation;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import in.sp.beans.Student;
import in.sp.mappers.StudentRowMapper;
import in.sp.resources.SpringConfigFile;

public class App 
{
    public static void main( String[] args )
    {
    	
     ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfigFile.class);
     
     JdbcTemplate jdbcTemplate=context.getBean(JdbcTemplate.class);
     
     //insert
 	/*int rollno=102;
	String name="Rohan";
	float marks=90.4f;
     String insert_sql_query="insert into student values(?,?,?)";
     int count=jdbcTemplate.update(insert_sql_query,rollno,name,marks);
     
     if(count>0) {
    	 System.out.println("insertion success");
     }
     else {
    	 System.out.println("insertion failed");
     }
     */
     
     //update
     /*float marks=98.1f;
     int rollno=101;
     String update_sql_query="update student set marks=? where rollno=?";
     int count=jdbcTemplate.update(update_sql_query,marks,rollno);
     
     if(count>0) {
    	 System.out.println("updation success");
     }
     else {
    	 System.out.println("updation failed");
     }
     */
     
     String select_sql_query="select * from student";
     List<Student> std_list=jdbcTemplate.query(select_sql_query, new StudentRowMapper());
     
     for(Student std:std_list) {
    	 System.out.println("Rollno: "+std.getRollno());
    	 System.out.println("Name: "+std.getName());
    	 System.out.println("Marks: "+std.getMarks());
    	 System.out.println("---------------------");
     }
     
    }
}
