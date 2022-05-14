package hu.webuni.hr.kinela.model;

import java.time.LocalDateTime;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 *
 */

public class Employee {
	
	private long id;
	private String name;
	private String title;
	private int salary;
	private LocalDateTime startDateOfWork;
	
	public Employee(long id, String name, String title, int salary, LocalDateTime startDateOfWork) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.salary = salary;
		this.startDateOfWork = startDateOfWork;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
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
