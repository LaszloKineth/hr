package hu.webuni.hr.kinela.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Employees {
	
	private static List<Employee> employees;
	
	public Employees() {
		initEmployees();
	}

	public static void initEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee(12345, "Mani", "developer", 100, LocalDateTime.of(2010, 1, 1, 1, 1)));
		employees.add(new Employee(23456, "Della", "architect", 100, LocalDateTime.of(2015, 1, 1, 1, 1)));
		employees.add(new Employee(34567, "Zsé", "boss", 100, LocalDateTime.of(2018, 1, 1, 1, 1)));
		employees.add(new Employee(45678, "Guba", "cleaning assistant", 100, LocalDateTime.of(2022, 1, 1, 1, 1)));
		
		Employees.setEmployees(employees);
	}

	public static List<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(List<Employee> employees) {
		Employees.employees = employees;
	}
	
}
