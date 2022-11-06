package hu.webuni.hr.kinela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.webuni.hr.kinela.model.Company;
import hu.webuni.hr.kinela.model.Employee;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	Long countById(long id);

	Company findById(long id);
	
	@Query(value = "DELETE FROM company", nativeQuery = true)
	void clearDB();
	
	@Query(value = "INSERT INTO company (id, name, address, type_id) VALUES (:id, :name, :address, :type_id)", nativeQuery = true)
	void insertTestData(long id, String name, String address, long type_id);
	
	@Query(value = "SELECT c.id, c.address, c.name FROM company c, employee e WHERE e.salary > :limit", nativeQuery = true)
	List<Company> getCompanyWithHigherSalaryThanLimit(int limit);
	
	@Query(value = "SELECT e.title, AVG(e.salary) FROM company c, employee e WHERE c.id=e.company_id AND c.id=:company_id GROUP BY title", nativeQuery = true)
	List<String> getCompanyAvarageSalaryOrderByTitle(long company_id);
}