package com.example.EmployeeManagement.service.impl;

import com.example.EmployeeManagement.ExceptionHandler.ResourceNotFoundException;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.entity.LeaveRequest;
import com.example.EmployeeManagement.entity.LeaveStatus;
import com.example.EmployeeManagement.entity.LeaveType;
import com.example.EmployeeManagement.payloads.LeaveRequestDto;
import com.example.EmployeeManagement.payloads.LeaveRequestResponse;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.repository.LeaveRequestRepository;
import com.example.EmployeeManagement.repository.LeaveTypeRepository;
import com.example.EmployeeManagement.service.LeaveRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRepository;
    private final EmployeeRepository employeeRepository;
    private final LeaveTypeRepository leaveTypeRepository;
    private final ModelMapper modelMapper;


    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRepository, EmployeeRepository employeeRepository, LeaveTypeRepository leaveTypeRepository, ModelMapper modelMapper) {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
        this.leaveTypeRepository = leaveTypeRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public LeaveRequestDto applyLeave(String employeeId, String leaveTypeId,LeaveRequestDto leaveRequestDto) {
        Employee employee1=employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","employeeId",employeeId));
        LeaveType leaveType1=leaveTypeRepository.findById(leaveTypeId)
                .orElseThrow(()->new ResourceNotFoundException("LeaveType","leaveTypeId",leaveTypeId));

        if (leaveRepository.existsByEmployeeIdAndLeaveTypeIdAndStartDate(
                employeeId,
                leaveTypeId,
                leaveRequestDto.getStartDate())) {
           throw new IllegalStateException("you have already applied for this date");
        }
        LeaveRequest leaveRequest=modelMapper.map(leaveRequestDto,LeaveRequest.class);
        leaveRequest.setEmployeeId(employee1.getEmployeeId());
        leaveRequest.setLeaveTypeId(leaveType1.getLeaveTypeId());
        leaveRequest.setStatus(LeaveStatus.PENDING);

        LeaveRequest applyLeaveRequest=leaveRepository.save(leaveRequest);
        return modelMapper.map(applyLeaveRequest,LeaveRequestDto.class);
    }

    @Override
    public List<LeaveRequestDto> getByEmployeeId(String employeeId) {
        List<LeaveRequest> leaveRequests= leaveRepository.findByEmployeeId(employeeId);
        if (leaveRequests==null|| leaveRequests.isEmpty()){
            throw new ResourceNotFoundException("LeaveRequest","employeeId",employeeId);
        }
        return leaveRequests.stream().map((request)->modelMapper.map(request,LeaveRequestDto.class)).collect(Collectors.toList());
    }

    @Override
    public LeaveRequestResponse getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort=null;
        if (sortDir.equalsIgnoreCase("asc")){
            sort=Sort.by(sortBy).ascending();
        }else {
            sort=Sort.by(sortBy).descending();
        }

        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<LeaveRequest> leavePage=leaveRepository.findAll(pageable);

        LeaveRequestResponse leaveResponse=new LeaveRequestResponse();
        leaveResponse.setContent(leavePage.getContent());
        leaveResponse.setPageNumber(leavePage.getNumber());
        leaveResponse.setPageSize(leavePage.getSize());
        leaveResponse.setTotalElements(leavePage.getTotalElements());
        leaveResponse.setTotalPages(leavePage.getTotalPages());
        leaveResponse.setLastPage(leavePage.isLast());

        return leaveResponse;
    }

    @Override
    public LeaveRequestDto updateStatus(String leaveRequestId, LeaveStatus status) {
        LeaveRequest leave = leaveRepository.findById(leaveRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveRequest","leaveRequestId",leaveRequestId));

        leave.setStatus(status);
        LeaveRequest statusLeaveRequest= leaveRepository.save(leave);
        return modelMapper.map(statusLeaveRequest,LeaveRequestDto.class);
    }

    @Override
    public LeaveRequestDto updateLeave(String leaveRequestId, LeaveRequestDto leaveRequestDto) {
        LeaveRequest leave1 = leaveRepository.findById(leaveRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveRequest","leaveRequestId",leaveRequestId));

            leave1.setStartDate(leaveRequestDto.getStartDate());
            leave1.setEndDate(leaveRequestDto.getEndDate());
            leave1.setReason(leaveRequestDto.getReason());
        LeaveRequest updatedLeaveRequest= leaveRepository.save(leave1);
        return modelMapper.map(updatedLeaveRequest,LeaveRequestDto.class);
    }

    @Override
    public void deleteLeave(String leaveRequestId) {
        LeaveRequest request=leaveRepository.findById(leaveRequestId).orElseThrow(()->new ResourceNotFoundException("LeaveRequest","leaveRequestId",leaveRequestId));
        leaveRepository.delete(request);
    }
}
