package hu.webuni.hr.kinela.service;

import java.time.LocalDateTime;
import java.time.Month;

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
			companyRepository.insertTestData(1, "Generated Company1", "1st Adress str.");
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Company Database append with Generated Company1");
		}

		try {
			companyRepository.insertTestData(2, "Generated Company2", "2nd Adress str.");
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Company Database append with Generated Company2");
		}
		
		try {
			employeeRepository.insertTestData(1, "First Employee", 100, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - Developer", 1);
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Employee Database append with First Employee to Generated Company1");
		}
		
		try {
			employeeRepository.insertTestData(2, "Second Employee", 500, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - Developer", 1);
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Employee Database append with Second Employee to Generated Company1");
		}
		
		try {
			employeeRepository.insertTestData(3, "Third Employee", 500, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - CIO", 1);
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Employee Database append with Second Employee to Generated Company1");
		}

		try {
			employeeRepository.insertTestData(4, "Forth Employee", 1000, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - Developer", 2);
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Employee Database append with Second Employee to Generated Company2");
		}
		
		System.out.println("[ DEVELOPER INFO ] - DBs are initiated");
	}
}
