package com.lti.absadeck.kamls.service;



import com.lti.absadeck.kamls.model.Employee;

import java.util.List;

public interface IEmployeeService {

	List<Employee> getAllEmployee();
	Employee getEmployeeById(int empId);
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee, int empId);
	void deleteEmployee(int empId);
	List<Employee> getEmployeeByDept(String deptName);

}
