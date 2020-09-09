package com.coronatracker.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronatracker.demo.entity.City;
import com.coronatracker.demo.entity.Person;
import com.coronatracker.demo.repository.CityRepository;
import com.coronatracker.demo.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private CityService cityService;
	
	@Override
	public Iterable<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public int delete(Long id) {
		Person person =	findById(id);
		City city = cityService.findById(person.getCity().getId());
		city.setNumberOfInfectedPeople(city.getNumberOfInfectedPeople()-1);
		cityService.save(city);
		
			personRepository.deleteById(id);
		return 1;
	}

	@Override
	public Person findById(Long id) {
		Optional<Person> optional = personRepository.findById(id);
		Person person = optional.get();
		if (person != null)
		return person;
		else
			return null;
	}

}
