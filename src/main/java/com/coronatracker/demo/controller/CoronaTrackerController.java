package com.coronatracker.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coronatracker.demo.entity.City;
import com.coronatracker.demo.service.ICityService;

@RestController
public class CoronaTrackerController {
	@Autowired
	ICityService cityService;
	@RequestMapping("/getAPI")
	public void getAPI() {
		//final String URL = "https://bigdata-covid19.icict.fiocruz.br";
				 //"https://api.covid19api.com/summary";
			final String URL = "https://bigdata-api.fiocruz.br/relatorios/";
		RestTemplate restTemplate = new RestTemplate();
		String resposta = restTemplate.getForObject(URL, String.class);
		String[] cidades = resposta.split("\n");
		//Global global = restTemplate.getForObject(URL, Global.class);
		//System.out.println(Arrays.toString(cidades));
		for ( String  c  : cidades) {
			//String[] a = c.split("#Mun BR"); 
			if (c.contains("#Mun BR")) {
				//System.out.println(c);
				String[] a = c.split("<option value=\"#Mun BR:\\s");
				//System.out.println(Arrays.toString(a));
				//System.out.println(a[1]); 
				String[] b = a[1].split("\"");
				//System.out.println(b[0]);
				
				String[] d = b[0].split("\\s");
				//cityService.extractCityName(d);
				String cityNames =cityService.extractCityName(d);
				//System.out.println(cityNames);
				
				int ultimoD = d.length-1;
				String estados = d[ultimoD];
				//System.out.println(estados);
				
				
				City x = new City(cityNames, estados);
				cityService.save(x);
				System.out.println("Cidades e estados salvos: " + x);
				 
			}
					
		}
		//String [] link = resposta.split("\\s");  //whitespace
		//System.out.println(Arrays.toString(link));
		//	for (String linkRef1 : link) {
		//		if(linkRef1.contains("html")) {
		//			String[] linkRef2;
		//			linkRef2 = linkRef1.split("html");
		//			String part1 = linkRef2[0];
		//			String part2 = linkRef2[1];
		//			System.out.println(part1);
					//return;
		//		} else {
		//			System.out.println("NOT");
				}
						
		//	}
		
	//} 
	@RequestMapping("/getInfectedFromCSV")
	public void getInfectedFromCSV() {
		String  doc = "C:\\Users\\juha\\spring-workspace\\demo\\caso.csv";
		cityService.lerDocumento(doc);
		
	}
}

