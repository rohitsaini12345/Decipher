package in.sp.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.beans.Address;
import in.sp.beans.Student;

@Configuration
public class SpringConfigFile {
	
	@Bean
	public Address createAddrObj() {
		Address addr=new Address();
		
		addr.setHouseno(100);
		addr.setCity("Jaipur");
		addr.setPincode(302022);
		
		return addr;
	}
	
	@Bean
	public Student createStdObj() {
		Student std=new Student();
		
		std.setName("Rohit");
		std.setRollno(101);
		//std.setAddress(createAddrObj());
		
		return std;
	}
}
