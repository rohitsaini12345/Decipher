package com.example.EmployeeManagement.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document(collection = "leaves")
@Getter
@Setter
public class LeaveRequest {
    @Id
    private String leaveRequestId;

    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private LeaveStatus status;
    private String employeeId;

    private String leaveTypeId;
}
