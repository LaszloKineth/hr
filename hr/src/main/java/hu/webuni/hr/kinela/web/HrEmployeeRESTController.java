package hu.webuni.hr.kinela.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.hr.kinela.mapper.EmployeeMapperImp;
import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.model.EmployeeServices;
import hu.webuni.hr.kinela.service.EmployeePayRaiseService;
import hu.webuni.hr.kinela.service.SmartEmployeeService;
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 *
 */

@RestController
@RequestMapping("/api/employees")
public class HrEmployeeRESTController {

	@Autowired
	SmartEmployeeService smartEmployeeService;
	@Autowired
	EmployeePayRaiseService employeePayRaiseService;
	@Autowired
	EmployeeMapperImp employeeMapperImp;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(required = false) Integer min_salary) {

		if (min_salary == null) {
			return ResponseEntity.ok(employeeMapperImp.employeesToEmployeesDto(EmployeeServices.getEmployeesList()));

		} else {
			List<EmployeeDto> higherSalaryEmployees = new ArrayList<>();

			for (Employee employee : new ArrayList<Employee>(EmployeeServices.getEmployees().values())) {
				
				EmployeeDto tempEmployeeDto = employeeMapperImp.employeeToEmployeeDto(employee);
				
				if (tempEmployeeDto.getSalary() > min_salary) {
					higherSalaryEmployees.add(tempEmployeeDto);
				}
			}

			return ResponseEntity.ok(higherSalaryEmployees);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {

		return ResponseEntity.ok(employeeMapperImp.employeeToEmployeeDto(EmployeeServices.getEmployees().get(id)));
	}

	@PostMapping
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {

		
		EmployeeServices.addEmployee(employeeMapperImp.employeeDtoToEmployee(employeeDto));

		return employeeDto;
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> modifíEmployee(@PathVariable long id, @RequestBody EmployeeDto employee) {

		employee.setId(id);
		EmployeeServices.modifyEmployee(id, employeeMapperImp.employeeDtoToEmployee(employee));

		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id) {
		EmployeeServices.getEmployees().remove(id);
	}

	@GetMapping("/payRaise")
	public int getPayRaisePercent(@RequestBody EmployeeDto employee) {
		return employeePayRaiseService.getPayRaisePercent(employee);
	}
	
}
