package hu.webuni.hr.kinela.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.dto.CompanyDto;
import hu.webuni.hr.kinela.dto.EmployeeDto;
import hu.webuni.hr.kinela.mapper.CompanyMapper;
import hu.webuni.hr.kinela.mapper.CompanyMapperMyImp;
import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.mapper.EmployeeMapperMyImp;
import hu.webuni.hr.kinela.model.Company;
import hu.webuni.hr.kinela.model.Employee;

@Service
public class CompanyService {

	private List<Company> companies = new ArrayList<>();
	private int idCounter = 1;
	
	public CompanyService() {
		super();
	}

	public CompanyService(List<Company> companies) {
		super();
		setCompanies(companies);
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companiess) {
		companies = companiess;
	}
	
	public List<Company> getAllCompanies(Boolean full) {
		if(full != null && full) 
			return companies;
		else 
			return companies
					.stream()
					.map(comp -> new Company(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList());
	}

	public Company getCompanieById(int id, Boolean full) {
		if(full != null && full) 
			return companies
					.stream()
					.filter(comp -> comp.getId() == id)
					.findFirst()
					.get();
		else
			return companies
					.stream()
					.map(comp -> new Company(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList())
					.stream()
					.filter(comp -> comp.getId() == id)
					.findFirst()
					.get();
	}
	
	public Company getCompanieById(int id) {

			return companies
					.stream()
					.map(comp -> new Company(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList())
					.stream()
					.filter(comp -> comp.getId() == id)
					.findFirst()
					.get();
	}

	public Company createCompany(Company company) {
		company.setId(idCounter++);
		companies.add(company);
		return company;
	}

	public Company modifíCompany(int id, Company company) {
		Company tempCompany = company;
		tempCompany.setId(id);
		
		companies.removeIf(com -> com.getId() == id);
		companies.add(tempCompany);
		
		return tempCompany;
	}

	public void deleteCompany(int id) {
		companies.remove(companies.stream().filter(comp -> comp.getId() == id).findFirst().get());
	}

	public List<Employee> getEmployees(int id) {
		return companies.stream().filter(comp -> comp.getId() == id).findFirst().get().getEmployees();
	}
	
	public Employee getEmployee(int id, int employeeId) {
		return companies.stream().filter(comp -> comp.getId() == id).findFirst().get().getEmployeeById(employeeId);
	}
		
	public Employee addEmployee(int id, Employee employee) {
		companies.stream().filter(comp -> comp.getId() == id).findFirst().get().addEmployee(employee);

		return employee;
	}
	
	public void removeEmployee(int id, int employeeId) {
		companies.stream().filter(comp -> comp.getId() == id).findFirst().get().removeEmployeeById(employeeId);
	}
	
}
