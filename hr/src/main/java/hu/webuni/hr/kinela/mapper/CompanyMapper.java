package hu.webuni.hr.kinela.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import hu.webuni.hr.kinela.dto.CompanyDto;
import hu.webuni.hr.kinela.model.Company;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "address", target = "address")
	@Mapping(source = "employees", target = "employees")
	CompanyDto companyToCompanyDto(Company company);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "address", target = "address")
	@Mapping(source = "employees", target = "employees")
	
	Company companyDtoToCompany(CompanyDto CompanyDto);

	List<CompanyDto> companiesToCompanysDtos(List<Company> companies);
	
	List<Company> companyDtosToCompanies(List<CompanyDto> companiesDto);
	
}
