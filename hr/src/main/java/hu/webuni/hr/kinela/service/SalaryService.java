package hu.webuni.hr.kinela.service;

import org.springframework.stereotype.Service;

import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com  
 *
 */

@Service
public class SalaryService {

	private EmployeeService employeeService;

	public SalaryService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public int getEmployeeSalary(EmployeeDto employee) {
		return  employee.getSalary() + (int) ((employee.getSalary() * ((employeeService.getPayRaisePercent(employee) * 0.01))));
	}
	
}
