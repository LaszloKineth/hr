package hu.webuni.hr.kinela.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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
import hu.webuni.hr.kinela.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
//	private List<Company> companies = new ArrayList<>();
//	private int idCounter = 1;
	
	public CompanyService() {
		super();
	}

//	public CompanyService(List<Company> companies) {
//		super();
//		setCompanies(companies);
//	}

	public List<Company> getCompanies() {
//		return companies;
		return companyRepository.findAll();
	}

//	public void setCompanies(List<Company> companies) {
//		companies = companiess;
//	}
	
	@Transactional
	public void addCompanie(Company company) {
		companyRepository.save(company);
	}
	
//	public List<Company> getAllCompanies(Boolean full) {
//		if(full != null && full) 
//			return companies;
//		else 
//			return companies
//					.stream()
//					.map(comp -> new Company(comp.getId(), comp.getName(), comp.getAddress(), null))
//					.collect(Collectors.toList());
//	}

//	public Company getCompanieById(int id, Boolean full) {
//		if(full != null && full) 
//			return companies
//					.stream()
//					.filter(comp -> comp.getId() == id)
//					.findFirst()
//					.get();
//		else
//			return companies
//					.stream()
//					.map(comp -> new Company(comp.getId(), comp.getName(), comp.getAddress(), null))
//					.collect(Collectors.toList())
//					.stream()
//					.filter(comp -> comp.getId() == id)
//					.findFirst()
//					.get();
//	}
	
	public Company getCompanieById(long id) {
//
//			return companies
//					.stream()
//					.map(comp -> new Company(comp.getId(), comp.getName(), comp.getAddress(), null))
//					.collect(Collectors.toList())
//					.stream()
//					.filter(comp -> comp.getId() == id)
//					.findFirst()
//					.get();
			return companyRepository.findById(id);
	}

//	public Company createCompany(Company company) {
//		company.setId(idCounter++);
//		companies.add(company);
//		return company;
//	}

	@Transactional
	public void modifíCompany(long id, Company company) {
//		Company tempCompany = company;
//		tempCompany.setId(id);
//		
//		companies.removeIf(com -> com.getId() == id);
//		companies.add(tempCompany);
//		
//		return tempCompany;
		company.setId(id);
		companyRepository.save(company);
	}

	@Transactional
	public void deleteCompany(long id) {
//		companies.remove(companies.stream().filter(comp -> comp.getId() == id).findFirst().get());
		companyRepository.deleteById(id);
	}

//	public List<Employee> getEmployees(int id) {
//		return companies.stream().filter(comp -> comp.getId() == id).findFirst().get().getEmployees();
//	}
//	
//	public Employee getEmployee(int id, int employeeId) {
//		return companies.stream().filter(comp -> comp.getId() == id).findFirst().get().getEmployeeById(employeeId);
//	}
//		
//	public Employee addEmployee(int id, Employee employee) {
//		companies.stream().filter(comp -> comp.getId() == id).findFirst().get().addEmployee(employee);
//
//		return employee;
//	}
//	
//	public void removeEmployee(int id, int employeeId) {
//		companies.stream().filter(comp -> comp.getId() == id).findFirst().get().removeEmployeeById(employeeId);
//	}
	
}
