package hu.webuni.hr.kinela.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.hr.kinela.dto.CompanyDto;
import hu.webuni.hr.kinela.dto.EmployeeDto;
import hu.webuni.hr.kinela.mapper.CompanyMapper;
import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.model.Company;
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
		return ResponseEntity.ok(companyMapper.companiesToCompanysDtos(companyService.getCompanies()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable long id) {
		return ResponseEntity.ok((companyMapper.companyToCompanyDto(companyService.getCompanieById(id))));
	}

	@PostMapping
	public void createCompany(@RequestBody CompanyDto company) {
		companyService.addCompanie(companyMapper.companyDtoToCompany(company));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> modifíCompany(@PathVariable long id, @RequestBody CompanyDto company) {
		companyService.modifíCompany(id, companyMapper.companyDtoToCompany(company));
		return ResponseEntity.ok(company);
	}

	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable int id) {
		companyService.deleteCompany(id);
	}

	@GetMapping("/{id}/employees")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable long id) {
		return ResponseEntity.ok(employeeMapper.employeeToEmployeeDto(employeeServices.getEmployeeById(id)));
	}

	@PostMapping("/{id}/employees")
	public ResponseEntity<EmployeeDto> addEmployee(@PathVariable long id, @RequestBody EmployeeDto employee) {
		employeeServices.addEmployee(employeeMapper.employeeDtoToEmployee(employee));
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{id}/employees/{employeeId}")
	public void removeEmployee(@PathVariable long id) {
		employeeServices.removeEmployee(id);
	}
	
}