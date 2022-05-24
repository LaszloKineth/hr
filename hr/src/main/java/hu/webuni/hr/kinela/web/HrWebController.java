package hu.webuni.hr.kinela.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.model.Employees;

@Controller
public class HrWebController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/hr/employees")
	public String allEmployees(Map<String, Object> model) {
		model.put("employees", Employees.getEmployees());
		model.put("newEmployee", new Employee());		
		
		return "employees";
	}
	
	@PostMapping("/hr/employees")
	public String addEmployee(Employee employee) {
		Employees.addEmployee(employee);
		
		return "redirect:employees";
	}
	
}
