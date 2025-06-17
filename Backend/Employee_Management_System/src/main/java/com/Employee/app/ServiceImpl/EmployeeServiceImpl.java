package com.Employee.app.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.app.Dao.EmployeeRepository;
import com.Employee.app.Exception.ResourceNotFoundException;
import com.Employee.app.Service.EmployeeService;
import com.Employee.app.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
		
		
	}
	public Employee getEmployeeDetailsById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
	}
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employee= employeeRepository.findAll();
		return employee;
	}
	@Override
	public Employee updateEmployee(int id, Employee e) {
		
		 Employee updateEmployee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

	        updateEmployee.setFirstName(e.getFirstName());
	        updateEmployee.setLastName(e.getLastName());
	        updateEmployee.setEmailId(e.getEmailId());

	        employeeRepository.save(updateEmployee);
	        
	        return updateEmployee;

	}
	public void deleteEmployee(int id) {
		 Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

	        employeeRepository.delete(employee);
		
	}
	
	
	

}
