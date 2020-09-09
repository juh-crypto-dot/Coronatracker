package com.coronatracker.demo.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coronatracker.demo.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

	List<City> findByNameIgnoreCase(String name);

	//Optional<City> findByName(String name);
	

}
