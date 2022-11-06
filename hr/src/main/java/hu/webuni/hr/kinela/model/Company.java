package hu.webuni.hr.kinela.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.mapper.EmployeeMapperMyImp;

@Entity
public class Company {
	
	@Id
	@GeneratedValue 
	private long id;
	
	private String name;
	private String address;

	@JsonIgnore
	@OneToMany(mappedBy = "company") 
	private Collection<Employee> employees;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private CompanyType type;

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

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
