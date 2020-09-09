package com.coronatracker.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronatracker.demo.entity.Country;
import com.coronatracker.demo.repository.CountryRepository;
@Service
public class CountryService implements ICountryService {
	@Autowired
	private CountryRepository countryRepository;
	//@Override
	//public Iterable<Country> findAll() {
	//	return CountryRepository.findAll();
		 
	//}

	@Override
	public int delete(Long id) {
		countryRepository.deleteById(id);
		return 1;
	}

	@Override
	public Country findById(Long id) {
		Optional<Country>optional = countryRepository.findById(id);
		Country country = optional.get();
		if(country != null)
			return country;
		else
			return null;
			
	}

	@Override
	public List<Country> findByName(String name) {
		List<Country>country = countryRepository.findByNameIgnoreCase(name);
		return country;
	}

}
