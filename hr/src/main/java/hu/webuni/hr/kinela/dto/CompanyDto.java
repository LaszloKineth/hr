package hu.webuni.hr.kinela.dto;

import java.util.List;

import hu.webuni.hr.kinela.model.CompanyType;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

public class CompanyDto {
	private long id;
	private String name;
	private String address;
	private List<EmployeeDto> employees;
	private CompanyType type;
	
	public CompanyDto() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		
		return employees.stream().filter(emp -> emp.getId() == id).findFirst().get();
	}
	
	public void removeEmployeeById(int id) {
		employees.remove(employees.stream().filter(emp -> emp.getId() == id).findFirst().get());
	}

	public CompanyType getType() {
		return type;
	}

	public void setType(CompanyType type) {
		this.type = type;
	}
}
