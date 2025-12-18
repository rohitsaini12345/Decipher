package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.LeaveRequest;
import com.example.EmployeeManagement.entity.LeaveStatus;
import com.example.EmployeeManagement.payloads.LeaveRequestDto;
import com.example.EmployeeManagement.payloads.LeaveRequestResponse;

import java.util.List;

public interface LeaveRequestService {

    LeaveRequestDto applyLeave(String employeeId,String leaveTypeId, LeaveRequestDto leaveRequestDto);

    List<LeaveRequestDto> getByEmployeeId(String employeeId);

    LeaveRequestDto updateStatus(String leaveRequestId, LeaveStatus status);

    LeaveRequestResponse getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    LeaveRequestDto updateLeave(String leaveRequestId, LeaveRequestDto leaveRequestDto);

    void deleteLeave(String leaveRequestId);
}

