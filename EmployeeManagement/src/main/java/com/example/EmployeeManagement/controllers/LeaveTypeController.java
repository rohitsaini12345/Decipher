package com.example.EmployeeManagement.controllers;

import com.example.EmployeeManagement.entity.LeaveType;
import com.example.EmployeeManagement.payloads.ApiResponse;
import com.example.EmployeeManagement.payloads.LeaveTypeDto;
import com.example.EmployeeManagement.service.LeaveTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaveType")
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<LeaveTypeDto> createLeaveType(@Valid @RequestBody LeaveTypeDto leaveTypeDto){
        return new ResponseEntity<>(leaveTypeService.createLeaveType(leaveTypeDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @GetMapping("/get/leaveTypeId/{leaveTypeId}")
    public ResponseEntity<LeaveTypeDto> getLeaveTypeById(@PathVariable String leaveTypeId){
        return new ResponseEntity<>(leaveTypeService.getLeaveTypeById(leaveTypeId),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @GetMapping("/all")
    public ResponseEntity<List<LeaveTypeDto>> getAllLeaveType(){
        return new ResponseEntity<>(leaveTypeService.getAllLeaveType(),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{leaveTypeId}")
    public ResponseEntity<LeaveTypeDto> updateLeaveType(@PathVariable String leaveTypeId,
                                                     @RequestBody LeaveTypeDto leaveTypeDto){
        return new ResponseEntity<>(leaveTypeService.updateLeaveType(leaveTypeId,leaveTypeDto),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{leaveTypeId}")
    public ResponseEntity<ApiResponse> deleteLeaveType(@PathVariable String leaveTypeId){
        leaveTypeService.deleteLeaveType(leaveTypeId);
        return new ResponseEntity<>(new ApiResponse("leave type deleted successfully",true),HttpStatus.OK);
    }
}
