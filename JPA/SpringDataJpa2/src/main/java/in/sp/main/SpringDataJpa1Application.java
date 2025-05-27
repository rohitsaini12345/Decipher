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
		
		// select operation by id
		
		Student std=stdService.getStdDetails(1L);
		
		if(std!=null) {
		System.out.println("Id :"+std.getId());
		System.out.println("Name :"+std.getName());
		System.out.println("Rollno :"+std.getRollno());
		System.out.println("Marks :"+std.getMarks());
	}
		else {
			System.out.println("student not found");
			}
		
		}
	

}
