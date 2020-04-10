package com.crud_op.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.crud_op.entity.EmployeeDetails;
@Repository
public class EmployeeRepository implements EmployeeRepositoryI {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public EmployeeDetails getEmployeeDetails(int id) {
		EmployeeDetails emp = entityManager.find(EmployeeDetails.class, id);
		return emp;
	}
	@Override
	public EmployeeDetails createEmployee(EmployeeDetails employee) {
		employee = entityManager.merge(employee);
		return employee;
	}
	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails employee) {
		EmployeeDetails emp = entityManager.find(EmployeeDetails.class, employee.getEmployeeID());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setAddress(employee.getAddress());
		emp.setMobileNo(employee.getMobileNo());
		entityManager.merge(emp);
		return emp;
	}
	@Override
	public EmployeeDetails deleteEmployee(int id) {
		EmployeeDetails emp = entityManager.find(EmployeeDetails.class, id);
		entityManager.remove(emp);
		return emp;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> fetchAllEmployees() {
		Query query = entityManager.createQuery("select e from Employee e");
		List<Object> list = query.getResultList();
		return list;
	}

}
