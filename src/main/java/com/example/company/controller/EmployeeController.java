package com.example.company.controller;
import com.example.company.model.Employee;
import com.example.company.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {


    private static final Long EMPTY_ID = null;
    private final EmployeeService employeeService;

    @Operation(summary = "pobieranie listy pracowników")
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @Operation(summary = "pobieranie pracownika po id")
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@Parameter(description = "id of employee to be searched")@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @Operation(summary = "dodaj pracownika")
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @Operation(summary = "zmodyfikuj pracownika po id")
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @Operation(summary = "usun pracownika po id")
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
         employeeService.deleteEmployee(id);
    }
}
