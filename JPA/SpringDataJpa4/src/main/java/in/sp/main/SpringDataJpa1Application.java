package in.sp.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entities.Student;
import in.sp.main.services.StudentService;
import in.sp.main.services.StudentServiceImpl;

@SpringBootApplication
public class SpringDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpa1Application.class, args);
		
		StudentService stdService=context.getBean(StudentService.class);
		
	
	
	//delete operation
	boolean status=stdService.deleteStdDetails(2L);
	if(status) {
		System.out.println("student deleted successfully");
	}
	else {
		System.out.println("student not deleted successfully");
	}
	
 }
}
