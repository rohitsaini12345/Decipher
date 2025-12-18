package com.example.EmployeeManagement.controllers;

import com.example.EmployeeManagement.entity.LeaveBalance;
import com.example.EmployeeManagement.payloads.ApiResponse;
import com.example.EmployeeManagement.payloads.LeaveBalanceDto;
import com.example.EmployeeManagement.service.LeaveBalanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leaveBalance")
public class LeaveBalanceController {

    private final LeaveBalanceService leaveBalanceService;

    public LeaveBalanceController(LeaveBalanceService leaveBalanceService) {
        this.leaveBalanceService = leaveBalanceService;
    }
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @PostMapping("/create/employeeId/{employeeId}/leaveTypeId/{leaveTypeId}")
    public ResponseEntity<LeaveBalanceDto> createLeaveBalance(@PathVariable String employeeId,
                                                           @PathVariable String leaveTypeId,
                                                           @RequestBody LeaveBalanceDto leaveBalanceDto){
        return  new ResponseEntity<>(leaveBalanceService.createLeaveBalance(employeeId, leaveTypeId, leaveBalanceDto),HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @GetMapping("/get/employeeId/{employeeId}/leaveTypeId/{leaveTypeId}")
    public ResponseEntity<LeaveBalanceDto>getLeaveBalance(@PathVariable String employeeId, @PathVariable String leaveTypeId){
        return new ResponseEntity<>(leaveBalanceService.getLeaveBalance(employeeId,leaveTypeId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @PostMapping("/deduct/employeeId/{employeeId}/leaveTypeId/{leaveTypeId}")
    public ResponseEntity<ApiResponse> deductLeaveBalance(@PathVariable String employeeId,@PathVariable String leaveTypeId, @RequestParam LocalDate startDate,@RequestParam LocalDate endDate){
        leaveBalanceService.deductLeaveBalance(employeeId, leaveTypeId,startDate,endDate);
        return new ResponseEntity<>(new ApiResponse("leaves deduct successfully",true),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @GetMapping("/get/employeeId/{employeeId}")
    public ResponseEntity<List<LeaveBalanceDto>> getLeaveBalanceByEmployeeId(@PathVariable String employeeId){
        return new ResponseEntity<>(leaveBalanceService.getLeaveBalanceByEmployeeId(employeeId),HttpStatus.OK);
    }

}
