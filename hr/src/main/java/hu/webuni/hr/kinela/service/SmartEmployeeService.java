package hu.webuni.hr.kinela.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService {

	@Value("${hr.employee.years.max}")
	int employeeYearsMax;
	
	@Value("${hr.employee.years.mid}")
	int employeeYearsMid;

	@Value("${hr.employee.years.min}")
	int employeeYearsMin;

	@Value("${hr.employee.percent.max}")
	int employeePercentsMax;

	@Value("${hr.employee.percent.mid1}")
	int employeePercentsMid1;
	
	@Value("${hr.employee.percent.mid2}")
	int employeePercentsMid2;
	
	@Value("${hr.employee.percent.min}")
	int employeePercentsMin;
	
	@Override
	public int getPayRaisePercent(Employee employee) {

		LocalDateTime startDate = employee.getStartDateOfWork();
		
		if (startDate.isBefore(LocalDateTime.now().minusYears(employeeYearsMax))) {
			return employeePercentsMax;
		} else if (startDate.isBefore(LocalDateTime.now().minusYears(employeeYearsMid)) && (startDate.isAfter(LocalDateTime.now().minusYears(employeeYearsMax)))) {
			return employeePercentsMid1;
		} else if (startDate.isBefore(LocalDateTime.now().minusYears(employeeYearsMin)) && (startDate.isAfter(LocalDateTime.now().minusYears(employeeYearsMid)))) {
			return employeePercentsMid2;
		} else if (startDate.isAfter(LocalDateTime.now().minusYears(employeeYearsMin))) {
			return employeePercentsMin;
		} else {
			return 0;
		}
		
//		LocalDateTime startDate = employee.getStartDateOfWork();
//		
//		if (startDate.isBefore(LocalDateTime.now().minusYears(10))) {
//			return 0.1f;
//		} else if (startDate.isBefore(LocalDateTime.now().minusYears(5)) && (startDate.isAfter(LocalDateTime.now().minusYears(10)))) {
//			return 0.05f;
//		} else if (startDate.isBefore(LocalDateTime.now().minusYears(2)) && (startDate.isAfter(LocalDateTime.now().minusYears(5)))) {
//			return 0.02f;
//		} else if (startDate.isAfter(LocalDateTime.now().minusYears(2))) {
//			return 0;
//		} else {
//			return 0;
//		}
	}

}
