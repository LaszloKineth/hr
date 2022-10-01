package hu.webuni.hr.kinela.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import hu.webuni.hr.kinela.dto.CompanyDto;
import hu.webuni.hr.kinela.model.Company;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
	
	@Mapping(source = "companyId", target = "id")
	@Mapping(source = "companyName", target = "name")
	@Mapping(source = "companyAddress", target = "address")
	@Mapping(source = "companyEmployees", target = "employees")
	CompanyDto companyToCompanyDto(Company company);
	
	@Mapping(source = "id", target = "companyId")
	@Mapping(source = "name", target = "companyName")
	@Mapping(source = "address", target = "companyAddress")
	@Mapping(source = "employees", target = "companyEmployees")
	Company companyDtoToCompany(CompanyDto CompanyDto);

	List<CompanyDto> companiesToCompanysDtos(List<Company> companies);
	
	List<Company> companyDtosToCompanies(List<CompanyDto> companiesDto);
	
}
