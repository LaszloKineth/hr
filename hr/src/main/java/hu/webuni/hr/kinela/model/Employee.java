package hu.webuni.hr.kinela.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 *
 */

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private long id;
	
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

	
	
	public Employee() {
	}

//	public Employee(long id, String name, String title, int salary,
//			LocalDateTime startdate) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.title = title;
//		this.salary = salary;
//		this.startdate = startdate;
//	}
//
//	public Employee(long id, String name, String title, int salary,
//			String startdate) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.title = title;
//		this.salary = salary;
//		setStartDateOfWork(startdate);
//	}
//	
//	public Employee() {}
//
//	public void setStartDateOfWork(String startDateOfWork) {
//		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//		this.startdate = LocalDateTime.parse(startDateOfWork, formatter);
//	}

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

	public String getEmployeeTitle() {
		return title;
	}

	public void setEmployeeTitle(String title) {
		this.title = title;
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

}
