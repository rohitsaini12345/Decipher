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
	

	@Override
	public boolean deleteStdDetails(long id) {
		
		boolean status=false;
		try {
			studentRepository.deleteById(id);
			status=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}

	
}
