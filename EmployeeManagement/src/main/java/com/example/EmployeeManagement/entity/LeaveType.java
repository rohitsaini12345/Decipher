package com.example.EmployeeManagement.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leave_types")
@Getter
@Setter
public class LeaveType {
    @Id
    private String leaveTypeId;
    private String nameOfLeave;
    private int maxDaysPerYear;
    private boolean carryForward;
    //private String employeeId;
}
