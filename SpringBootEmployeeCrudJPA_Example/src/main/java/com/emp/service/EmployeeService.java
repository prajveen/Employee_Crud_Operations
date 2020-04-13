package com.emp.service;

import java.util.List;
import java.util.Optional;

import com.emp.entity.Employee;

public interface EmployeeService {

	String createEmp(Employee employee);

	Optional<Employee> findEmpById(Integer empId);

	List<Employee> findAllEmployees();

	String updateEmp(Employee employee);

	String deleteEmp(Integer empId);

	String fetchName(Integer empId);

}
