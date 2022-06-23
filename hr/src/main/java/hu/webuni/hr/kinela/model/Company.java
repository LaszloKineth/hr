package hu.webuni.hr.kinela.model;

import java.util.ArrayList;
import java.util.List;

import hu.webuni.hr.kinla.dto.EmployeeDto;

public class Company {
	private int companyId;
	private String companyName;
	private String companyAddress;
	private List<EmployeeDto> companyEmployees = new ArrayList<>();
	
	public Company(int companyId, String companyName, String companyAddress, List<EmployeeDto> companyEmployees) {
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

	public List<EmployeeDto> getCompanyEmployees() {
		return companyEmployees;
	}

	public void setCompanyEmployees(List<EmployeeDto> companyEmployees) {
		this.companyEmployees = companyEmployees;
	}
	
	public EmployeeDto getEmployeeById(int id) {
		
		return companyEmployees.stream().filter(emp -> emp.getId() == id).findFirst().get();
	}
	
	public void removeEmployeeById(int id) {
		companyEmployees.remove(companyEmployees.stream().filter(emp -> emp.getId() == id).findFirst().get());
	}
}
