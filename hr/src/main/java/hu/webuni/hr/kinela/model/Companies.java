package hu.webuni.hr.kinela.model;

import java.util.ArrayList;
import java.util.List;

import hu.webuni.hr.kinla.dto.CompanyDto;

public class Companies {
	
	private static List<CompanyDto> companies = new ArrayList();
	private static int companiesCounter = 1;
	
	public Companies(List<CompanyDto> companies) {
		super();
		this.companies = companies;
	}
	
	public Companies() {
		
	}

	public static List<CompanyDto> getCompanies() {
		return companies;
	}

	public static void setCompanies(List<CompanyDto> comps) {
		companies = comps;
	}

	public static int getCompaniesCounter() {
		return companiesCounter;
	}

	public static void addCompany(CompanyDto company) {
		
		company.setId(companiesCounter);
		companies.add(company);
		companiesCounter++;
	}
	
	public static void addModifiedCompany(CompanyDto company) {
		companies.add(company);
	}
	
	public static boolean removeCompany(int id) {
		
		for (CompanyDto companyDto : companies) {
			if(companyDto.getId() == id) {
				return companies.remove(companyDto);
			}
		}
		return false;
	}

	public static boolean removeCompany(CompanyDto company) {
		
		for (CompanyDto companyDto : companies) {
			if(companyDto.getId() == company.getId()) {
				return companies.remove(companyDto);
			}
		}
		return false;
	}
	
	public static void modifyCompany(CompanyDto company) {
		for (CompanyDto companyDto : companies) {
			if(companyDto.getId() == company.getId()) {
				companies.remove(companyDto);
				addModifiedCompany(company);
				break;
			}
		}
	}
	
	public static CompanyDto getCompanyById(int id) {
		for (CompanyDto companyDto : companies) {
			if(companyDto.getId() == id) {
				return companyDto;
			}
		}
		return null;
	}
	
}
