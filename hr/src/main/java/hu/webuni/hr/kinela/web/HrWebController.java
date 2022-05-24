package hu.webuni.hr.kinela.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.model.Employees;

@Controller
public class HrWebController {

	private List<Employee> employees = Employees.getEmployees();
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/hr/employees")
	public String allEmployees(Map<String, Object> model) {
		model.put("employees", employees);
				
		return "employees";
	}
	
}
