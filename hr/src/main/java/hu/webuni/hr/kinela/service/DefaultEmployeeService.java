package hu.webuni.hr.kinela.service;

import hu.webuni.hr.kinela.model.Employee;

public class DefaultEmployeeService implements EmployeeService {

	@Override
	public float getPayRaisePercent(Employee employee) {
		return 0.05f;
	}

}
