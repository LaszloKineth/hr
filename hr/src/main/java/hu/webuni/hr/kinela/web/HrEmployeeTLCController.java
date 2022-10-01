package hu.webuni.hr.kinela.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hu.webuni.hr.kinela.dto.EmployeeDto;
import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.service.EmployeeServices;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 *
 */

@Controller
public class HrEmployeeTLCController {

	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	EmployeeServices employeeServices;
	
	@GetMapping("/")
	public String home() {
		return "redirect:employees";
	}

	@GetMapping("/employees")
	public String allEmployees(Map<String, Object> model) {
		model.put("employees", employeeMapper.employeesToEmployeesDto(employeeServices.getEmployeesList()));
		model.put("newEmployee", new EmployeeDto());

		return "employees";
	}

	@PostMapping("/employees")
	public String addEmployee(EmployeeDto employee) {
		employeeServices.addEmployee(employeeMapper.employeeDtoToEmployee(employee));

		return "redirect:employees";
	}

	@GetMapping("/employees/{id}")
	public String modifyEmployee(Map<String, Object> model, @PathVariable int id) {

		model.put("employeeById", employeeMapper.employeeToEmployeeDto(employeeServices.getEmployeeById(id)));
		
		return "modifyEmployee";
	}
	

	@PostMapping("/modifyEmployee")
	public String updateEmployee(EmployeeDto employee) {
		
		employeeServices.modifyEmployee(employeeMapper.employeeDtoToEmployee(employee).getEmployeeId(), employeeMapper.employeeDtoToEmployee(employee));
		return "redirect:/employees";
	}
	
	
	@GetMapping("/removeEmployee/{id}")
	public String removeEmployee(@PathVariable long id) {

		employeeServices.removeEmployee(id);

		return "redirect:/employees";
	}

}
