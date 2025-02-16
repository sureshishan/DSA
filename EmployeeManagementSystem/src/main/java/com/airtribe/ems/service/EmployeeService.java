package com.airtribe.ems.service;

import com.airtribe.ems.entity.Department;
import com.airtribe.ems.entity.Employee;
import com.airtribe.ems.entity.Project;
import com.airtribe.ems.exception.ResourceNotFoundException;
import com.airtribe.ems.repository.DepartmentRepository;
import com.airtribe.ems.repository.EmployeeRepository;
import com.airtribe.ems.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) throws ResourceNotFoundException {

        Department department = departmentRepository
                .findById(employee.getDepartment().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id:" + employee.getDepartment().getId()));
        employee.setDepartment(department);
        Set<Project> projects = new HashSet<>();
        for (Project project : employee.getProjects()) {
            Project foundProject = projectRepository
                    .findById(project.getId()).orElseThrow(() -> new ResourceNotFoundException("Project not found with id:" + project.getId()));
            projects.add(foundProject);
        }
        employee.setProjects(projects);
        return employeeRepository.save(employee);
    }

}
