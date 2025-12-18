package com.example.EmployeeManagement.service.impl;

import com.example.EmployeeManagement.ExceptionHandler.ResourceNotFoundException;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.payloads.EmployeeDto;
import com.example.EmployeeManagement.payloads.EmployeeResponse;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto register(EmployeeDto employeeDto){
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        if (employeeRepository.existsByEmailOrPasswordOrPhoneNumber(employee.getEmail(),employee.getPassword(),employee.getPhoneNumber())){
            throw new RuntimeException("please check that employee with one of them email,password,phoneNumber already exists " + employee.getEmail()+"/"+employee.getPassword()+"/"+employee.getPhoneNumber());
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Employee newEmployee= employeeRepository.save(employee);
        return modelMapper.map(newEmployee,EmployeeDto.class);
    }
    @Override
    public EmployeeDto getById(String employeeId){

        Employee employee= employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee","employeeId",employeeId));
        return modelMapper.map(employee,EmployeeDto.class);
    }
    @Override
    public EmployeeResponse getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort=null;
        if (sortDir.equalsIgnoreCase("asc")){
            sort=Sort.by(sortBy).ascending();
        }else {
            sort=Sort.by(sortBy).descending();
        }

        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<Employee> employeePage=employeeRepository.findAll(pageable);

        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setContent(employeePage.getContent());
        employeeResponse.setPageNumber(employeePage.getNumber());
        employeeResponse.setPageSize(employeePage.getSize());
        employeeResponse.setTotalElements(employeePage.getTotalElements());
        employeeResponse.setTotalPages(employeePage.getTotalPages());
        employeeResponse.setLastPage(employeePage.isLast());

        return employeeResponse;

    }
    @Override
    public EmployeeDto update(String employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee","employeeId",employeeId));
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setGender(employeeDto.getGender());

        Employee employee1= employeeRepository.save(employee);
        return modelMapper.map(employee1,EmployeeDto.class);
    }
    @Override
    public void deleteEmployee(String employeeId) {
        Employee emp=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee","employeeId",employeeId));
        employeeRepository.delete(emp);
    }

}
