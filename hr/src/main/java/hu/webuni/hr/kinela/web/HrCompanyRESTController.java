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
import hu.webuni.hr.kinela.repository.CompanyRepository;
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
	
	@GetMapping("/employee/limit/{limit}")
	public ResponseEntity<List<CompanyDto>> getCompanyByOverEmployeeLimit(@PathVariable int limit) {
		return ResponseEntity.ok(companyService.getCompaniesWhereEmployeesOutOfLimit(limit));
	}
	
	@GetMapping("/employee/salary/{salary}")
	public ResponseEntity<List<CompanyDto>> getCompanyByOverSalaryLimit(@PathVariable int salary) {
		return ResponseEntity.ok(companyService.getCompanyByOverSalaryLimit(salary));
	}
	
	@GetMapping("/employee/avg_salary/{company_id}")
	public ResponseEntity<List<String>> getCompanyAvarageSalaryOrderByTitle(@PathVariable long company_id) {
		return ResponseEntity.ok(companyService.getCompanyAvarageSalaryOrderByTitle(company_id));
	}
}