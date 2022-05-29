package hu.webuni.hr.kinela.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.put("employees", Employees.getEmployeesList());
		model.put("newEmployee", new EmployeeDto());		
		
		return "employees";
	}
	
	@PostMapping("/employees")
	public String addEmployee(EmployeeDto employee) {
		Employees.addEmployee(employee);
		
		return "redirect:employees";
	}
	
	@GetMapping("/employees/modify")
	public String modifyEmployee(Map<String, Object> model ,@RequestParam(value = "id", required = false) Integer id) {
		
		model.put("employeeById", Employees.getEmployeeById(id));  
		
		return "modify";
	}
	
}
