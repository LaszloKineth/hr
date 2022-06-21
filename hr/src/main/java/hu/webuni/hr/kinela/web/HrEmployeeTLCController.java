package hu.webuni.hr.kinela.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.mapper.EmployeeMapperImp;
import hu.webuni.hr.kinela.model.EmployeeServices;
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 *
 */

@Controller
public class HrEmployeeTLCController {

	@Autowired
	EmployeeMapperImp employeeMapper;
	
	@GetMapping("/")
	public String home() {
		return "redirect:employees";
	}

	@GetMapping("/employees")
	public String allEmployees(Map<String, Object> model) {
		model.put("employees", employeeMapper.employeesToEmployeesDto(EmployeeServices.getEmployeesList()));
		model.put("newEmployee", new EmployeeDto());

		return "employees";
	}

	@PostMapping("/employees")
	public String addEmployee(EmployeeDto employee) {
		EmployeeServices.addEmployee(employeeMapper.employeeDtoToEmployee(employee));

		return "redirect:employees";
	}

	@GetMapping("/employees/{id}")
	public String modifyEmployee(Map<String, Object> model, @PathVariable int id) {

		model.put("employeeById", employeeMapper.employeeToEmployeeDto(EmployeeServices.getEmployeeByListId(id)));
		
		return "modifyEmployee";
	}
	

	@PostMapping("/modifyEmployee")
	public String updateEmployee(EmployeeDto employee) {
		
		EmployeeServices.modifyEmployee(employeeMapper.employeeDtoToEmployee(employee).getEmloyeeId(), employeeMapper.employeeDtoToEmployee(employee));

		return "redirect:/employees";
	}
	
	
	@GetMapping("/removeEmployee/{id}")
	public String removeEmployee(@PathVariable long id) {

		EmployeeServices.removeEmployee(id);

		return "redirect:/employees";
	}

}
