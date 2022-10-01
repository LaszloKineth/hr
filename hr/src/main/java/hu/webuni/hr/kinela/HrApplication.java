package hu.webuni.hr.kinela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.kinela.mapper.EmployeeMapper;
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
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		List<EmployeeDto> dto = employeeMapper.employeesToEmployeesDto(employeeServices.getEmployeesList());
//		
//		for (EmployeeDto employee2 : dto) {
//			
//			System.out.println("\n" + employee2.getName() + "'s salary is " + employee2.getSalary()
//					+ " now. He/She working since "
//					+ employee2.getStartDateOfWork() 
//					+ " After salary upgrade it is "
//					+ new SalaryService(employeePayRaiseService).getEmployeeSalary(employee2) 
//					+ ". Service Type: "
//					+ employeePayRaiseService.getClass().getSimpleName());
//		}
//		
//		System.out.println("\n---=== System started and ready to use ===---");

	}

}
