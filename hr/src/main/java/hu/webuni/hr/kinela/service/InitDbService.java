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
		try {
			employeeRepository.clearDB();
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Employee Database is empty.");
		};
		
		try {
			companyRepository.clearDB();
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Company Database is empty.");
		}
		
		System.out.println("[ DEVELOPER INFO ] - DBs are cleared");
	}
	
	public void insertTestData() {
		try {
			companyRepository.insertTestData();
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Company Database filled with test entity");
		}

		try {
			employeeRepository.insertTestData();
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Employee Database filled with test entity");
		}
		
		System.out.println("[ DEVELOPER INFO ] - DBs are initiated");
	}
}
