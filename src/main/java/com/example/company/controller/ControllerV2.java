package com.example.company.controller;

import com.example.company.model.Employee;
import com.example.company.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControllerV2 {

    private final EmployeeService employeeService;

    public ControllerV2(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getEmployees();  // pobieramy wszystkich pracowników
        model.addAttribute("allEmployees", allEmployees);      // tworzymy model i do tego modelu dodajemy tych wszystkich pracownikow
        return "gui";  // i to wszystko trafia na gui
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {  // dzieki tej adnotacji jestesmy w stanie pobrac z pliku gui
        employeeService.createEmployee(employee);
        return "redirect:/";
    }

}
