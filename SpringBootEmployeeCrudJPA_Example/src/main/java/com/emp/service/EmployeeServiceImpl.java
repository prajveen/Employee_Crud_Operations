package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmployeeDao;
import com.emp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public String createEmp(Employee employee) {
		empDao.save(employee);
		return "Employee Added" ;
	}

	@Override
	public Optional<Employee> findEmpById(Integer empId) {
		return empDao.findById(empId);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return empDao.findAll();
	}

	@Override
	public String updateEmp(Employee employee) {
		boolean result=empDao.existsById(employee.getId());
		if(result)
		{
			empDao.save(employee);
			return "Updated Successfully";
		}else
		{
			empDao.save(employee);
			return "Update not possible user added ";
		}
	}

	@Override
	public String deleteEmp(Integer empId) {
		boolean result=empDao.existsById(empId);
		if(result)
		{
			empDao.deleteById(empId);
			return "Deleted Successfully";
		}
		else{
			return "Id Not Found";
		}
	}

	@Override
	public String fetchName(Integer empId) {
		
		return null;
	}
	
	
	

}
