package com.Employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.app.Dao.EmployeeRepository;
import com.Employee.app.Service.EmployeeService;
import com.Employee.app.model.Employee;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	 	@Autowired
	    private EmployeeService employeeservice;

	 	 


	    // build create employee REST API
	    @PostMapping
	    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
	    	employeeservice.createEmployee(employee);
			return new ResponseEntity<>("Employee Saved successfully",HttpStatus.OK);
		}
	    
	    @GetMapping
	    public List<Employee> getAllEmployeedetails(){
			List<Employee> acc=employeeservice.getAllEmployees();
			return acc;
			//return new ResponseEntity<List<Employee>>(acc,HttpStatus.OK);
		}

	    // build get employee by id REST API
	    @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable  int id){
	    	Employee employee=employeeservice.getEmployeeDetailsById(id);
	        return new ResponseEntity<>(employee,HttpStatus.OK);
	    }

	    // build update employee REST API
	    @PutMapping("{id}")
	    public ResponseEntity<String> updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
	    	employeeservice.updateEmployee(id,employee);
	    	String msg="Employee updated";
	    	return new ResponseEntity<>(msg,HttpStatus.OK);
	       
	    }

	    // build delete employee REST API
	    @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id){

	    	employeeservice.deleteEmployee(id);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

}
