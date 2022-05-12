package hu.webuni.hr.kinela.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.kinela.service.EmployeeService;
import hu.webuni.hr.kinela.service.SmartEmployeeService;

@Configuration
@Profile("prod")
public class SmartEmployeeServiceConfig {

	@Bean
	public EmployeeService employeeService() {

		return new SmartEmployeeService();
	}
}
