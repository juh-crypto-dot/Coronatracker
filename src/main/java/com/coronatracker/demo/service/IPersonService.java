package com.coronatracker.demo.service;

import com.coronatracker.demo.entity.Person;

public interface IPersonService {
	Iterable<Person> findAll();
	
	Person save(Person person);
	
	int delete(Long id);
	
	Person findById(Long id);
}
