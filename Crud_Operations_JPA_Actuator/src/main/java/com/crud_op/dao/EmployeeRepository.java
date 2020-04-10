package com.crud_op.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud_op.entity.EmployeeDetails;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {


}
