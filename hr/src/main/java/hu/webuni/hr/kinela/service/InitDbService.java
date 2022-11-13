package hu.webuni.hr.kinela.service;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Position;
import hu.webuni.hr.kinela.repository.CompanyRepository;
import hu.webuni.hr.kinela.repository.CompanyTypeRepository;
import hu.webuni.hr.kinela.repository.EmployeeRepository;
import hu.webuni.hr.kinela.repository.PositionRepository;

@Service
public class InitDbService {
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	CompanyTypeRepository companyTypeRepository;
	
	@Autowired
	PositionRepository positionRepository;
	
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

	private void clearPositionDB() {
		try {
			positionRepository.clearDB();
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Position Database is empty.");
		}
	}	
	
	private void insertCompanyTestData(long id, String name, String address, long type_id) {
		try {
			companyRepository.insertTestData(id, name, address, type_id);
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Company Database append with " + name);
		}
	}
	
	private void insertEmployeeTestData(long id, String name, int salary, LocalDateTime startDate, String title, long companyID, long positionID) {
		try {
			employeeRepository.insertTestData(id, name, salary, startDate, title, companyID, positionID);
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

	private void inserPositionTestData(long id, String name, int minSalary, String minEdu) {
		try {
//			positionRepository.save(new Position(id, name, minEdu, minSalary));
			positionRepository.addPosition(id, name, minEdu, minSalary);
		} catch(Exception ex) {
			System.out.println("[ DEVELOPER INFO ] - Position Database append with " + name);
		}
	}
	
	public void clearDB() {
		clearPositionDB();
		clearEmployeeDB();
		clearCompanyDB();
		clearCompanyTypeDB();
		System.out.println("[ DEVELOPER INFO ] - DBs are cleared");
	}
	
	public void insertTestData() {
		inserPositionTestData(1, "Munkatars", 100, "Erettsegi");
		inserPositionTestData(2, "Developer", 200, "Foiskola");
		inserPositionTestData(3, "TeamLead", 300, "Egyetem");
		inserPositionTestData(4, "CIO", 400, "Egyetem");
		
		insertCompanyTypeTestDate(1, "Bt");
		insertCompanyTypeTestDate(2, "Kft");
		insertCompanyTypeTestDate(3, "Zrt");
		insertCompanyTypeTestDate(4, "Nyrt");
		
		insertCompanyTestData(1, "Generated Company1", "1st Adress str.", 1);
		insertCompanyTestData(2, "Generated Company2", "2nd Adress str.", 2);

		insertEmployeeTestData(1, "First Employee", 100, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - Developer", 1, 1);
		insertEmployeeTestData(2, "Second Employee", 500, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - Developer", 1, 2);
		insertEmployeeTestData(3, "Third Employee", 500, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - CIO", 1, 3);
		insertEmployeeTestData(4, "Forth Employee", 1000, LocalDateTime.of(2022, Month.JANUARY, 1, 1, 1), "Generated User - Developer", 2, 4);
		
		System.out.println("[ DEVELOPER INFO ] - DBs are initiated");
	}
}
