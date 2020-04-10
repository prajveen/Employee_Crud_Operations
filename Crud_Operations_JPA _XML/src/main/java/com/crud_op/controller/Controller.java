package com.crud_op.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.crud_op.globalException.Id_NotFound_Exception;
import com.crud_op.service.Employee_ServiceI;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class Controller {

	@Autowired
	private Employee_ServiceI service;
	
	@SuppressWarnings("unused")
	@PostMapping(path="/create",consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDetails employee){
		
		@SuppressWarnings("unused")
		EmployeeDetails emp = service.createEmployee(employee);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Employee created successfully",HttpStatus.OK);
		return responseEntity;
		
	}
	
	@GetMapping(path="/findById/{empId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
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
	
	@GetMapping(path="/fetchall",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<EmployeeDetails> fetchAllEmployees() {
		return service.fetchAllEmployees();
	}
	
	@PutMapping(path="/update",consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDetails employee) {
		ResponseEntity< String> rs = new ResponseEntity<String>(service.updateEmployee(employee),HttpStatus.OK);
		return rs;
	}
	
	@DeleteMapping(path="/delete/{empId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId) throws Id_NotFound_Exception
	{
		ResponseEntity<String> rs =  new ResponseEntity<String>(service.deleteEmployee(empId),HttpStatus.OK);
		return rs;
	}
	
	
}
