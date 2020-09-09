package com.coronatracker.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String state;
	private Long numberOfInfectedPeople;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	public List<Person> person;

	public City(Long id, String name, String state, List<Person> person) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.person = person;
	}

	public City() {
		
	}
	
	public City(String name, String state, Long id) {
		super();
		this.name = name;
		this.state = state;
		this.id = id;
	}
	


	public City(Long id, String name, String state, Long numberOfInfectedPeople, List<Person> person) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.numberOfInfectedPeople = numberOfInfectedPeople;
		this.person = person;
	}

	public City(String name, String state) {
		super();
		this.name = name;
		this.state = state;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public Long getNumberOfInfectedPeople() {
		return numberOfInfectedPeople;
	}

	public void setNumberOfInfectedPeople(Long numberOfInfectedPeople) {
		this.numberOfInfectedPeople = numberOfInfectedPeople;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", state=" + state + ", numberOfInfectedPeople="
				+ numberOfInfectedPeople + ", person=" + person + "]";
	}
	

}
