package com.coronatracker.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronatracker.demo.entity.City;
import com.coronatracker.demo.entity.Person;
import com.coronatracker.demo.repository.CityRepository;
import com.coronatracker.demo.repository.PersonRepository;

@Service
public class CityService implements ICityService  {
	@Autowired
	private CityRepository cityRepository;
	//private Optional<City> optional;
	@Autowired
	private PersonRepository personRepository;
	@Override
	public Iterable<City> findAll() {
		
		return cityRepository.findAll();
	}

	@Override
	public City save(City city) {
		 List<City> cities = findByName(city.getName()); 
		if (cities.isEmpty()) {
			return cityRepository.save(city);
		}
		return null;
	}
	@Override
	public int delete(Long id) {
		 cityRepository.deleteById(id);
		 return 1;
	}

	@Override
	public City findById(Long id) {
		Optional<City> optional = cityRepository.findById(id);
		City city = optional.get();
		if (city != null)
			return city;
		else
			return null;
	}

	@Override
	public List<City> findByName(String name) {
		//Optional<City> optional = cityRepository.findByName(name);
		//City city = optional.get();
		List<City> city = cityRepository.findByNameIgnoreCase(name);
		
		//if (city != null)
			return city;
		//else	
		//return null;
	}

	@Override
	public HashMap<String, Integer> findByNumberOfInfectedPeople() {
		HashMap<String, Integer> infected = new HashMap<String, Integer>();
		
		// OBTER TODAS CIDADES DO BANCO
		// PERCORRER CIDADES ADICIONANDO AO HASHMAP (city.getName(), 0)
		Iterable<City> city = cityRepository.findAll();
		for (City city1 : city) {
			
		infected.put(city1.getName(), 0);
		}
		Iterable<Person> person = personRepository.findAll();
		for (Person person1 : person) {
			Integer aux =infected.get(person1.getCity().getName());
			
			infected.put(person1.getCity().getName(), aux+1); 
		}
		
		return  infected;
	}
	//NOVO METODO
    //OBTER TODAS AS CIDADES
    //VERIFICAR QUAL TEM MAIOR numberOfInfectedPeople  

	@Override
	public City maxNumberOfInfectedPeople() {
		Long city1MaxNumber = Long.valueOf(0);
		Iterable<City> cities = findAll();
		City a = new City();
		for (City city1 : cities) {
			if (city1.getNumberOfInfectedPeople() > city1MaxNumber) {
				city1MaxNumber = city1.getNumberOfInfectedPeople();
				a = city1;
				
				
			}
		}
		return a;
		
	}

	@Override
	public String extractCityName(String[] cityNames) {
		String cityName = "";
		for (int i = 0; i <= cityNames.length-2; i++) {
		cityName += cityNames[i]; 
		cityName += " ";
		}
		return cityName;
	}

	@Override
	public void lerDocumento(String csvFile) {
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				
				String[] tentativa1 = line.split(",");
				String cName = tentativa1[2] + " ";
				System.out.println(cName);
				String numberI = tentativa1[4];
				System.out.println(numberI);
				List <City> cidades =  findByName(cName);
				if (cidades.size() == 0) {
					System.out.println("Not Found");
				} else {
					//System.out.println("Found");
					if (cidades.get(0).getNumberOfInfectedPeople() == null) {
						cidades.get(0).setNumberOfInfectedPeople(Long.valueOf(numberI));
						save(cidades.get(0));
					} else {
						System.out.println("Cidade atualizado");
					}
				}
				
				
				br.close();
			}
		} catch (Exception e) {
			
		} finally {
			
		}
	}
	
	   
	 
	
		
	


}

