package hu.webuni.hr.kinela.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

public class EmployeeServices {
	
	private static Map<Long, Employee> employees;
	private static int idCounter = 1;
	
	public EmployeeServices() {
		initEmployees();
	}

	public static void initEmployees() {
		
		Map<Long, Employee> employees = new HashMap<>();
		
		employees.put(1L, new Employee(1, "Mani", "developer", 100, "2010-01-01T01:01"));
		idCounter++;
		employees.put(2L, new Employee(2, "Della", "architect", 100, "2015-01-01T01:01"));
		idCounter++;
		employees.put(3L, new Employee(3, "Zsé", "boss", 100, "2018-01-01T01:01"));
		idCounter++;
		
		EmployeeServices.setEmployees(employees);
	}

	private static void setEmployees(Map<Long, Employee> employees) {
		EmployeeServices.employees = employees;
	}
	
	public static Map<Long, Employee> getEmployees() {
		return employees;
	}
	
	public static long getElements() {
		return idCounter++;
	}
	
	public static void addEmployee(Employee employee) {
		employee.setEmloyeeId(getElements());
		employees.put(employee.getEmloyeeId(), employee);
	}
		
	public static void modifyEmployee(long id, Employee employee) {
		employees.put(id, employee);
	}
	
	public static List<Employee> getEmployeesList() {
		List<Employee> employeesList = new ArrayList<Employee>(employees.values());
		return employeesList;
	}
	
	public static Employee getEmployeeByListId(long id) {
		List<Employee> employees = getEmployeesList();
		return employees.stream().filter(emp -> emp.getEmloyeeId() == id).findFirst().get();
	}

	public static Employee getEmployeeByMaptId(long id) {
		return employees.get(id);
	}
	
	public static void removeEmployee(long id) {
		employees.remove(id);
	}
	
}
