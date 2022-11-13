package hu.webuni.hr.kinela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.webuni.hr.kinela.model.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
	@Query(value = "DELETE FROM position", nativeQuery = true)
	void clearDB();	
	
	@Query(value = "INSERT INTO position (id, min_edu, min_salary, name) VALUES (:id, :minEdu, :minSalary, :name)", nativeQuery = true)
	void addPosition(long id, String name, String minEdu, int minSalary);
}
