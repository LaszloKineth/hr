package hu.webuni.hr.kinela.mapper;

import java.util.ArrayList;
import java.util.List;

import hu.webuni.hr.kinela.model.Company;
import hu.webuni.hr.kinla.dto.CompanyDto;

public class CompanyMapperMyImp implements CompanyMapper {

	@Override
	public CompanyDto companyToCompanyDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setId(company.getCompanyId());
        companyDto.setName(company.getCompanyName());
        companyDto.setAddress(company.getCompanyAddress());
        companyDto.setEmployees(company.getCompanyEmployees());

        return companyDto;
	}

	@Override
	public Company companyDtoToCompany(CompanyDto companyDto) {

        if ( companyDto == null ) {
            return null;
        }

        Company company = new Company();
        
        company.setCompanyId(companyDto.getId());
        company.setCompanyName(companyDto.getName());
        company.setCompanyAddress(companyDto.getAddress());
        company.setCompanyEmployees(companyDto.getEmployees());

        return company;
		
	}

	@Override
	public List<CompanyDto> companiesToCompanysDtos(List<Company> companies) {
        if (companies == null) {
            return null;
        }

        List<CompanyDto> list = new ArrayList<CompanyDto>(companies.size());
        for (Company company : companies) {
            list.add(companyToCompanyDto(company));
        }

        return list;
	}

	@Override
	public List<Company> companyDtosToCompanies(List<CompanyDto> companiesDto) {
        if (companiesDto == null) {
            return null;
        }

        List<Company> list = new ArrayList<Company>(companiesDto.size());
        for (CompanyDto companyDto : companiesDto) {
            list.add(companyDtoToCompany(companyDto));
        }

        return list;
	}

}
