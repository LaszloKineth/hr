package hu.webuni.hr.kinela.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.service.EmployeePayRaiseService;
import hu.webuni.hr.kinela.service.EmployeeServices;
import hu.webuni.hr.kinela.service.SmartEmployeeService;
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 *
 */

@RestController
@RequestMapping("/api/employees")
@Validated
public class HrEmployeeRESTController {

	@Autowired
	SmartEmployeeService smartEmployeeService;
	@Autowired
	EmployeePayRaiseService employeePayRaiseService;
	@Autowired
	EmployeeMapper employeeMapperImp;
	@Autowired
	EmployeeServices employeeServices;	
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(required = false) @Positive Integer min_salary) {

		if (min_salary == null) {
			return ResponseEntity.ok(employeeMapperImp.employeesToEmployeesDto(employeeServices.getEmployeesList()));

		} else {
			List<EmployeeDto> higherSalaryEmployees = new ArrayList<>();

			for (Employee employee : employeeServices.getEmployees()) {
				
				EmployeeDto tempEmployeeDto = employeeMapperImp.employeeToEmployeeDto(employee);
				
				if (tempEmployeeDto.getSalary() > min_salary) {
					higherSalaryEmployees.add(tempEmployeeDto);
				}
			}

			return ResponseEntity.ok(higherSalaryEmployees);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable @Positive long id) {

		return ResponseEntity.ok(employeeMapperImp.employeeToEmployeeDto(employeeServices.getEmployeeById(id)));
	}

	@PostMapping
	public EmployeeDto createEmployee(@RequestBody @Validated EmployeeDto employeeDto) {

		
		employeeServices.addEmployee(employeeMapperImp.employeeDtoToEmployee(employeeDto));

		return employeeDto;
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> modifíEmployee(@PathVariable @Positive long id, @RequestBody @Valid EmployeeDto employee) {

		employee.setId(id);
		employeeServices.modifyEmployee(id, employeeMapperImp.employeeDtoToEmployee(employee));

		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable @Positive long id) {
		employeeServices.removeEmployee(id);
	}

	@GetMapping("/payRaise")
	public int getPayRaisePercent(@RequestBody @Valid EmployeeDto employee) {
		return employeePayRaiseService.getPayRaisePercent(employee);
	}
	
}
