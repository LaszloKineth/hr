package hu.webuni.hr.kinela.mapper;

import java.util.List;

import hu.webuni.hr.kinela.model.Company;
import hu.webuni.hr.kinla.dto.CompanyDto;

public interface CompanyMapper {

	CompanyDto companyToCompanyDto(Company company);
	
	Company companyDtoToCompany(CompanyDto CompanyDto);

	List<CompanyDto> companiesToCompanysDtos(List<Company> companies);
	
	List<Company> companyDtosToCompanies(List<CompanyDto> companiesDto);
	
}
