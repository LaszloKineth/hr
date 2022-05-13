package hu.webuni.hr.kinela.service;

import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Employee;

@Service
public class SalaryService {

	private EmployeeService employeeService;

	public SalaryService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public int getEmployeeSalary(Employee employee) {
		return  employee.getSalary() + (int) ((employee.getSalary() * ((employeeService.getPayRaisePercent(employee) * 0.01))));
	}
	
}
