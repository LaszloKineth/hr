package hu.webuni.hr.kinela.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Position {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String minEdu;
	private int minSalary;
	@OneToMany(mappedBy = "position")
	private Collection<Employee> employees;
	
	public Position() {
		super();
	}

	public Position(long id, String name, String minEdu, int minSalary) {
		this.id = id;
		this.name = name;
		this.minEdu = minEdu;
		this.minSalary = minSalary;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMinEdu() {
		return minEdu;
	}
	public void setMinEdu(String minEdu) {
		this.minEdu = minEdu;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
}
