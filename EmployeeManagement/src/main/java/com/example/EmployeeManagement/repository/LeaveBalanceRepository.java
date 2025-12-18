package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.LeaveBalance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LeaveBalanceRepository extends MongoRepository<LeaveBalance,String> {
    Optional<LeaveBalance> findByEmployeeIdAndLeaveTypeId(String employeeId,String leaveTypeId);

    List<LeaveBalance> findByEmployeeId(String employeeId);

    boolean existsByEmployeeIdAndLeaveTypeId(String employeeId,String leaveTypeId);

}
