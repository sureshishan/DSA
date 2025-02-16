package com.airtribe.ems.controller;

import com.airtribe.ems.entity.Employee;
import com.airtribe.ems.exception.ResourceNotFoundException;
import com.airtribe.ems.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) throws ResourceNotFoundException {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }
}
