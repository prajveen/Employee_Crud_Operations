package com.crud_op.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_op.dao.EmployeeRepository;
import com.crud_op.entity.EmployeeDetails;
@Service
@Transactional
public class EmployeeService implements EmployeeServiceI{


	@Autowired
	private EmployeeRepository dao;
	@Override
	public EmployeeDetails getEmployeeDetails(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeDetails(id);
	}
	@Override
	public EmployeeDetails createEmployee(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		return dao.createEmployee(employee);
	}
	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(employee);
	}
	@Override
	public EmployeeDetails deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(id);
	}
	@Override
	public List<Object> fetchAllEmployees() {
		// TODO Auto-generated method stub
		return dao.fetchAllEmployees();
	}

}
