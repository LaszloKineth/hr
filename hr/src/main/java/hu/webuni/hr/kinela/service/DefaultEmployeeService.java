package hu.webuni.hr.kinela.service;

import hu.webuni.hr.kinela.model.Employee;

public class DefaultEmployeeService implements EmployeeService {

	@Override
	public int getPayRaisePercent(Employee employee) {
		return 5;
	}

}
