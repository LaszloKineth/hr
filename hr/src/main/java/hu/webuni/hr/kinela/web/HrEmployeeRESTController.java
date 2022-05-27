package hu.webuni.hr.kinela.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 *
 */


@RestController
@RequestMapping("/api/employees")
public class HrEmployeeRESTController {

		private Map<Long, EmployeeDto> employees = new HashMap<>();
		
		{
			employees.put(1L, new EmployeeDto(1, "Mani", "developer", 100, LocalDateTime.of(2010, 1, 1, 1, 1)));
			employees.put(2L, new EmployeeDto(2, "Della", "architect", 100, LocalDateTime.of(2015, 1, 1, 1, 1)));
		}
		
		@GetMapping
		public List<EmployeeDto> getAllEmployees() {
			
			return new ArrayList<>(employees.values());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {

			EmployeeDto employee = employees.get(id);
			
			if (employee != null) {
				return ResponseEntity.ok(employee);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@PostMapping
		public EmployeeDto createEmployee(@RequestBody EmployeeDto employee) {
			
			employees.put(employee.getId(), employee);
			
			return employee;
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<EmployeeDto> modifíEmployee(@PathVariable long id, @RequestBody EmployeeDto employee) {

			if(!employees.containsKey(id)) {
				return ResponseEntity.notFound().build();
			} else {
				employee.setId(id);
				employees.put(id, employee);
				
				return ResponseEntity.ok(employee);
			}
		}

		@DeleteMapping("/{id}")
		public void deleteEmployee(@PathVariable long id) {
			employees.remove(id);
		}
	
		@GetMapping("/salary")
		public ResponseEntity<List<EmployeeDto>> getEmployeesWithGreaterSalary(@RequestParam Map<String, String> params) {

			List<EmployeeDto> higherSalaryEmployees = new ArrayList<>();
			
			if (params.containsKey("min_salary")) {
				
				for (EmployeeDto employeeDto : new ArrayList<EmployeeDto>(employees.values())) {
					
					if (employeeDto.getSalary() > Integer.parseInt(params.get("min_salary"))) {
						higherSalaryEmployees.add(employeeDto);
					}
				}
				
				if (higherSalaryEmployees.isEmpty()) {
					return ResponseEntity.noContent().build();
				} else {
					return ResponseEntity.ok(higherSalaryEmployees);
				}
			}
			return ResponseEntity.noContent().build();
		}

}
