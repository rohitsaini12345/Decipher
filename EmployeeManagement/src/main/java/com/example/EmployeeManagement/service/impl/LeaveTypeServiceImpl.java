package com.example.EmployeeManagement.service.impl;

import com.example.EmployeeManagement.ExceptionHandler.ResourceNotFoundException;
import com.example.EmployeeManagement.entity.LeaveType;
import com.example.EmployeeManagement.payloads.LeaveTypeDto;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.repository.LeaveTypeRepository;
import com.example.EmployeeManagement.service.LeaveTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
    private final LeaveTypeRepository leaveTypeRepository;
    private final ModelMapper modelMapper;

    public LeaveTypeServiceImpl(LeaveTypeRepository leaveTypeRepository, ModelMapper modelMapper) {

        this.leaveTypeRepository = leaveTypeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LeaveTypeDto createLeaveType(LeaveTypeDto leaveTypeDto) {
        LeaveType leaveType=modelMapper.map(leaveTypeDto,LeaveType.class);
        LeaveType createdLeaveType= leaveTypeRepository.save(leaveType);
        return modelMapper.map(createdLeaveType,LeaveTypeDto.class);
    }

    @Override
    public LeaveTypeDto getLeaveTypeById(String leaveTypeId) {
        LeaveType getLeaveType= leaveTypeRepository.findById(leaveTypeId).orElseThrow(()->new ResourceNotFoundException("LeaveType","leaveTypeId",leaveTypeId));
        return modelMapper.map(getLeaveType,LeaveTypeDto.class);
    }

    @Override
    public List<LeaveTypeDto> getAllLeaveType() {
        return leaveTypeRepository.findAll().stream().map((allLeaveType)->modelMapper.map(allLeaveType,LeaveTypeDto.class)).collect(Collectors.toList());
    }

    @Override
    public LeaveTypeDto updateLeaveType(String leaveTypeId, LeaveTypeDto leaveTypeDto) {
        LeaveType leaveType1=leaveTypeRepository.findById(leaveTypeId).orElseThrow(()->new ResourceNotFoundException("LeaveType","leaveTypeId",leaveTypeId));
        leaveType1.setNameOfLeave(leaveTypeDto.getNameOfLeave());
        leaveType1.setMaxDaysPerYear(leaveTypeDto.getMaxDaysPerYear());
        leaveType1.setCarryForward(leaveTypeDto.isCarryForward());

        LeaveType updatedLeaveType= leaveTypeRepository.save(leaveType1);
        return modelMapper.map(updatedLeaveType,LeaveTypeDto.class);
    }

    @Override
    public void deleteLeaveType(String leaveTypeId) {
        LeaveType leaveType=leaveTypeRepository.findById(leaveTypeId).orElseThrow(()->new ResourceNotFoundException("LeaveType","leaveTypeId",leaveTypeId));
        leaveTypeRepository.delete(leaveType);
    }
}
