package hu.webuni.hr.kinela.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.hr.kinela.dto.CompanyDto;
import hu.webuni.hr.kinela.dto.EmployeeDto;
import hu.webuni.hr.kinela.mapper.CompanyMapper;
import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.model.Company;
import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinela.service.CompanyService;
import hu.webuni.hr.kinela.service.EmployeeServices;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@RestController
@RequestMapping("/api/companies")
public class HrCompanyRESTController {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	EmployeeServices employeeServices;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	@GetMapping
	public ResponseEntity<List<CompanyDto>> getAllCompanies() {
		return ResponseEntity.ok(companyService.getCompanies());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable long id) {
		return ResponseEntity.ok(companyService.getCompanieById(id));
	}
	
	@GetMapping("/employees/all")
	public ResponseEntity<List<EmployeeDto>> getAllEmployeWithCompanyId() {
		return ResponseEntity.ok(employeeMapper.employeesToEmployeesDto(employeeServices.getEmployeesList()));
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable long id) {
		return ResponseEntity.ok(employeeMapper.employeeToEmployeeDto(employeeServices.getEmployeeById(id)));
	}
	
	@PostMapping
	public void addCompany(@RequestBody Company company) {
		companyService.addCompanie(company);
	}

	@PostMapping("/employee")
	public void addEmployeeToCompany(@RequestBody EmployeeDto employee) {
		employeeServices.addEmployee(employeeMapper.employeeDtoToEmployee(employee));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Company> modifíCompanyById(@PathVariable long id, @RequestBody Company company) {
		companyService.modifíCompany(id, company);
		return ResponseEntity.ok(company);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> modifyEmployeeById(@PathVariable long id, @RequestBody EmployeeDto employee) {
		employeeServices.modifyEmployee(id, employeeMapper.employeeDtoToEmployee(employee));
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{id}")
	public void removeCompanyById(@PathVariable long id) {
		companyService.removeCompany(id);
	}

	@DeleteMapping("/employee/{id}")
	public void removeEmployeeById(@PathVariable long id) {
		employeeServices.removeEmployee(id);
	}

//	@PostMapping("/employees/{id}")
//	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee, @PathVariable long id) {
//		employee.setCompany_id(id);
//		employeeServices.addEmployee(employee);
//		return ResponseEntity.ok(employee);
//	}
}