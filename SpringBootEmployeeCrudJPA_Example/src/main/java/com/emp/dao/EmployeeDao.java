package com.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.entity.Employee;



@Repository
public interface EmployeeDao  extends JpaRepository<Employee, Integer>{

}
