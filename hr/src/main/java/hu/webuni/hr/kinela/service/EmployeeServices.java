package hu.webuni.hr.kinela.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.repository.EmployeeRepository;
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@Service
public class EmployeeServices {
	@Autowired
	EmployeeRepository employeeRepository;
	
//	private Map<Long, Employee> employees;
//	private int idCounter = 1;
//	
//	public EmployeeServices() {
//		initEmployees();
//	}
//
//	public void initEmployees() {
//		
//		Map<Long, Employee> employees = new HashMap<>();
//		
//		employees.put(1L, new Employee(1, "Mani", "developer", 100, "2010-01-01T01:01"));
//		idCounter++;
//		employees.put(2L, new Employee(2, "Della", "architect", 100, "2015-01-01T01:01"));
//		idCounter++;
//		employees.put(3L, new Employee(3, "Zsé", "boss", 100, "2018-01-01T01:01"));
//		idCounter++;
//		
//		setEmployees(employees);
//	}

//	private void setEmployees(Map<Long, Employee> employees) {
//		this.employees = employees;
//		employeeRepository.saveAll(employees);
//	}
	
	public List<Employee> getEmployees() {
//		return employees;
		return employeeRepository.findAll();
	}
	
//	public long getElements() {
//		return idCounter++;
//	}
	@Transactional
	public void addEmployee(Employee employee) {
//		employee.setEmployeeId(getElements());
//		employees.put(employee.getEmployeeId(), employee);
		employee.setEmployeeId(0);
		employeeRepository.save(employee);
		
	}

	public Employee getEmployeeById(long id) {
		return employeeRepository.getById(id);
	}
	
	@Transactional
	public void modifyEmployee(long id, Employee employee) {
//		employees.put(id, employee);
		employee.setEmployeeId(id);
		employeeRepository.save(employee);
	}
	
	public List<Employee> getEmployeesList() {
//		List<Employee> employeesList = new ArrayList<Employee>(employees.values());
//		return employeesList;
		
		List<Employee> allEmployee = new ArrayList<Employee>();
		
		try {
			allEmployee = employeeRepository.findAll();
		} catch(EmptyResultDataAccessException ex) {}
		return allEmployee;
	}
	
//	public Employee getEmployeeByListId(long id) {
//		List<Employee> employees = getEmployeesList();
//		return employees.stream().filter(emp -> emp.getEmployeeId() == id).findFirst().get();
//	}

//	public Employee getEmployeeByMaptId(long id) {
//		return employees.get(id);
//	}
	
	public void removeEmployee(long id) {
//		employees.remove(id);
		employeeRepository.delete(getEmployeeById(id));
	}
	
}
