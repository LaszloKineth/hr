package hu.webuni.hr.kinela.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import hu.webuni.hr.kinla.dto.EmployeeDto;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

@RestController
@RequestMapping("/api/companies")
public class HrCompanyRESTController {
	
	private List<CompanyDto> companies = new ArrayList<>();
	private int idCounter = 1;

	@GetMapping
	public ResponseEntity<List<CompanyDto>> getAllCompanies(@RequestParam(required = false) Boolean full) {
		if(full != null && full) 
			return ResponseEntity.ok(companies);
		else 
			return ResponseEntity.ok(companies
					.stream()
					.map(comp -> new CompanyDto(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> getCompanieById(@PathVariable int id, @RequestParam(required = false) Boolean full) {
		if(full != null && full) 
			return ResponseEntity.ok(companies.stream().filter(comp -> comp.getId() == id)
					.findFirst()
					.get());
		else
			return ResponseEntity.ok(companies
					.stream()
					.map(comp -> new CompanyDto(comp.getId(), comp.getName(), comp.getAddress(), null))
					.collect(Collectors.toList())
					.stream()
					.filter(comp -> comp.getId() == id)
					.findFirst()
					.get());
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

	
	@GetMapping("/{id}/employees")
	public ResponseEntity<List<EmployeeDto>> getEmployees(@PathVariable int id) {
		return ResponseEntity.ok(companies.stream().filter(comp -> comp.getId() == id).findFirst().get().getEmployees());
	}
	
	@GetMapping("/{id}/employees/{employeeId}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int id, @PathVariable int employeeId) {
		return ResponseEntity.ok(companies.stream().filter(comp -> comp.getId() == id).findFirst().get().getEmployeeById(employeeId));
	}
		
	@PostMapping("/{id}/employees")
	public ResponseEntity<EmployeeDto> addEmployee(@PathVariable int id, @RequestBody EmployeeDto employee) {

// VERZIÓ 1. - Ez a Null Pointer Exception-re fut. Nem tudom miért 
		companies.stream().filter(comp -> comp.getId() == id).findFirst().get().addEmployee(employee); // Én így próbáltam. Egy EmployeeDto-t adnék fel a listának és erre jön a Null Pointer Exception 

		
// VERZIÓ 2. Ez működik, de én máshogy csinálnám, mert elvesznek a már meglévők
//		companies.stream().filter(comp -> comp.getId() == id).findFirst().get().setEmployees(employees); // Ez működik, így csináltad te is, de itt a teljes listát kicseréljük, azaz, ha nem írod bele újra a már bent lévőket, akkor elvesznek.
		
// VERZIÓ 3. Megkerülés, de nem szép megoldás		
//		List<EmployeeDto> emp = companies.stream().filter(comp -> comp.getId() == id).findFirst().get().getEmployees();
//		emp.add(employee);
//		companies.stream().filter(comp -> comp.getId() == id).findFirst().get().setEmployees(emp);
		
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("/{id}/employees/{employeeId}")
	public void removeEmployee(@PathVariable int id, @PathVariable int employeeId) {
		companies.stream().filter(comp -> comp.getId() == id).findFirst().get().removeEmployeeById(employeeId);
	}
	
}