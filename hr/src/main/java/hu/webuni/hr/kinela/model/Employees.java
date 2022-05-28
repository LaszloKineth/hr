package hu.webuni.hr.kinela.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

public class Employees {
	
	private static List<EmployeeDto> employees;
	
	public Employees() {
		initEmployees();
	}

	public static void initEmployees() {
		
		List<EmployeeDto> employees = new ArrayList<EmployeeDto>();
		
//		employees.add(new Employee(1, "Mani", "developer", 100, LocalDateTime.of(2010, 1, 1, 1, 1)));
//		employees.add(new Employee(2, "Della", "architect", 100, LocalDateTime.of(2015, 1, 1, 1, 1)));
//		employees.add(new Employee(3, "Zsé", "boss", 100, LocalDateTime.of(2018, 1, 1, 1, 1)));
//		employees.add(new Employee(4, "Guba", "cleaning assistant", 100, LocalDateTime.of(2022, 1, 1, 1, 1)));
		
		employees.add(new EmployeeDto(1, "Mani", "developer", 100, "2010-01-01 01:01"));
		employees.add(new EmployeeDto(2, "Della", "architect", 100, "2015-01-01 01:01"));
		employees.add(new EmployeeDto(3, "Zsé", "boss", 100, "2018-01-01 01:01"));
//		employees.add(new Employee(4, "Guba", "cleaning assistant", 100, "2022-01-01 01:01"));
		
		Employees.setEmployees(employees);
	}

	private static void setEmployees(List<EmployeeDto> employees) {
		Employees.employees = employees;
	}
	
	public static List<EmployeeDto> getEmployees() {
		return employees;
	}
	
	public static long getElements() {
		return employees.size();
	}
	
	public static void addEmployee(EmployeeDto employee) {
		employee.setId(getElements() + 1);
		employees.add(employee);
	}
		
//	public static void modifyEmployee(long id, EmployeeDto employee) {
//		employeesMap.put(id, employee);
//	}
	
	public static Map<Long, EmployeeDto> getEmployessMap() {
		
		Map<Long, EmployeeDto> employeesMap = new HashMap<>();
		
		for (EmployeeDto employee : employees) {
			employeesMap.put(employee.getId(), employee);
		}

		return employeesMap;
	}
	
}
