package hu.webuni.hr.kinela.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@Service
public class EmployeeServices {
	
	private Map<Long, Employee> employees;
	private int idCounter = 1;
	
	public EmployeeServices() {
		initEmployees();
	}

	public void initEmployees() {
		
		Map<Long, Employee> employees = new HashMap<>();
		
		employees.put(1L, new Employee(1, "Mani", "developer", 100, "2010-01-01T01:01"));
		idCounter++;
		employees.put(2L, new Employee(2, "Della", "architect", 100, "2015-01-01T01:01"));
		idCounter++;
		employees.put(3L, new Employee(3, "Zsé", "boss", 100, "2018-01-01T01:01"));
		idCounter++;
		
		setEmployees(employees);
	}

	private void setEmployees(Map<Long, Employee> employees) {
		this.employees = employees;
	}
	
	public Map<Long, Employee> getEmployees() {
		return employees;
	}
	
	public long getElements() {
		return idCounter++;
	}
	
	public void addEmployee(Employee employee) {
		employee.setEmployeeId(getElements());
		employees.put(employee.getEmployeeId(), employee);
	}
		
	public void modifyEmployee(long id, Employee employee) {
		employees.put(id, employee);
	}
	
	public List<Employee> getEmployeesList() {
		List<Employee> employeesList = new ArrayList<Employee>(employees.values());
		return employeesList;
	}
	
	public Employee getEmployeeByListId(long id) {
		List<Employee> employees = getEmployeesList();
		return employees.stream().filter(emp -> emp.getEmployeeId() == id).findFirst().get();
	}

	public Employee getEmployeeByMaptId(long id) {
		return employees.get(id);
	}
	
	public void removeEmployee(long id) {
		employees.remove(id);
	}
	
}
