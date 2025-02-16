package com.airtribe.ems.service;

import com.airtribe.ems.entity.Department;
import com.airtribe.ems.exception.ResourceNotFoundException;
import com.airtribe.ems.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) throws ResourceNotFoundException {
        return departmentRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with id:" + id));
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department upadtedDepartment) throws ResourceNotFoundException {
        Department existingDepartment = getDepartmentById(id);
        existingDepartment.setName(upadtedDepartment.getName());
        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(Long id) throws ResourceNotFoundException {
        Department department = getDepartmentById(id);
        departmentRepository.delete(department);
    }
}
