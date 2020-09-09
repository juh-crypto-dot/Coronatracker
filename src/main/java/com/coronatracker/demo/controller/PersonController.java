package com.coronatracker.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronatracker.demo.entity.City;
import com.coronatracker.demo.entity.Person;
import com.coronatracker.demo.service.ICityService;
import com.coronatracker.demo.service.IPersonService;

@RestController
public class PersonController {
	@Autowired
	IPersonService personService;
	@Autowired
	ICityService cityService;
	
@RequestMapping("/person/add")
public Person addPerson(@RequestBody Person person) {
	
	City city = cityService.findById(Long.valueOf(person.getCity().getId()));
	if(city!= null) {
		city.setNumberOfInfectedPeople(city.getNumberOfInfectedPeople()+1);
		
		return personService.save(person);	
	} else {
		return new Person();
	}
	
}
@RequestMapping("/people")
public Iterable<Person> print() {
	return personService.findAll();
}
@RequestMapping("/person/delete/{id}")
int delete(@PathVariable String id) {
	
	System.out.println("Deleted");
	personService.delete(Long.valueOf(id));
	return 1;
	
}
@RequestMapping("/person/{id}")
public int contPessoas(@PathVariable String id) {
Iterable<Person> person = personService.findAll();
int cont = 0;
for (Person p : person) {
	if ( p.getCity().getId() == Long.valueOf(id)) {
		cont++;
	}
	

}

	return cont;
	
}
}