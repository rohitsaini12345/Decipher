package com.example.EmployeeManagement.controllers;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.payloads.ApiResponse;
import com.example.EmployeeManagement.payloads.EmployeeDto;
import com.example.EmployeeManagement.payloads.EmployeeResponse;
import com.example.EmployeeManagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> register(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.register(employeeDto),HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable String employeeId){
        return new ResponseEntity<>(employeeService.getById(employeeId),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<EmployeeResponse>getAll(@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
                                                  @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize,
                                                  @RequestParam(value = "sortBy",defaultValue = "employeeId",required = false) String sortBy,
                                                  @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir){
        return new ResponseEntity<>(employeeService.getAll(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @PutMapping("/update/{employeeId}")
    public ResponseEntity<EmployeeDto> update(@PathVariable String employeeId, @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.update(employeeId, employeeDto),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable String employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(new ApiResponse("employee deleted successfully",true), HttpStatus.OK);
    }
}
