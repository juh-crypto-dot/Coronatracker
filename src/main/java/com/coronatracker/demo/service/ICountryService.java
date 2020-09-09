package com.coronatracker.demo.service;

import java.util.List;

import com.coronatracker.demo.entity.Country;

public interface ICountryService {
	//Iterable<Country>findAll();
	//Country save(Country country)
	int delete(Long id);
	Country findById(Long id);
	
	List<Country>findByName(String name);
	//HashMap<String, Integer> ();
	
}
