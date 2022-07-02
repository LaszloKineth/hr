package hu.webuni.hr.kinela.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinla.dto.EmployeeDto;

public class EmployeeMapperMyImp implements EmployeeMapper {

	@Override
	public EmployeeDto employeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId(employee.getEmployeeId());
        employeeDto.setName(employee.getEmployeeName());
        employeeDto.setSalary(employee.getEmployeeSalary());
        employeeDto.setTitle(employee.getEmployeeTitle());
        employeeDto.setStartDateOfWork(employee.getEmployeeStartDateOfWork());

        return employeeDto;
	}

	@Override
	public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();
        
        employee.setEmployeeId(employeeDto.getId());
        employee.setEmployeeName(employeeDto.getName());
        employee.setEmployeeSalary(employeeDto.getSalary());
        employee.setEmployeeStartDateOfWork(employeeDto.getStartDateOfWork());
        employee.setEmployeeTitle(employeeDto.getTitle());

        return employee;
	}

	@Override
	public List<EmployeeDto> employeesToEmployeesDto(List<Employee> employees) {
        if (employees == null) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>(employees.size());
        for (Employee employee : employees) {
            list.add(employeeToEmployeeDto(employee));
        }

        return list;
	}

	@Override
	public List<Employee> employessDtoToEmployees(List<EmployeeDto> employeesDto) {
        if (employeesDto == null) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>(employeesDto.size());
        for (EmployeeDto employeeDto : employeesDto) {
            list.add(employeeDtoToEmployee(employeeDto));
        }

        return list;
	}
	
}
