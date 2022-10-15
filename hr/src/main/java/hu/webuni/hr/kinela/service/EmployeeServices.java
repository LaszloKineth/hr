package hu.webuni.hr.kinela.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.repository.EmployeeRepository;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public Employee getEmployeeById(long id) {
		return employeeRepository.getById(id);
	}
	
	@Transactional
	public void modifyEmployee(long id, Employee employee) {
		employee.setEmployeeId(id);
		employeeRepository.save(employee);
	}
	
	public List<Employee> getEmployeesList() {
		return employeeRepository.findAll();
	}
	
	@Transactional
	public void removeEmployee(long id) {
		employeeRepository.delete(getEmployeeById(id));
	}
	
	public List<Employee> getEmployeeWithSpecificTitle(String title) {
		return employeeRepository.findByTitle(title);
	}
	
	public List<Employee> getEmployeesWhowsNameStartedWith(String nameStarts) {
		return employeeRepository.findEmployeesWhosNameStartWith(nameStarts);
	}
	
	public List<Employee> getEmployeesWhosStartBetween(LocalDateTime startdate, LocalDateTime enddate) {
		return employeeRepository.findEmployeesWhosStartBetween(startdate, enddate);
	}
}
