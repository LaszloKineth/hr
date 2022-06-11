package hu.webuni.hr.kinla.dto;

import java.util.List;

public class CompanyDto {
	private int id;
	private String name;
	private String address;
	private List<EmployeeDto> employees;
	
	public CompanyDto(int id, String name, String address, List<EmployeeDto> employees) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.employees = employees;
	}

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
	
	public boolean addEmployee(EmployeeDto employee) {
		return employees.add(employee);
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
