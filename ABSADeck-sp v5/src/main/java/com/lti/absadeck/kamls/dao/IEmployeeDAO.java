package com.lti.absadeck.kamls.dao;


import com.lti.absadeck.kamls.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeDAO extends JpaRepository<Employee, Integer> {

	List<Employee> findByDeptName(String deptName);
}
