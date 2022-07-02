package hu.webuni.hr.kinela.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinla.dto.EmployeeDto;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
	
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	@Mapping(source = "employeeId", target = "id")
	@Mapping(source = "employeeName", target = "name")
	@Mapping(source = "employeeTitle", target = "title")
	@Mapping(source = "employeeSalary", target = "salary")
	@Mapping(source = "employeeStartDateOfWork", target = "startDateOfWork")
	EmployeeDto employeeToEmployeeDto(Employee employee);
	
	@Mapping(source = "id", target = "employeeId")
	@Mapping(source = "name", target = "employeeName")
	@Mapping(source = "title", target = "employeeTitle")
	@Mapping(source = "salary", target = "employeeSalary")
	@Mapping(source = "startDateOfWork", target = "employeeStartDateOfWork")
	Employee employeeDtoToEmployee(EmployeeDto employeeDto);

	List<EmployeeDto> employeesToEmployeesDto(List<Employee> employees);
	
	List<Employee> employessDtoToEmployees(List<EmployeeDto> employeesDto);

}
