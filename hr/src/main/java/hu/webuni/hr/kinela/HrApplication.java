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
import hu.webuni.hr.kinela.service.InitDbService;

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
	InitDbService initDbService;
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initDbService.clearDB();
		initDbService.insertTestData();
		System.out.println("[ DEVELOPER INFO ] - Application up and running");
	}
}
