package hu.webuni.hr.kinela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.kinela.model.Employees;
import hu.webuni.hr.kinela.service.EmployeeService;
import hu.webuni.hr.kinela.service.SalaryService;
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	{
		Employees.initEmployees();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		for (EmployeeDto employee2 : Employees.getEmployeesList()) {

			System.out.println("\n" + employee2.getName() + "'s salary is " + employee2.getSalary()
					+ " now. He/She working since "
					+ employee2.getStartDateOfWork()
					+ " After salary upgrade it is "
					+ new SalaryService(employeeService).getEmployeeSalary(employee2) + ". Service Type: "
					+ employeeService.getClass().getSimpleName());
		}

	}

}
