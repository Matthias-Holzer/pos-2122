package at.spengergasse.holzer.MicroserviceWisdomAnimals;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class MicroserviceWisdomAnimalsApplication {

	@Bean
	public ObjectMapper objectMapper(){ return new ObjectMapper(); }

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceWisdomAnimalsApplication.class, args);
	}

}
