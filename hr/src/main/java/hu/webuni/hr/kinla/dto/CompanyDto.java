package hu.webuni.hr.kinla.dto;

import java.util.ArrayList;
import java.util.List;

public class CompanyDto {
	private int id;
	private String name;
	private String address;
	private List<EmployeeDto> employees = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(EmployeeDto employee) {
		employees.add(employee);
	}
	
	public EmployeeDto getEmployeeById(int id) {
		
		for (EmployeeDto employeeDto : employees) {
			if(employeeDto.getId() == id) {
				return employeeDto;
			}
		}
		
		return null;
	}
	
	
}
