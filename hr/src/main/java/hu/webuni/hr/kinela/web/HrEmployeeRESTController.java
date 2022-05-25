package hu.webuni.hr.kinela.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.model.Employees;

@RestController
@RequestMapping("/api/employees")
public class HrEmployeeRESTController {

		@GetMapping
		public List<Employee> getAll() {
			
			return Employees.getEmployees();
		}
		
		//TODO Needs to code other REST methods
}
