package com.slavamashkov.spring.rest.controller;

import com.slavamashkov.spring.rest.entity.Employee;
import com.slavamashkov.spring.rest.exception_handling.EmployeeIncorrectData;
import com.slavamashkov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.slavamashkov.spring.rest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    private final EmployeeService employeeService;

    @Autowired
    public MyRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if(employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in Database");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }
}
