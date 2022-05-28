package hu.webuni.hr.kinla.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmployeeDto {


	private long id;
	private String name;
	private String title;
	private int salary;
	private LocalDateTime startDateOfWork;
	private String modifyLink;

	public EmployeeDto(long id, String name, String title, int salary, LocalDateTime startDateOfWork, String defaultLink) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.salary = salary;
		this.startDateOfWork = startDateOfWork;
		this.modifyLink = defaultLink + id;
	}

	public EmployeeDto(long id, String name, String title, int salary, String startDateOfWork, String defaultLink) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.salary = salary;
		setStartDateOfWork(startDateOfWork);
		this.modifyLink = defaultLink + id;
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

//	public void setStartDateOfWork(LocalDateTime startDateOfWork) {
//		this.startDateOfWork = startDateOfWork;
//	}

	public void setStartDateOfWork(String startDateOfWork) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.startDateOfWork = LocalDateTime.parse(startDateOfWork, formatter);
	}

	public String getModifyLink() {
		return modifyLink;
	}

	public void setModifyLink(String modifyLink) {
		this.modifyLink = modifyLink;
	}
	
}
