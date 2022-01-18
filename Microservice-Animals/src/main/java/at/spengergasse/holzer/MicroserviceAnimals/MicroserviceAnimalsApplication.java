package at.spengergasse.holzer.MicroserviceAnimals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceAnimalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAnimalsApplication.class, args);
	}

}
