package com.revature;

import org.springframework.web.client.RestTemplate;

import com.revature.models.Dinosaur;

public class Driver {

	public static void main(String[] args) {
		String requestUrl = "http://192.168.51.112:8082/dinos/10";
		
		//Create an instance of RestTemplate, provided by Spring Web which allows us to 
		// make http request with Java
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			Dinosaur d = restTemplate.getForObject(requestUrl, Dinosaur.class);
			System.out.println(d);
			System.out.println("resource consumption successful");
		} catch (Exception e) {
			System.out.println("resource consumption unsuccessful");
		}
		
		
		String postRequestUrl = "http://192.168.51.112:8082/dinos";
		Dinosaur newDino = new Dinosaur(10,"Paulina",true,"Brontosaurus");
		
//		try {
//			restTemplate.postForObject(postRequestUrl, newDino, Dinosaur.class);
//			System.out.println("resource exchange successful");
//			System.out.println("added: "+ newDino);
//		} catch (Exception e) {
//			System.out.println("resource exchange unsuccessful");
//		}
		
		
		

	}

}
