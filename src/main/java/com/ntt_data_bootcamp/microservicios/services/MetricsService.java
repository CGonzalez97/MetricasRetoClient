package com.ntt_data_bootcamp.microservicios.services;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ntt_data_bootcamp.microservicios.model.Sistema;

@Service
public class MetricsService {
		
	RestTemplate restTemplate = new RestTemplate();
	String urlBase = "http://localhost:8080/actuator/metricas";
	String openEndPoint = "open";
	String closeEndPoint = "close";
	String halfOpen = "half-open";
	URI url = URI.create(urlBase);
	Sistema sys = new Sistema();
	
	public void setToOpen() {
		sys.setStatus(openEndPoint);
		ResponseEntity<String> response
		  = restTemplate.postForEntity(URI.create(urlBase+"/"+openEndPoint), sys, String.class);
	}
	
	public void setToClose() {
		sys.setStatus(openEndPoint);
		ResponseEntity<String> response
		  = restTemplate.postForEntity(URI.create(urlBase+"/"+closeEndPoint), sys, String.class);
	}
	
	public void setToHalfOpen() {
		sys.setStatus(openEndPoint);
		ResponseEntity<String> response
		  = restTemplate.postForEntity(URI.create(urlBase+"/"+halfOpen), sys, String.class);
	}
	
	public String getStatus() {
		ResponseEntity<String> response
		  = restTemplate.getForEntity(url, null);
		return response.getBody();
	}

}
