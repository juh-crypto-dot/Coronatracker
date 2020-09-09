package com.coronatracker.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronatracker.demo.entity.City;
import com.coronatracker.demo.service.ICityService;

@RestController
public class CityController {
	@Autowired
	ICityService cityService;
	
	@RequestMapping("/teste")
	public void teste() {
		System.out.println("teste funcionando!");
	}
	@RequestMapping("/juha")
	public void teste2() {
		System.out.println("1,2,3");
	}
	
	@RequestMapping("/cities")
	public Iterable<City> imprimir() {
		return cityService.findAll();
	}
	
	@RequestMapping("/city/add")
	public City addCity(@RequestBody City city) {
		System.out.println(city);	
		
		
		return cityService.save(city);
	}
	@RequestMapping("/city/delete/{id}")
	int delete(@PathVariable String id) {
		
		System.out.println("City deleted");
		cityService.delete(Long.valueOf(id));
		return 1;
	}
	@RequestMapping("/city/findByName/{name}")
	List<City> findByName(@PathVariable String name) {
		return cityService.findByName(name);
		
	}
	@RequestMapping("/city/findByNumberOfInfectedPeople")
	public HashMap<String, Integer> findByNumberOfInfectedPeople() {
		return cityService.findByNumberOfInfectedPeople();
	}
	//@RequestMapping("/city/maxNumberOfInfectedPeople")
	//int maxNumberOfInfectedPeople(@PathVariable int maxEntry) {
	//	return cityService.maxNumberOfInfectedPeople(maxEntry);
	//}
	@RequestMapping("/city/maxNumberOfInfectedPeople")
	public City maxNumberOfInfectedPeople() {
		return cityService.maxNumberOfInfectedPeople();
	}
	
}
