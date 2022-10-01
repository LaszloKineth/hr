package hu.webuni.hr.kinela.repository;

import java.time.LocalDate;
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
	
//	List<Employee> findByStartDateBefore(LocalDate startdate);
	
}
