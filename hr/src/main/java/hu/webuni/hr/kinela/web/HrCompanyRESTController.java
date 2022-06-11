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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.hr.kinela.model.Companies;
import hu.webuni.hr.kinla.dto.CompanyDto;

@RestController
@RequestMapping("/api/companies")
public class HrCompanyRESTController {

	@GetMapping
	public ResponseEntity<List<CompanyDto>> getAllCompanies() {
		return ResponseEntity.ok(Companies.getCompanies());
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<CompanyDto>> getCompanieById(@PathVariable long id) {
		return ResponseEntity.ok(Companies.getCompanies());
	}

	@PostMapping
	public CompanyDto createCompany(@RequestBody CompanyDto company) {
		Companies.addCompany(company);
		return company;
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> modifíCompany(@PathVariable int id, @RequestBody CompanyDto company) {
		Companies.modifyCompany(company);
		return ResponseEntity.ok(company);
	}

	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable int id) {
		Companies.removeCompany(Companies.getCompanyById(id));
	}
	
}
