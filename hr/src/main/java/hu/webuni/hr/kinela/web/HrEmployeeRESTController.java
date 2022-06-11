package hu.webuni.hr.kinela.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import hu.webuni.hr.kinela.model.Employees;
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 *
 */

@RestController
@RequestMapping("/api/employees")
public class HrEmployeeRESTController {

//		1. version
//	
//		@GetMapping
//		public List<EmployeeDto> getAllEmployees() {
//			
//			return Employees.getEmployeesList();
//		}
//		
//		@GetMapping(params = "min_salary")
//		public ResponseEntity<List<EmployeeDto>> getEmployeesWithGreaterSalary(@RequestParam(required = false) int min_salary) {
//			
//			List<EmployeeDto> higherSalaryEmployees = new ArrayList<>();
//			
//			for (EmployeeDto employeeDto : new ArrayList<EmployeeDto>(Employees.getEmployees().values())) {
//					
//				if (employeeDto.getSalary() >  min_salary) {
//						higherSalaryEmployees.add(employeeDto);
//				}
//			}
//				
//			if (higherSalaryEmployees.isEmpty()) {
//				return ResponseEntity.noContent().build();
//			} else {
//				return ResponseEntity.ok(higherSalaryEmployees);
//			}
//
//		}

	
// 2. version
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(required = false) Integer min_salary) {

		if (min_salary == null) {
			return ResponseEntity.ok(Employees.getEmployeesList());

		} else {
			List<EmployeeDto> higherSalaryEmployees = new ArrayList<>();

			for (EmployeeDto employeeDto : new ArrayList<EmployeeDto>(Employees.getEmployees().values())) {

				if (employeeDto.getSalary() > min_salary) {
					higherSalaryEmployees.add(employeeDto);
				}
			}

			return ResponseEntity.ok(higherSalaryEmployees);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {

		return ResponseEntity.ok(Employees.getEmployees().get(id));
	}

	@PostMapping
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employee) {

		Employees.addEmployee(employee);

		return employee;
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> modifíEmployee(@PathVariable long id, @RequestBody EmployeeDto employee) {

		employee.setId(id);
		Employees.modifyEmployee(id, employee);

		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id) {
		Employees.getEmployees().remove(id);
	}
	
}
