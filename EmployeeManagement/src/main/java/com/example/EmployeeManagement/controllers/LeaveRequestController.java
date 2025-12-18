package com.example.EmployeeManagement.controllers;

import com.example.EmployeeManagement.entity.LeaveRequest;
import com.example.EmployeeManagement.entity.LeaveStatus;
import com.example.EmployeeManagement.payloads.ApiResponse;
import com.example.EmployeeManagement.payloads.LeaveRequestDto;
import com.example.EmployeeManagement.payloads.LeaveRequestResponse;
import com.example.EmployeeManagement.service.LeaveRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/leave")

public class LeaveRequestController {

    private final LeaveRequestService leaveService;

    public LeaveRequestController(LeaveRequestService leaveService) {
        this.leaveService = leaveService;
    }

    @PreAuthorize("hasAnyRole('ADMIN',EMPLOYEE)")
    @PostMapping("/apply/{employeeId}/{leaveTypeId}")
    public ResponseEntity<LeaveRequestDto> applyLeave(@PathVariable String employeeId,
                                                   @PathVariable String leaveTypeId,
                                                   @Valid @RequestBody LeaveRequestDto leaveRequestDto) {
        return new ResponseEntity<>(leaveService.applyLeave(employeeId,leaveTypeId, leaveRequestDto), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<List<LeaveRequestDto>> getMyLeaves(@PathVariable String employeeId) {
        return new ResponseEntity<>(leaveService.getByEmployeeId(employeeId),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<LeaveRequestResponse> allLeaves(@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
                                                          @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize,
                                                          @RequestParam(value = "sortBy",defaultValue = "employeeId",required = false) String sortBy,
                                                          @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir) {
        return new ResponseEntity<>(leaveService.getAll(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/status/{leaveId}")
    public ResponseEntity<LeaveRequestDto> updateStatus(@PathVariable String leaveId,
                                                        @RequestParam LeaveStatus status) {
        return new ResponseEntity<>(leaveService.updateStatus(leaveId, status),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @PutMapping("/update/id/{leaveId}")
    public ResponseEntity<LeaveRequestDto> updateLeave(@PathVariable String leaveId,
                                                    @RequestBody LeaveRequestDto leaveRequestDto){
        return new ResponseEntity<>(leaveService.updateLeave(leaveId,leaveRequestDto),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<ApiResponse> deleteLeave(@PathVariable String leaveId){
        leaveService.deleteLeave(leaveId);
        return new ResponseEntity<>(new ApiResponse("Leave deleted successfully",true),HttpStatus.OK);
    }
}

