package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.LeaveBalance;
import com.example.EmployeeManagement.payloads.LeaveBalanceDto;

import java.time.LocalDate;
import java.util.List;

public interface LeaveBalanceService {

    LeaveBalanceDto createLeaveBalance(String employeeId, String leaveTypeId, LeaveBalanceDto leaveBalanceDto);

    LeaveBalanceDto getLeaveBalance(String employeeId, String leaveTypeId);

    void deductLeaveBalance(String employeeId, String leaveTypeId, LocalDate startDate,LocalDate endDate);

    List<LeaveBalanceDto> getLeaveBalanceByEmployeeId(String employeeId);
}
