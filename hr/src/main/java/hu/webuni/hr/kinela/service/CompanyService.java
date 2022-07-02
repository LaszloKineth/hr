package hu.webuni.hr.kinela.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.mapper.CompanyMapper;
import hu.webuni.hr.kinela.mapper.CompanyMapperMyImp;
import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.mapper.EmployeeMapperMyImp;
import hu.webuni.hr.kinela.model.Company;
import hu.webuni.hr.kinla.dto.CompanyDto;
import hu.webuni.hr.kinla.dto.EmployeeDto;

@Service
public class CompanyService {

	private List<Company> companies = new ArrayList<>();
	private int idCounter = 1;
	//private static CompanyMapperMyImp companyMapper = new CompanyMapperMyImp();
	//private static EmployeeMapperMyImp employeeMapper = new EmployeeMapperMyImp();
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	

	public CompanyService() {
		super();
	}

	public CompanyService(List<CompanyDto> companies) {
		super();
		setCompanies(companies);
	}

	public List<CompanyDto> getCompanies() {
		return companyMapper.companiesToCompanysDtos(companies);
	}

	public void setCompanies(List<CompanyDto> companiess) {
		companies = companyMapper.companyDtosToCompanies(companiess);
	}
	
	public List<CompanyDto> getAllCompanies(Boolean full) {
		if(full != null && full) 
			return companyMapper.companiesToCompanysDtos(companies);
		else 
			return companyMapper.companiesToCompanysDtos(companies)
					.stream()
					.map(comp -> new CompanyDto(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList());
	}

	public CompanyDto getCompanieById(int id, Boolean full) {
		if(full != null && full) 
			return companyMapper
					.companiesToCompanysDtos(companies)
					.stream()
					.filter(comp -> comp.getId() == id)
					.findFirst()
					.get();
		else
			return companyMapper.companiesToCompanysDtos(companies)
					.stream()
					.map(comp -> new CompanyDto(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList())
					.stream()
					.filter(comp -> comp.getId() == id)
					.findFirst()
					.get();
	}
	
	public CompanyDto getCompanieById(int id) {

			return companyMapper.companiesToCompanysDtos(companies)
					.stream()
					.map(comp -> new CompanyDto(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList())
					.stream()
					.filter(comp -> comp.getId() == id)
					.findFirst()
					.get();
	}

	public CompanyDto createCompany(CompanyDto company) {
		company.setId(idCounter++);
		companies.add(companyMapper.companyDtoToCompany(company));
		return company;
	}

	public CompanyDto modifíCompany(int id, CompanyDto company) {
		Company tempCompany = companyMapper.companyDtoToCompany(company);
		tempCompany.setCompanyId(id);
		
		//companies.remove(companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get());
		companies.removeIf(com -> com.getCompanyId() == id);
		companies.add(tempCompany);
		
		return companyMapper.companyToCompanyDto(tempCompany);
	}

	public void deleteCompany(int id) {
		companies.remove(companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get());
	}

	public List<EmployeeDto> getEmployees(int id) {
		return companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().getCompanyEmployees();
	}
	
	public EmployeeDto getEmployee(int id, int employeeId) {
		return companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().getEmployeeById(employeeId);
	}
		
	public EmployeeDto addEmployee(int id, EmployeeDto employee) {
		companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().addEmployee(employeeMapper.employeeDtoToEmployee(employee));

		return employee;
	}
	
	public void removeEmployee(int id, int employeeId) {
		companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().removeEmployeeById(employeeId);
	}
	
}
