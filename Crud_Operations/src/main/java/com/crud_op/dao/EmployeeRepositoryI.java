package com.crud_op.dao;

import java.util.List;

import com.crud_op.entity.EmployeeDetails;

public interface EmployeeRepositoryI {

	EmployeeDetails getEmployeeDetails(int id);

	EmployeeDetails createEmployee(EmployeeDetails employee);

	EmployeeDetails updateEmployee(EmployeeDetails employee);

	EmployeeDetails deleteEmployee(int id);

	List<Object> fetchAllEmployees();

}
