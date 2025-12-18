package com.example.EmployeeManagement.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveBalanceDto {
    private String leaveBalanceId;
    private String employeeId;
    private String leaveTypeId;
    private int totalAllocated;
    private int used;
    private int remaining;
}
