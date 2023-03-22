package com.example.company.controller;
import com.example.company.model.Employee;
import com.example.company.model.EmployeeDto;
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

    @Operation(summary = "to jest endpoint")
    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@Parameter(description = "id of employee to be searched")@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(new Employee(
                EMPTY_ID,
                employeeDto.getName(),
                employeeDto.getSurname(),
                employeeDto.getAddress()
        ));
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(new Employee(
                EMPTY_ID,
                employeeDto.getName(),
                employeeDto.getSurname(),
                employeeDto.getAddress()
        ));
    }
    @DeleteMapping("/employees/{id}")
   // @RequestMapping(value = "employes/{id}", method = RequestMethod.DELETE ) dokładnie to samo co powyższe
    public void deleteEmployee(@PathVariable Long id){
         employeeService.deleteEmployee(id);
    }


}
