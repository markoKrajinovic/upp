package com.project.scientificrepository.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;




@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CoAuthor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Column
	protected String firstName;
	
	@Column
	protected String lastName;

	@Column
	protected String eMail;
	
	@Column
	protected String address;

	@ManyToMany(mappedBy = "coAuthors")
	private List<Thesis> theses;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Thesis> getTheses() {
		return theses;
	}

	public void setTheses(List<Thesis> theses) {
		this.theses = theses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Thesis> getThesesCoAuthored() {
		return theses;
	}

	public void setThesesCoAuthored(List<Thesis> theses) {
		this.theses = theses;
	}

}
