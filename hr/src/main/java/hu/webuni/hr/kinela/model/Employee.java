package hu.webuni.hr.kinela.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="company_id", insertable = false, updatable = false)
	private Company company;
	
	@NotEmpty(message = "Name cannot be empty.")
	@NotBlank
	private String name;
	
	@NotEmpty(message = "Titel cannot be empty.")
	@NotBlank
	private String title;
	
	@Positive(message = "Salary must be a pozitive number.")
	private int salary;
	
	@Past(message ="The entry date must be in past")
	private LocalDateTime startdate;
	
	private long company_id;
	
	@ManyToOne
	private Position position;
		
	public long getEmployeeId() {
		return id;
	}

	public void setEmployeeId(long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return name;
	}

	public void setEmployeeName(String name) {
		this.name = name;
	}

	public int getEmployeeSalary() {
		return salary;
	}

	public void setEmployeeSalary(int salary) {
		this.salary = salary;
	}

	public LocalDateTime getEmployeeStartDateOfWork() {
		return startdate;
	}

	public void setEmployeeStartDateOfWork(LocalDateTime startdate) {
		this.startdate = startdate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public long getCompany_id() {
		return company_id;
	}

	public void setCompany_id(long company_id) {
		this.company_id = company_id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
