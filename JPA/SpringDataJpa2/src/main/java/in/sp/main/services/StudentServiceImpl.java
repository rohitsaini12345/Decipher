package in.sp.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.Student;
import in.sp.main.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	/*@Override
	public boolean addStudentDetails(Student std) {
	
		boolean status = false;
		try {
			studentRepository.save(std);
			status=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		
		return status;
	}
	*/
	
	@Override
	public List<Student>getAllStudent(){
		
		return studentRepository.findAll();
	}
	
	@Override
	public Student getStdDetails(long id) {
		
		Optional<Student> optional=studentRepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	
}
