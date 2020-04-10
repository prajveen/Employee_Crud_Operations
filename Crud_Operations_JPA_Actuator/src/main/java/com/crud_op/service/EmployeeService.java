package com.crud_op.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_op.dao.EmployeeRepository;
import com.crud_op.entity.EmployeeDetails;
import com.crud_op.exceptions.Id_NotFound_Exception;
@Service
@Transactional
public class EmployeeService implements EmployeeServiceI{

	@Autowired
	private EmployeeRepository dao;
	@Override
	public EmployeeDetails createEmployee(EmployeeDetails employee)  {
		return dao.save(employee) ;	
	}

	@Override
	public Optional<EmployeeDetails> getEmployeeDetails(Integer empId) throws Id_NotFound_Exception {
		return dao.findById(empId);

	}

	@Override
	public List<EmployeeDetails> fetchAllEmployees() {
		return  dao.findAll();

	}

	@Override
	public String updateEmployee(EmployeeDetails employee) {
		boolean result=dao.existsById(employee.getEmployeeID());
		if(result)
		{
			dao.save(employee);
			return "Updated Successfully";
		}else
		{
			dao.save(employee);
			return "Update not possible user added ";
		}
	}

	@Override
	public String deleteEmployee(Integer empId)   {
		dao.deleteById(empId);
		return "Deleted Successfully";
	}


}
