package hu.webuni.hr.kinela.model;

import java.util.ArrayList;
import java.util.List;

import hu.webuni.hr.kinela.mapper.CompanyMapperMyImp;
import hu.webuni.hr.kinela.mapper.EmployeeMapperMyImp;
import hu.webuni.hr.kinla.dto.EmployeeDto;

public class Company {
	private int companyId;
	private String companyName;
	private String companyAddress;
	private List<Employee> companyEmployees = new ArrayList<>();
	private EmployeeMapperMyImp employeeMapper = new EmployeeMapperMyImp();
	private int employeeCount = 1;
	
	public Company(int companyId, String companyName, String companyAddress, List<Employee> companyEmployees) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyEmployees = companyEmployees;
	}

	public Company() {
		super();
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public List<Employee> getCompanyEmployees() {
		return companyEmployees;
	}

	public void setCompanyEmployees(List<Employee> list) {
		this.companyEmployees = list;
	}
	
	public Employee getEmployeeById(int id) {
		
		return companyEmployees.stream().filter(emp -> emp.getEmployeeId() == id).findFirst().get();
	}
	
	public void removeEmployeeById(int id) {
		companyEmployees.remove(companyEmployees.stream().filter(emp -> emp.getEmployeeId() == id).findFirst().get());
	}
	
	public void addEmployee(Employee employee) {
		employee.setEmployeeId(employeeCount++);
		companyEmployees.add(employee);
	}
}
