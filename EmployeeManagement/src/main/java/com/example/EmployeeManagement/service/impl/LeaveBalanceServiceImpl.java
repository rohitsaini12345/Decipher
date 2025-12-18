package com.example.EmployeeManagement.service.impl;

import com.example.EmployeeManagement.ExceptionHandler.ResourceNotFoundException;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.entity.LeaveBalance;
import com.example.EmployeeManagement.entity.LeaveType;
import com.example.EmployeeManagement.payloads.LeaveBalanceDto;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.repository.LeaveBalanceRepository;
import com.example.EmployeeManagement.repository.LeaveTypeRepository;
import com.example.EmployeeManagement.service.LeaveBalanceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

    private final LeaveBalanceRepository leaveBalanceRepository;
    private final EmployeeRepository employeeRepository;
    private final LeaveTypeRepository leaveTypeRepository;
    private final ModelMapper modelMapper;

    public LeaveBalanceServiceImpl(LeaveBalanceRepository leaveBalanceRepository, EmployeeRepository employeeRepository, LeaveTypeRepository leaveTypeRepository, ModelMapper modelMapper) {
        this.leaveBalanceRepository = leaveBalanceRepository;

        this.employeeRepository = employeeRepository;
        this.leaveTypeRepository = leaveTypeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LeaveBalanceDto createLeaveBalance(String employeeId, String leaveTypeId,LeaveBalanceDto leaveBalanceDto) {
        Employee employee1=employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","employeeId",employeeId));
        LeaveType leaveType1=leaveTypeRepository.findById(leaveTypeId)
                .orElseThrow(()->new ResourceNotFoundException("LeaveType","leaveTypeId",leaveTypeId));

        if (leaveBalanceRepository.existsByEmployeeIdAndLeaveTypeId(leaveBalanceDto.getEmployeeId(),leaveBalanceDto.getLeaveTypeId())){
            throw new RuntimeException("employee exist with employeeId and leaveTypeId"+leaveBalanceDto.getEmployeeId()+leaveBalanceDto.getLeaveTypeId());
        }

        LeaveBalance balance=modelMapper.map(leaveBalanceDto,LeaveBalance.class);
        balance.setEmployeeId(employee1.getEmployeeId());
        balance.setLeaveTypeId(leaveType1.getLeaveTypeId());
        balance.setRemaining(balance.getTotalAllocated()- balance.getUsed());
        LeaveBalance createLeaveBalance= leaveBalanceRepository.save(balance);
        return modelMapper.map(createLeaveBalance,LeaveBalanceDto.class);
    }

    @Override
    public LeaveBalanceDto getLeaveBalance(String employeeId, String leaveTypeId) {
        LeaveBalance balance= leaveBalanceRepository.findByEmployeeIdAndLeaveTypeId(employeeId,leaveTypeId).
                orElseThrow(()->new ResourceNotFoundException("LeaveBalance","employeeId and leaveTypeId combination",employeeId+"/"+leaveTypeId));
        return modelMapper.map(balance,LeaveBalanceDto.class);
    }

    @Override
    public void deductLeaveBalance(String employeeId, String leaveTypeId, LocalDate startDate, LocalDate endDate) {
        employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee","employeeId",employeeId));
        leaveTypeRepository.findById(leaveTypeId).orElseThrow(()->new ResourceNotFoundException("LeaveType","leaveTypeId",leaveTypeId));
        Optional<LeaveBalance> balanceOpt = leaveBalanceRepository
            .findByEmployeeIdAndLeaveTypeId(employeeId, leaveTypeId);

        LeaveBalance balanceEntity = balanceOpt.orElseThrow(() ->
                new ResourceNotFoundException("LeaveBalance","employeeId and leaveTypeId combination",employeeId+"/"+leaveTypeId));

        long daysTaken = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        if (balanceEntity.getUsed() + daysTaken <= balanceEntity.getTotalAllocated()) {
           balanceEntity.setUsed(balanceEntity.getUsed() + (int) daysTaken);
           balanceEntity.setRemaining(balanceEntity.getTotalAllocated()- balanceEntity.getUsed());
           leaveBalanceRepository.save(balanceEntity);
        } else {
            throw new RuntimeException("Insufficient leave balance");
        }
    }

    @Override
    public List<LeaveBalanceDto> getLeaveBalanceByEmployeeId(String employeeId) {
        List<LeaveBalance> leaveBalanceList= leaveBalanceRepository.findByEmployeeId(employeeId);
        if (leaveBalanceList==null || leaveBalanceList.isEmpty()){
            throw new ResourceNotFoundException("LeaveBalance","employeeId",employeeId);
        }
        return leaveBalanceList.stream().map((balance)->modelMapper.map(balance,LeaveBalanceDto.class)).collect(Collectors.toList());
    }
}
