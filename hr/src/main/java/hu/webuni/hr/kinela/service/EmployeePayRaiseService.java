package hu.webuni.hr.kinela.service;

import hu.webuni.hr.kinela.dto.EmployeeDto;

public interface EmployeePayRaiseService {
	public int getPayRaisePercent(EmployeeDto employee);
}
