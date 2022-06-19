package hu.webuni.hr.kinela.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.kinela.service.EmployeePayRaiseService;
import hu.webuni.hr.kinela.service.SmartEmployeeService;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@Configuration
@Profile("prod")
public class SmartEmployeeServiceConfig {

	@Bean
	public EmployeePayRaiseService employeePayRaiseService() {

		return new SmartEmployeeService();
	}
}
