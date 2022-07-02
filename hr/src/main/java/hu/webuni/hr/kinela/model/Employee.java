package hu.webuni.hr.kinela.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Laszlo Kineth (kinela) - kinela77<at>gmail.com
 *
 */

public class Employee {

	private long employeeId;
	private String employeeName;
	private String employeeTitle;
	private int employeeSalary;
	private LocalDateTime employeeStartDateOfWork;

	
	
	public Employee(long employeeId, String employeeName, String employeeTitle, int employeeSalary,
			LocalDateTime employeeStartDateOfWork) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeTitle = employeeTitle;
		this.employeeSalary = employeeSalary;
		this.employeeStartDateOfWork = employeeStartDateOfWork;
	}

	public Employee(long employeeId, String employeeName, String employeeTitle, int employeeSalary,
			String employeeStartDateOfWork) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeTitle = employeeTitle;
		this.employeeSalary = employeeSalary;
		setStartDateOfWork(employeeStartDateOfWork);
	}
	
	public Employee() {}

	public void setStartDateOfWork(String startDateOfWork) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		this.employeeStartDateOfWork = LocalDateTime.parse(startDateOfWork, formatter);
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeTitle() {
		return employeeTitle;
	}

	public void setEmployeeTitle(String employeeTitle) {
		this.employeeTitle = employeeTitle;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public LocalDateTime getEmployeeStartDateOfWork() {
		return employeeStartDateOfWork;
	}

	public void setEmployeeStartDateOfWork(LocalDateTime employeeStartDateOfWork) {
		this.employeeStartDateOfWork = employeeStartDateOfWork;
	}

}
