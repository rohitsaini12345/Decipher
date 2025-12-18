package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.LeaveRequest;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRequestRepository extends MongoRepository<LeaveRequest, String> {

    List<LeaveRequest> findByEmployeeId(String employeeId);
    boolean existsByEmployeeIdAndLeaveTypeIdAndStartDate(String employeeId, String leaveTypeId, LocalDate startDate);
}

