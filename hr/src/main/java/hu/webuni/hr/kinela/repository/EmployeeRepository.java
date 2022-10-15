package hu.webuni.hr.kinela.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.webuni.hr.kinela.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Long countById(String iata);
	
//	@Query(value = "SELECT * FROM employee WHERE title=:title", nativeQuery = true)
//	List<Employee> getEmployeesWithTitle(String title);
	
	List<Employee> findByTitle(String title);
	
	@Query(value = "SELECT * FROM employee WHERE name ILIKE :namestarts%", nativeQuery = true)
	List<Employee> findEmployeesWhosNameStartWith(String namestarts);
	
//	List<Employee> findByNameStartingWithIgnoreCase(String namestarts);
	
	@Query(value = "SELECT * FROM employee WHERE startdate BETWEEN :startdate AND :enddate", nativeQuery = true)
	List<Employee> findEmployeesWhosStartBetween(LocalDateTime startdate, LocalDateTime enddate);
	
//	List<Employee> findByStartDateBetween(LocalDateTime fromdate, LocalDateTime todate);
	
	@Query(value = "SELECT * FROM company c JOIN employee e ON c.id=e.company_id", nativeQuery = true)
	List<Employee> getAllCompanyWithEmployees();
}
