package hu.webuni.hr.kinela.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "redirect:employees";
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

	@GetMapping("/employees/{id}")
	public String modifyEmployee(Map<String, Object> model, @PathVariable int id) {

		model.put("employeeById", Employees.getEmployeeByListId(id));
		
		return "modifyEmployee";
	}
	

	@PostMapping("/modifyEmployee")
	public String updateEmployee(EmployeeDto employee) {
		
		Employees.modifyEmployee(employee.getId(), employee);

		return "redirect:/employees";
	}
	
	
	@GetMapping("/removeEmployee/{id}")
	public String removeEmployee(@PathVariable long id) {

		Employees.getEmployees().remove(id);

		return "redirect:/employees";
	}

}
