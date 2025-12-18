package com.example.EmployeeManagement.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveTypeDto {
    private String leaveTypeId;
    private String nameOfLeave;
    private int maxDaysPerYear;
    private boolean carryForward;
}
