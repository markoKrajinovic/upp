package com.project.scientificrepository.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Author extends CoAuthor {

	@Column(nullable = false)
	private String city;
	
	@Column
	private String country;
	
	@Column(unique = true)
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String title;
	
	@OneToMany(mappedBy = "author")
	private List<Thesis> theses;
	
	@ManyToMany
	private List<Magazine> memberships;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Thesis> getTheses() {
		return theses;
	}

	public void setTheses(List<Thesis> theses) {
		this.theses = theses;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public List<Magazine> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<Magazine> memberships) {
		this.memberships = memberships;
	}

	@Override
	public String toString() {
		return "Author [city=" + city + ", country=" + country + ", username=" + username + ", password=" + password
				+ ", title=" + title + ", theses=" + theses + "]";
	}


}
