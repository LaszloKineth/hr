package hu.webuni.hr.kinela.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Autowired
	CompanyMapper companyMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<CompanyDto> getCompanies() {
		return  companyMapper.companiesToCompanysDtos(companyRepository.findAll());
	}
	
	@Transactional
	public void addCompanie(Company company) {
		companyRepository.save(company);
	}
	
	public Company getCompanieById(long id) {
		return companyRepository.findById(id);
	}

	@Transactional
	public void modifíCompany(long id, Company company) {
		company.setId(id);
		companyRepository.save(company);
	}

	@Transactional
	public void removeCompany(long id) {
		companyRepository.deleteById(id);
	}
	
	public List<CompanyDto> getCompaniesWhereEmployeesOutOfLimit(int limit) {
		List<Company> allCompanies = companyRepository.findAll();
		List<Company> overEmployeLimitCompanies = new ArrayList<Company>() ;
		
		allCompanies.forEach(c -> {
			if(c.getEmployees().size() > limit)	overEmployeLimitCompanies.add(c);
		});
		
		return companyMapper.companiesToCompanysDtos(overEmployeLimitCompanies);
	}
}
