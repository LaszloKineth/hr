package hu.webuni.hr.kinela.service;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.repository.CompanyRepository;
import hu.webuni.hr.kinela.repository.CompanyTypeRepository;
import hu.webuni.hr.kinela.repository.EmployeeRepository;

@Service
public class InitDbService {
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	CompanyTypeRepository companyTypeRepository;
	
	private void clearEmployeeDB() {
		try {
			employeeRepository.clearDB();
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Employee Database is empty.");
		};
	}
	
	private void clearCompanyDB() {
		try {
			companyRepository.clearDB();
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Company Database is empty.");
		}
	}

	private void clearCompanyTypeDB() {
		try {
			companyTypeRepository.clearDB();
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Company Type Database is empty.");
		}
	}
	
	private void insertCompanyTestData(long id, String name, String address, long type_id) {
		try {
			companyRepository.insertTestData(id, name, address, type_id);
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Company Database append with " + name);
		}
	}
	
	private void insertEmployeeTestData(long id, String name, int salary, LocalDateTime startDate, String title, long companyID) {
		try {
			employeeRepository.insertTestData(id, name, salary, startDate, title, companyID);
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Employee Database append with " + name);
		}
	}
	
	private void insertCompanyTypeTestDate(long id, String type) {
		try {
			companyTypeRepository.insertTestData(id, type);
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Company Type Database append with " + type);
		}
	}

	public void clearDB() {
		clearEmployeeDB();
		clearCompanyDB();
		clearCompanyTypeDB();
		System.out.println("[ DEVELOPER INFO ] - DBs are cleared");
	}
	
	public void insertTestData() {
		
		insertCompanyTypeTestDate(1, "Bt");
		insertCompanyTypeTestDate(2, "Kft");
		insertCompanyTypeTestDate(3, "Zrt");
		insertCompanyTypeTestDate(4, "Nyrt");
		
		insertCompanyTestData(1, "Generated Company1", "1st Adress str.", 1);
		insertCompanyTestData(2, "Generated Company2", "2nd Adress str.", 2);

		insertEmployeeTestData(1, "First Employee", 100, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - Developer", 1);
		insertEmployeeTestData(2, "Second Employee", 500, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - Developer", 1);
		insertEmployeeTestData(3, "Third Employee", 500, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - CIO", 1);
		insertEmployeeTestData(4, "Forth Employee", 1000, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - Developer", 2);

		System.out.println("[ DEVELOPER INFO ] - DBs are initiated");
	}
}
