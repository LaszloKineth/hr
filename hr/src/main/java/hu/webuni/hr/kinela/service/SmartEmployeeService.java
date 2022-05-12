package hu.webuni.hr.kinela.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService {

	@Override
	public float getPayRaisePercent(Employee employee) {

		LocalDateTime startDate = employee.getStartDateOfWork();
		
		if (startDate.isBefore(LocalDateTime.now().minusYears(10))) {
			return 0.1f;
		} else if (startDate.isBefore(LocalDateTime.now().minusYears(5)) && (startDate.isAfter(LocalDateTime.now().minusYears(10)))) {
			return 0.05f;
		} else if (startDate.isBefore(LocalDateTime.now().minusYears(2)) && (startDate.isAfter(LocalDateTime.now().minusYears(5)))) {
			return 0.02f;
		} else if (startDate.isAfter(LocalDateTime.now().minusYears(2))) {
			return 0;
		} else {
			return 0;
		}
	}

}
