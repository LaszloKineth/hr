package hu.webuni.hr.kinela;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.service.EmployeeService;
import hu.webuni.hr.kinela.service.SalaryService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Employee> employees = new ArrayList<Employee>();

		employees.add(new Employee(12345, "Mani", "developer", 100, LocalDateTime.of(2010, 1, 1, 1, 1)));
		employees.add(new Employee(23456, "Della", "architect", 100, LocalDateTime.of(2015, 1, 1, 1, 1)));
		employees.add(new Employee(34567, "Zsé", "boss", 100, LocalDateTime.of(2018, 1, 1, 1, 1)));
		employees.add(new Employee(45678, "Guba", "cleaning assistant", 100, LocalDateTime.of(2022, 1, 1, 1, 1)));

		for (Employee employee2 : employees) {

			System.out.println("\n" + employee2.getName() + "'s salary is " + employee2.getSalary()
					+ " now. After salary upgrade it is "
					+ new SalaryService(employeeService).getEmployeeSalary(employee2) + ". Service Type: "
					+ employeeService.getClass().getSimpleName());
		}

	}

}
