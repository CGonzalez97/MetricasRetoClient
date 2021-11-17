package com.ntt_data_bootcamp.microservicios.services;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MetricsService {
	
	RestTemplate restTemplate = new RestTemplate();
	String urlBase = "http://localhost:8080/actuator/metricas";
	String openEndPoint = "open";
	String closeEndPoint = "close";
	String halfOpen = "half-open";
	URI url = URI.create(urlBase);
	
	public void setToOpen() {
		ResponseEntity<String> response
		  = restTemplate.postForEntity(URI.create(urlBase+"/"+openEndPoint), openEndPoint, String.class);
	}
	
	public void setToClose() {
		ResponseEntity<String> response
		  = restTemplate.postForEntity(URI.create(urlBase+"/"+closeEndPoint), closeEndPoint, String.class);
	}
	
	public void setToHalfOpen() {
		ResponseEntity<String> response
		  = restTemplate.postForEntity(URI.create(urlBase+"/"+halfOpen), halfOpen, String.class);
	}
	
	public String getStatus() {
		ResponseEntity<String> response
		  = restTemplate.getForEntity(url, null);
		return response.getBody();
	}

}
