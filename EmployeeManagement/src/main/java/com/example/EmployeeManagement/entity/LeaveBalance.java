package com.example.EmployeeManagement.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leave_balances")
@Getter
@Setter
public class LeaveBalance {
    @Id
    private String leaveBalanceId;
    private String employeeId;
    private String leaveTypeId;
    private int totalAllocated;
    private int used;
    private int remaining;


}
