package hu.webuni.hr.kinela.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.config.EmployeeConfigurationProperties;
import hu.webuni.hr.kinela.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService {

/**
 * Values from configuration class	
 */
	
	@Autowired
	EmployeeConfigurationProperties properties;

		
	@Override
	public int getPayRaisePercent(Employee employee) {
		
		
		LocalDateTime startDate = employee.getStartDateOfWork();
			
			if (startDate.isBefore(LocalDateTime.now().minusYears(properties.getYears().getMax()))) {
				return properties.getPercent().getMax();
			} else if (startDate.isBefore(LocalDateTime.now().minusYears(properties.getYears().getMid())) && (startDate.isAfter(LocalDateTime.now().minusYears(properties.getYears().getMax())))) {
				return properties.getPercent().getMid1();
			} else if (startDate.isBefore(LocalDateTime.now().minusYears(properties.getYears().getMin())) && (startDate.isAfter(LocalDateTime.now().minusYears(properties.getYears().getMid())))) {
				return properties.getPercent().getMid2();
			} else if (startDate.isAfter(LocalDateTime.now().minusYears(properties.getYears().getMin()))) {
				return properties.getPercent().getMin();
			} else {
				return properties.getPercent().getMin();
			}
			
		}

	}

/**
 * Direct value from application.properties
 */


//	@Value("${hr.years.max}")
//	int employeeYearsMax;
//	
//	@Value("${hr.years.mid}")
//	int employeeYearsMid;
//
//	@Value("${hr.years.min}")
//	int employeeYearsMin;
//
//	@Value("${hr.percent.max}")
//	int employeePercentsMax;
//
//	@Value("${hr.percent.mid1}")
//	int employeePercentsMid1;
//	
//	@Value("${hr.percent.mid2}")
//	int employeePercentsMid2;
//	
//	@Value("${hr.percent.min}")
//	int employeePercentsMin;
	

//	@Override
//	public int getPayRaisePercent(Employee employee) {
//
//		LocalDateTime startDate = employee.getStartDateOfWork();
//		
//		if (startDate.isBefore(LocalDateTime.now().minusYears(employeeYearsMax))) {
//			return employeePercentsMax;
//		} else if (startDate.isBefore(LocalDateTime.now().minusYears(employeeYearsMid)) && (startDate.isAfter(LocalDateTime.now().minusYears(employeeYearsMax)))) {
//			return employeePercentsMid1;
//		} else if (startDate.isBefore(LocalDateTime.now().minusYears(employeeYearsMin)) && (startDate.isAfter(LocalDateTime.now().minusYears(employeeYearsMid)))) {
//			return employeePercentsMid2;
//		} else if (startDate.isAfter(LocalDateTime.now().minusYears(employeeYearsMin))) {
//			return employeePercentsMin;
//		} else {
//			return 0;
//		}
//		
//	}
	

