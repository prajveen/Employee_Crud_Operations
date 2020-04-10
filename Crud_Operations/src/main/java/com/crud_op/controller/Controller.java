package com.crud_op.controller;
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

import com.crud_op.entity.EmployeeDetails;
import com.crud_op.service.EmployeeService;

@RestController
@RequestMapping("/company")
@CrossOrigin("http://localhost:8080")
public class Controller {
	@Autowired
	private EmployeeService service;
	@GetMapping("/getEmployeeDetails/{enter Employee id here}")
	public ResponseEntity<EmployeeDetails> getEmployeeDetails(@PathVariable ("enter Employee id here") int id){
		EmployeeDetails emp = service.getEmployeeDetails(id);
		ResponseEntity<EmployeeDetails> responseEntity = new ResponseEntity<EmployeeDetails>(emp, HttpStatus.OK);
		return responseEntity;
	}
	@PostMapping("/createEmployee")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDetails employee) {
		EmployeeDetails emp = service.createEmployee(employee);
		if(emp == null) {
			ResponseEntity<String> responseEntity =new ResponseEntity<String>("Sorry, unable to insert the Employee",HttpStatus.OK);
			return responseEntity;
		}
		else {
			ResponseEntity<String> responseEntity =new ResponseEntity<String>( "Employee was inserted successfully!!",HttpStatus.OK);
			return responseEntity;
		}
	}
	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDetails employee) {
		EmployeeDetails emp = service.updateEmployee(employee);
		if(emp != null) {
			ResponseEntity<String> responseEntity =new ResponseEntity<String>( "Employee details were updated successfully!!"+"\nEmployee ID : "+employee.getEmployeeID()+"\nEmployee Name : "+
					employee.getFirstName()+" "+employee.getLastName()+"\nEmployee Mobile no : "+employee.getMobileNo()+"\nEmployee Adrress : "+
					employee.getAddress(),HttpStatus.OK);
			return responseEntity;
		}
		else {
			ResponseEntity<String> responseEntity =new ResponseEntity<String>( "Sorry, employee details were not updated",HttpStatus.OK);
			return responseEntity;
		}
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("id") int id) {
		EmployeeDetails emp = service.deleteEmployee(id);
		if(emp == null) {
			ResponseEntity<String> responseEntity =new ResponseEntity<String>("Sorry, employee deatils were not deleted",HttpStatus.OK);
			return responseEntity;
		}
		else {
			ResponseEntity<String> responseEntity =new ResponseEntity<String>("Employee details were deleted successfully!!",HttpStatus.OK);
			return responseEntity;
		}
	}
	
	@GetMapping("/fetchAllEmployees")
	public List<Object>fetchAllEmployees(){
		List <Object>list = service.fetchAllEmployees();
		return list;
	}
}
