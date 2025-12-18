package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.payloads.EmployeeDto;
import com.example.EmployeeManagement.payloads.EmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

     EmployeeDto register(EmployeeDto employeeDto);

     EmployeeDto getById(String employeeId);

     EmployeeResponse getAll(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);

     EmployeeDto update(String employeeId, EmployeeDto employeeDto);

     void deleteEmployee(String employeeId);
}
