package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
     boolean existsByEmailOrPasswordOrPhoneNumber(String email,String password,String phoneNumber);
     Optional<Employee> findByEmail(String email);
}
