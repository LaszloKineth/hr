package hu.webuni.hr.kinela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.webuni.hr.kinela.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	Long countById(long id);

	Company findById(long id);
}
