package hu.webuni.hr.kinela.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.kinela.service.DefaultEmployeeService;
import hu.webuni.hr.kinela.service.EmployeeService;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@Configuration
@Profile("!prod")
public class DefaultEmployeeServiceConfig {
	
	@Bean
	public EmployeeService employeeService() {
		
		return new DefaultEmployeeService();
	}
}
