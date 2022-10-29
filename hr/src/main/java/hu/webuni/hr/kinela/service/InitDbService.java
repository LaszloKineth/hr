package hu.webuni.hr.kinela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.repository.CompanyRepository;
import hu.webuni.hr.kinela.repository.EmployeeRepository;

@Service
public class InitDbService {
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void clearDB() {
		
	}
	
	public void insertTestData() {
		
	}
}
