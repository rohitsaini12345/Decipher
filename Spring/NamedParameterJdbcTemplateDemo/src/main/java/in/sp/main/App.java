package in.sp.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import in.sp.resources.SpringConfigFile;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfigFile.class);
        
        NamedParameterJdbcTemplate npJdbcTemplate=context.getBean(NamedParameterJdbcTemplate.class);
        
        Map<String,Object>map=new HashMap<String,Object>();
        map.put("Key_rollno",103);
        map.put("Key_name","Rahul");
        map.put("Key_marks",89.4);
        
        String insert_sql_query="insert into Student values(:Key_rollno,:Key_name,:Key_marks)";
        
       int count= npJdbcTemplate.update(insert_sql_query, map);
        if(count>0)
        {
        	System.out.println("insertion success");
        }
        else {
        	System.out.println("insertion failed");
        }
        
    }
}
