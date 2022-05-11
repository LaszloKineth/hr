package hu.webuni.hr.kinela;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.service.EmployeeService;
import hu.webuni.hr.kinela.service.SalaryService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner{

	@Autowired
	EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Employee employee = new Employee(1234567, "Money", "developer", 600_000, LocalDateTime.of(2021, 1, 1, 1, 1));
		System.out.println(new SalaryService(employeeService).getEmployeeSalary(employee));
	}

}
