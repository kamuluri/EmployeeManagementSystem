package com.Employee.app.Service;

import java.util.List;

import com.Employee.app.model.Employee;

public interface EmployeeService {
	void createEmployee(Employee employee);
	Employee getEmployeeDetailsById(int id);
	List<Employee> getAllEmployees();
	Employee updateEmployee(int id,Employee e);
	
	void deleteEmployee(int id);
}
