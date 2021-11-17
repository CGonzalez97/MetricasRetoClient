package com.ntt_data_bootcamp.microservicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ntt_data_bootcamp.microservicios.model.Sistema;
import com.ntt_data_bootcamp.microservicios.services.MetricsService;

@SpringBootApplication
public class MicroserviciosSpringMetricasRetoClientApplication implements CommandLineRunner {

	@Autowired
	MetricsService servicio;
	
	Logger logger = LoggerFactory.getLogger(MicroserviciosSpringMetricasRetoClientApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosSpringMetricasRetoClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String open = "open";
		String close = "close";
		String halfOpen = "half-open";
		Sistema sys = new Sistema("open");
		
		for(int i = 0; i < 5; i++) {
			sys.setStatus(halfOpen);
			servicio.setToHalfOpen();
			logger.info(halfOpen);
			Thread.sleep(2000);
			if(i <= 3) {
				sys.setStatus(open);
				servicio.setToOpen();
				logger.info(open);
				Thread.sleep(2000);
			}else {
				sys.setStatus(close);
				servicio.setToClose();
				logger.info(close);
				Thread.sleep(2000);
			}
		}
		
	}

}
