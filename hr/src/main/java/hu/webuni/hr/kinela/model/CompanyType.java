package hu.webuni.hr.kinela.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CompanyType {
	@Id
	@GeneratedValue
	private long id;
	
	public String type;

	@OneToMany(mappedBy = "type")
	private Collection<Company> companies;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
