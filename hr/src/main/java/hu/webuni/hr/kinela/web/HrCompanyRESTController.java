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

import hu.webuni.hr.kinela.mapper.CompanyMapper;
import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.service.CompanyService;
import hu.webuni.hr.kinla.dto.CompanyDto;
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@RestController
@RequestMapping("/api/companies")
public class HrCompanyRESTController {
	
	private int idCounter = 1;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	
	@GetMapping
	public ResponseEntity<List<CompanyDto>> getAllCompanies(@RequestParam(required = false) Boolean full) {
		if(full != null && full) 
			return ResponseEntity.ok(companyMapper.companiesToCompanysDtos(companyService.getAllCompanies(full)));
		else 
			return ResponseEntity.ok(companyMapper.companiesToCompanysDtos(companyService.getAllCompanies(full))
					.stream()
					.map(comp -> new CompanyDto(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> getCompanieById(@PathVariable int id, @RequestParam(required = false) Boolean full) {
		if(full != null && full) 
			return ResponseEntity.ok(companyMapper.companiesToCompanysDtos(companyService.getCompanies()).stream().filter(comp -> comp.getId() == id)
					.findFirst()
					.get());
		else
			return ResponseEntity.ok(companyService.getCompanies()
					.stream()
					.map(comp -> new CompanyDto(comp.getCompanyId(), comp.getCompanyName(), comp.getCompanyAddress(), null))
					.collect(Collectors.toList())
					.stream()
					.filter(comp -> comp.getId() == id)
					.findFirst()
					.get());
	}

	@PostMapping
	public CompanyDto createCompany(@RequestBody CompanyDto company) {
		company.setId(idCounter++);
		companyService.createCompany(companyMapper.companyDtoToCompany(company));
		return company;
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> modifíCompany(@PathVariable int id, @RequestBody CompanyDto company) {
		companyService.modifíCompany(id, companyMapper.companyDtoToCompany(company));
		return ResponseEntity.ok(company);
	}

	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable int id) {
		companyService.deleteCompany(id);
	}
	
	@GetMapping("/{id}/employees")
	public ResponseEntity<List<EmployeeDto>> getEmployees(@PathVariable int id) {
		return ResponseEntity.ok(employeeMapper.employeesToEmployeesDto(companyService.getCompanies().stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().getCompanyEmployees()));
	}
	
	@GetMapping("/{id}/employees/{employeeId}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int id, @PathVariable int employeeId) {
		return ResponseEntity.ok(employeeMapper.employeeToEmployeeDto(companyService.getCompanies().stream().filter(comp -> comp.getCompanyId() == id).findFirst().get().getEmployeeById(employeeId)));
	}
		
	@PostMapping("/{id}/employees")
	public ResponseEntity<EmployeeDto> addEmployee(@PathVariable int id, @RequestBody EmployeeDto employee) {
		companyService.addEmployee(id, employeeMapper.employeeDtoToEmployee(employee));
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("/{id}/employees/{employeeId}")
	public void removeEmployee(@PathVariable int id, @PathVariable int employeeId) {
		companyService.removeEmployee(id, employeeId);
	}
	
}