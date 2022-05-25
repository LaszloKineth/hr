package hu.webuni.hr.kinla.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmployeeDto {


	private long id;
	private String name;
	private String title;
	private int salary;
	private LocalDateTime startDateOfWork;
	private String datePattern = "yyyy-MM-dd HH:mm";

	public EmployeeDto(long id, String name, String title, int salary, LocalDateTime startDateOfWork) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.salary = salary;
		this.startDateOfWork = startDateOfWork;
	}

	public EmployeeDto(long id, String name, String title, int salary, String startDateOfWork) {
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

	public void setStartDateOfWork(String startDateOfWork) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getDatePattern());
		this.startDateOfWork = LocalDateTime.parse(startDateOfWork, formatter);
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	
}
