package hu.webuni.hr.kinela.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.config.EmployeeConfigurationProperties;
import hu.webuni.hr.kinela.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 */

@Service
@Primary
public class SmartEmployeeService implements EmployeePayRaiseService {

	/**
	 * Values from configuration class
	 */
	
	@Autowired
	EmployeeConfigurationProperties properties;

	@Override
	public int getPayRaisePercent(EmployeeDto employee) {
		
		//LocalDateTime ldt = LocalDateTime.parse(employee.getStartDateOfWork());
		double yearsWorked = (ChronoUnit.DAYS.between(employee.getStartDateOfWork(), LocalDateTime.now()) / 365);
		
		if (yearsWorked > properties.getYears().getMax()) {
 			return properties.getPercent().getMax();
		} else if (yearsWorked > properties.getYears().getMid() && yearsWorked < properties.getYears().getMax()) {
			return properties.getPercent().getMid1();
		} else if (yearsWorked > properties.getYears().getMin() && yearsWorked < properties.getYears().getMid()) {
			return properties.getPercent().getMid2();
		} else return properties.getPercent().getMin();
	}

}
