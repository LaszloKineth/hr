package hu.webuni.hr.kinela.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.hr.kinela.model.Companies;
import hu.webuni.hr.kinla.dto.CompanyDto;
import hu.webuni.hr.kinla.dto.EmployeeDto;

@RestController
@RequestMapping("/api/companies")
public class HrCompanyRESTController {
	
	private List<CompanyDto> companies = new ArrayList<>();
	private int idCounter = 1;

	@GetMapping
	public ResponseEntity<List<CompanyDto>> getAllCompanies() {
		return ResponseEntity.ok(companies);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> getCompanieById(@PathVariable int id) {
		return ResponseEntity.ok(companies.stream().filter(comp -> comp.getId() == id).findFirst().get());
	}

	@PostMapping
	public CompanyDto createCompany(@RequestBody CompanyDto company) {
		company.setId(idCounter++);
		companies.add(company);
		return company;
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> modifíCompany(@PathVariable int id, @RequestBody CompanyDto company) {
		CompanyDto tempCompany = company;
		tempCompany.setId(id);
		
		companies.remove(companies.stream().filter(comp -> comp.getId() == id).findFirst().get());
		companies.add(tempCompany);
		
		return ResponseEntity.ok(tempCompany);
	}

	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable int id) {
		companies.remove(companies.stream().filter(comp -> comp.getId() == id).findFirst().get());
	}

	
		
	@PostMapping("/{id}/employees")
	public ResponseEntity<EmployeeDto> addEmployee(@PathVariable int id, @RequestBody EmployeeDto employee) {

		CompanyDto tempCompany = companies.stream().filter(comp -> comp.getId() == id).findFirst().get();
		
		if(tempCompany == null) {
			return ResponseEntity.notFound().build();
		} else {
			tempCompany.getEmployees().add(employee);
			return ResponseEntity.ok(employee);
		}
		
//		
//		for (CompanyDto comp : Companies.getCompanies()) {
//			if(comp.getId() == id) {
//				Companies.removeCompany(id);
//				comp.addEmployee(employee);
//				Companies.addModifiedCompany(comp);
//				break;
//			}
//		}
		
		return ResponseEntity.ok(employee);
	}
	
}