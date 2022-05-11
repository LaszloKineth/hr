package hu.webuni.hr.kinela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Employee;

@Service
public class SaleryService {

	@Autowired
	EmployeeService employeeService;

	public SaleryService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public int getEmployeeSalary(Employee employee) {
		return employeeService.getPayRaisePercent(employee);
	}
	
}
