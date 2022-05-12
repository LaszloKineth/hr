package hu.webuni.hr.kinela.service;

import org.springframework.stereotype.Service;

import hu.webuni.hr.kinela.model.Employee;

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Override
	public float getPayRaisePercent(Employee employee) {
		return 0.05f;
	}

}
