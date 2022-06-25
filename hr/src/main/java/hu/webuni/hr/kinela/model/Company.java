package hu.webuni.hr.kinela.model;

import java.util.ArrayList;
import java.util.List;

import hu.webuni.hr.kinela.mapper.CompanyMapperImp;
import hu.webuni.hr.kinela.mapper.EmployeeMapperImp;
import hu.webuni.hr.kinla.dto.EmployeeDto;

public class Company {
	private int companyId;
	private String companyName;
	private String companyAddress;
	private List<Employee> companyEmployees = new ArrayList<>();
	private EmployeeMapperImp employeeMapper = new EmployeeMapperImp();
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

	public List<EmployeeDto> getCompanyEmployees() {
		return employeeMapper.employeesToEmployeesDto(companyEmployees);
	}

	public void setCompanyEmployees(List<EmployeeDto> list) {
		this.companyEmployees = employeeMapper.employessDtoToEmployees(list);
	}
	
	public EmployeeDto getEmployeeById(int id) {
		
		return employeeMapper.employeesToEmployeesDto(companyEmployees).stream().filter(emp -> emp.getId() == id).findFirst().get();
	}
	
	public void removeEmployeeById(int id) {
		companyEmployees.remove(companyEmployees.stream().filter(emp -> emp.getEmloyeeId() == id).findFirst().get());
	}
	
	public void addEmployee(Employee employee) {
		employee.setEmloyeeId(employeeCount++);
		companyEmployees.add(employee);
	}
}
