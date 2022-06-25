package hu.webuni.hr.kinela.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.mapper.CompanyMapperImp;
import hu.webuni.hr.kinela.mapper.EmployeeMapperImp;
import hu.webuni.hr.kinela.model.Company;
import hu.webuni.hr.kinla.dto.CompanyDto;
import hu.webuni.hr.kinla.dto.EmployeeDto;

@Service
public class CompanyService {

	private static List<Company> companies = new ArrayList<>();
	private static int idCounter = 1;
	private static CompanyMapperImp companyMapper = new CompanyMapperImp();
	private static EmployeeMapperImp employeeMapper = new EmployeeMapperImp();

	public CompanyService() {
		super();
	}

	public CompanyService(List<CompanyDto> companies) {
		super();
		setCompanies(companies);
	}

	public static List<CompanyDto> getCompanies() {
		return companyMapper.companiesToCompanysDtos(companies);
	}

	public static void setCompanies(List<CompanyDto> companiess) {
		companies = companyMapper.companyDtosToCompanies(companiess);
	}
	
	public static List<CompanyDto> getAllCompanies(Boolean full) {
		if(full != null && full) 
			return companyMapper.companiesToCompanysDtos(companies);
		else 
			return companyMapper.companiesToCompanysDtos(companies)
					.stream()
					.map(comp -> new CompanyDto(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList());
	}

	public static CompanyDto getCompanieById(int id, Boolean full) {
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
	
	public static CompanyDto getCompanieById(int id) {

			return companyMapper.companiesToCompanysDtos(companies)
					.stream()
					.map(comp -> new CompanyDto(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList())
					.stream()
					.filter(comp -> comp.getId() == id)
					.findFirst()
					.get();
	}

	public static CompanyDto createCompany(CompanyDto company) {
		company.setId(idCounter++);
		companies.add(companyMapper.companyDtoToCompany(company));
		return company;
	}

	public static CompanyDto modifíCompany(int id, CompanyDto company) {
		Company tempCompany = companyMapper.companyDtoToCompany(company);
		tempCompany.setCompanyId(id);
		
		//companies.remove(companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get());
		companies.removeIf(com -> com.getCompanyId() == id);
		companies.add(tempCompany);
		
		return companyMapper.companyToCompanyDto(tempCompany);
	}

	public static void deleteCompany(int id) {
		companies.remove(companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get());
	}

	public static List<EmployeeDto> getEmployees(int id) {
		return companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().getCompanyEmployees();
	}
	
	public static EmployeeDto getEmployee(int id, int employeeId) {
		return companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().getEmployeeById(employeeId);
	}
		
	public static EmployeeDto addEmployee(int id, EmployeeDto employee) {
		companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().addEmployee(employeeMapper.employeeDtoToEmployee(employee));

		return employee;
	}
	
	public static void removeEmployee(int id, int employeeId) {
		companies.stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().removeEmployeeById(employeeId);
	}
	
}
