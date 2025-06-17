package com.Employee.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
