package hu.webuni.hr.kinela.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.mapper.EmployeeMapperMyImp;

@Entity
public class Company {
	
	@Id
	@GeneratedValue 
	private long id;
	
	private String name;
	private String address;

	@OneToMany(mappedBy = "company")
	private List<Employee> employees;
	
	public Company(int id, String name, String address, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.employees = employees;
	}

	public Company() {
		super();
	}

	public Employee getEmployeeById(int id) {
		return employees.stream().filter(emp -> emp.getEmployeeId() == id).findFirst().get();

	}
	
	public void removeEmployeeById(int id) {
		employees.remove(employees.stream().filter(emp -> emp.getEmployeeId() == id).findFirst().get());
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
