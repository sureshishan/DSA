package com.airtribe.ems.repository;

import com.airtribe.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByProjectsId(Long projectId);

    List<Employee> findByProjectsIsNull();

}
