package hu.webuni.hr.kinela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.webuni.hr.kinela.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Long countById(String iata);
	
	void updateEmployeeWhereId(Long id, Employee employee);
}
