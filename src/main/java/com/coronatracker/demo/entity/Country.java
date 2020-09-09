package com.coronatracker.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties
@Entity
public class Country implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@JsonProperty("Country")
	String name;
	
	@JsonProperty("CountryCode")
	String countryCode;
	
	@JsonProperty("TotalConfirmed")
	Integer totalConfirmed;
	
	public Country() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(Integer totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", countryCode=" + countryCode + ", totalConfirmed=" + totalConfirmed + "]";
	}

	
	

}
