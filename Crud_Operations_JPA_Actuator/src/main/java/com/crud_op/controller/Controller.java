package com.crud_op.controller;
import java.util.List;
import java.util.Optional;

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

import com.crud_op.entity.EmployeeDetails;
import com.crud_op.exceptions.Id_NotFound_Exception;
import com.crud_op.service.EmployeeServiceI;

@RestController
@RequestMapping("/company")
@CrossOrigin("http://localhost:4200")
public class Controller {

	@Autowired
	private EmployeeServiceI service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDetails employee){
		
		EmployeeDetails emp = service.createEmployee(employee);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Employee created successfully",HttpStatus.OK);
		return responseEntity;
		
	}
	
	@GetMapping("/findById/{empId}")
	public Optional<EmployeeDetails> getEmployeeDetails(@PathVariable Integer empId) throws Id_NotFound_Exception {
		Optional<EmployeeDetails> result=service.getEmployeeDetails(empId);
		if(result== null)
		{
			throw new Id_NotFound_Exception("Employee with "+empId+" doesn't exist....!");
		}
		else
		{
			return result;
		}
	}
	
	@GetMapping("/fetchall")
	public List<EmployeeDetails> fetchAllEmployees() {
		return service.fetchAllEmployees();
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDetails employee) {
		ResponseEntity< String> rs = new ResponseEntity<String>(service.updateEmployee(employee),HttpStatus.OK);
		return rs;
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId) throws Id_NotFound_Exception
	{
		ResponseEntity<String> rs =  new ResponseEntity<String>(service.deleteEmployee(empId),HttpStatus.OK);
		return rs;
	}
	
	
}
