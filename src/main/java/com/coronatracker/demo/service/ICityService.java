package com.coronatracker.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.coronatracker.demo.entity.City;

public interface ICityService  {
	
	Iterable<City> findAll();
	
	City save(City city);
	
	int delete(Long id);
	
	City findById(Long id);
	
	List<City> findByName(String name);

	HashMap<String, Integer> findByNumberOfInfectedPeople();
	
	//Entry<String, Integer> maxNumberOfInfectedPeople(Integer maxNumber);
	City maxNumberOfInfectedPeople(); 
	
	String extractCityName(String[] cityNames) ;
	
	void lerDocumento(String csvFile);
}
