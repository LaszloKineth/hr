package hu.webuni.hr.kinela.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

public class Employees {
	
	private static Map<Long, EmployeeDto> employees;
	private static String modifyUrl = "/employees/modify?id=";
	private static int idCounter = 1;
	
	public Employees() {
		initEmployees();
	}

	public static void initEmployees() {
		
		Map<Long, EmployeeDto> employees = new HashMap<>();
		
		employees.put(1L, new EmployeeDto(1, "Mani", "developer", 100, "2010-01-01 01:01", modifyUrl));
		idCounter++;
		employees.put(2L, new EmployeeDto(2, "Della", "architect", 100, "2015-01-01 01:01", modifyUrl));
		idCounter++;
		employees.put(3L, new EmployeeDto(3, "Zsé", "boss", 100, "2018-01-01 01:01", modifyUrl));
		idCounter++;
		
		Employees.setEmployees(employees);
	}

	private static void setEmployees(Map<Long, EmployeeDto> employees) {
		Employees.employees = employees;
	}
	
	public static Map<Long, EmployeeDto> getEmployees() {
		return employees;
	}
	
	public static long getElements() {
		return idCounter++;
	}
	
	public static void addEmployee(EmployeeDto employee) {
		employee.setId(getElements());
		employee.setModifyLink(modifyUrl + employee.getId());
		employees.put(employee.getId(), employee);
	}
		
	public static void modifyEmployee(long id, EmployeeDto employee) {
		employee.setModifyLink(modifyUrl + employee.getId());
		employees.put(id, employee);
	}
	
	public static List<EmployeeDto> getEmployeesList() {
		
		List<EmployeeDto> employeesList = new ArrayList<EmployeeDto>(Employees.getEmployees().values());

		return employeesList;
	}
	
	public static EmployeeDto getEmployeeByListId(int id) {
		
		List<EmployeeDto> employees = getEmployeesList();
		
		return employees.get(id);
	}

	public static EmployeeDto getEmployeeByMaptId(int id) {
		
		return employees.get(id);
	}
	
}
