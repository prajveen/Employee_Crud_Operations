package com.crud_op.service;

import java.util.List;
import java.util.Optional;

import com.crud_op.entity.EmployeeDetails;
import com.crud_op.exceptions.Id_NotFound_Exception;

public interface EmployeeServiceI {
	
	String updateEmployee(EmployeeDetails employee);
	
	List<EmployeeDetails> fetchAllEmployees();
	
	Optional<EmployeeDetails> getEmployeeDetails(Integer empId) throws Id_NotFound_Exception;
	
	EmployeeDetails createEmployee(EmployeeDetails employee);

	String deleteEmployee(Integer empId) throws  Id_NotFound_Exception;

}

