package hu.webuni.hr.kinla.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;


/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com 
 *
 */

public class EmployeeDto {

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
	private LocalDateTime startDateOfWork;
	
	public EmployeeDto(long id, String name, String title, int salary, LocalDateTime startDateOfWork) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.salary = salary;
		setStartDateOfWork(startDateOfWork);
	}
	
	public EmployeeDto() {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDateTime getStartDateOfWork() {
		return startDateOfWork;
	}

	public void setStartDateOfWork(LocalDateTime startDateOfWork) {
		this.startDateOfWork = startDateOfWork;
	}

}
