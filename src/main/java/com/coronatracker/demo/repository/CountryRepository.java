package com.coronatracker.demo.repository;

import java.util.List;

//import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coronatracker.demo.entity.Country;
//import com.coronatracker.demo.service.Optional;
@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {

	public default Iterable<Country> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public default void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	//public Optional<Country> findById(Long id) {
		// TODO Auto-generated method stub
	//	return null;
	//}

	public List<Country> findByNameIgnoreCase(String name);

}
 