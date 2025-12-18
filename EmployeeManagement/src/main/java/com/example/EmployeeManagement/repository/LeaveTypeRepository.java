package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.LeaveType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeaveTypeRepository extends MongoRepository<LeaveType,String> {
}
