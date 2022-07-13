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
	@NotEmpty(message = "Salary cannot be empty.")
	@NotBlank
	@Positive(message = "Salary must be a pozitive number.")
	private int salary;
	@NotEmpty(message = "Entry date cannot be empty.")
	@NotBlank
	@Past(message ="The entry date must be in past")
	private LocalDateTime startDateOfWork;
	
	public EmployeeDto(@NotEmpty @NotBlank @Positive long id, @NotEmpty @NotBlank String name, @NotEmpty @NotBlank String title, @NotEmpty @NotBlank @Positive int salary, LocalDateTime startDateOfWork) {
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

	public void setId(@NotEmpty @NotBlank @Positive long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(@NotEmpty @NotBlank String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(@NotEmpty @NotBlank String title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(@NotEmpty @NotBlank @Positive int salary) {
		this.salary = salary;
	}

	public LocalDateTime getStartDateOfWork() {
		return startDateOfWork;
	}

	public void setStartDateOfWork(@NotEmpty @NotBlank @Past LocalDateTime startDateOfWork) {
		this.startDateOfWork = startDateOfWork;
	}

}
