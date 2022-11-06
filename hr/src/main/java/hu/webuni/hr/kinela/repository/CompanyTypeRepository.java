package hu.webuni.hr.kinela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.webuni.hr.kinela.model.CompanyType;

public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {

	@Query(value = "DELETE FROM company_type", nativeQuery = true)
	void clearDB();
	
	@Query(value = "INSERT INTO company_type (id, type) VALUES (:id, :type)", nativeQuery = true)
	void insertTestData(long id, String type);
}
