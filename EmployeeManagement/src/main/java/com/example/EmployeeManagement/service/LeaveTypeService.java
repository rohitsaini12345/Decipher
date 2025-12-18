package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.LeaveType;
import com.example.EmployeeManagement.payloads.LeaveTypeDto;

import java.util.List;

public interface LeaveTypeService {
    LeaveTypeDto createLeaveType(LeaveTypeDto leaveTypeDto);

    LeaveTypeDto getLeaveTypeById(String leaveTypeId);

    List<LeaveTypeDto> getAllLeaveType();

    LeaveTypeDto updateLeaveType(String leaveTypeId, LeaveTypeDto leaveTypeDto);

    void deleteLeaveType(String leaveTypeId);
}
