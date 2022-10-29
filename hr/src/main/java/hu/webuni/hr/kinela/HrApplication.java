package hu.webuni.hr.kinela;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.repository.CompanyRepository;
import hu.webuni.hr.kinela.repository.EmployeeRepository;
import hu.webuni.hr.kinela.service.EmployeePayRaiseService;
import hu.webuni.hr.kinela.service.EmployeeServices;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	@Autowired
	EmployeePayRaiseService employeePayRaiseService;
	
	@Autowired(required = true)
	EmployeeMapper employeeMapper;
	
	@Autowired(required = true)
	EmployeeServices employeeServices;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("[ DEVELOPER INFO ] - Application up and running");
		
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
