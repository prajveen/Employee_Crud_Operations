package com.crud_op.service;

import java.util.List;

import com.crud_op.entity.EmployeeDetails;

public interface EmployeeServiceI {

	EmployeeDetails getEmployeeDetails(int id);

	EmployeeDetails createEmployee(EmployeeDetails employee);

	EmployeeDetails updateEmployee(EmployeeDetails employee);

	EmployeeDetails deleteEmployee(int id);

	List<Object> fetchAllEmployees();

}
