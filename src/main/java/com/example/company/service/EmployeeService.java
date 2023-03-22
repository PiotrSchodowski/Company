package com.example.company.service;
import com.example.company.mapper.EmployeeDto;
import com.example.company.model.Employee;
import com.example.company.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    private EmployeeDto employeeDto;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).orElseThrow();
    }

    public EmployeeDto getEmployeeDto(Long id){
        employeeDto = modelMapper.map(employeeRepository.findById(id).orElseThrow(), EmployeeDto.class);
        return employeeDto;
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
         employeeRepository.deleteById(id);
    }


}
