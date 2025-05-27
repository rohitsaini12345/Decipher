package in.sp.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.beans.Student;

@Configuration
public class SpringConfigFile {
	@Bean
	public Student stdId() {
		Student std=new Student();
		
		std.setName("Nakash");
		std.setRollno(102);
		std.setEmail("ash@gmail.com");
		
		return std;
	}
}
