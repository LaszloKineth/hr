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
		
		employees.add(new Employee(1, "Mani", "developer", 100, LocalDateTime.of(2010, 1, 1, 1, 1)));
		employees.add(new Employee(2, "Della", "architect", 100, LocalDateTime.of(2015, 1, 1, 1, 1)));
		employees.add(new Employee(3, "Zsé", "boss", 100, LocalDateTime.of(2018, 1, 1, 1, 1)));
		employees.add(new Employee(4, "Guba", "cleaning assistant", 100, LocalDateTime.of(2022, 1, 1, 1, 1)));
		
		Employees.setEmployees(employees);
	}

	private static void setEmployees(List<Employee> employees) {
		Employees.employees = employees;
	}
	
	public static List<Employee> getEmployees() {
		return employees;
	}
	
	public static long getElements() {
		return employees.size();
	}
	
	public static void addEmployee(Employee employee) {
		employee.setId(getElements() + 1);
		employees.add(employee);
	}
	
}
