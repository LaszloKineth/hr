package hu.webuni.hr.kinela.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Employee;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com  
 *
 */

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Value("${hr.percent.dfault}")
	int defaultValue;
	
	@Override
	public int getPayRaisePercent(Employee employee) {
		return defaultValue;
	}

}
