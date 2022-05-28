package hu.webuni.hr.kinela.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.model.Employees;
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@Controller
public class HrEmployeeTLCController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/employees")
	public String allEmployees(Map<String, Object> model) {
		model.put("employees", Employees.getEmployees());
		model.put("newEmployee", new Employee());		
		
		return "employees";
	}
	
	@PostMapping("/employees")
	public String addEmployee(EmployeeDto employee) {
		Employees.addEmployee(employee);
		
		return "redirect:employees";
	}
	
}
