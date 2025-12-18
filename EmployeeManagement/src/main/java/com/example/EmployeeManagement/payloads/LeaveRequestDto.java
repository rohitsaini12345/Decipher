package com.example.EmployeeManagement.payloads;

import com.example.EmployeeManagement.entity.LeaveStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LeaveRequestDto {
    private String leaveRequestId;

    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private LeaveStatus status;
    private String employeeId;

    private String leaveTypeId;
}
