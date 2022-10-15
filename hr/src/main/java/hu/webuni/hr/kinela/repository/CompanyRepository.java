package hu.webuni.hr.kinela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.webuni.hr.kinela.model.Company;
import hu.webuni.hr.kinela.model.Employee;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	Long countById(long id);

	Company findById(long id);
}
