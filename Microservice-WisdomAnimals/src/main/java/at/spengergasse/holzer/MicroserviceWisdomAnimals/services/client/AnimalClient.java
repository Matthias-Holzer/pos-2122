package at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "ANIMAL-SERVICE")
public interface AnimalClient {

    @GetMapping(value = "/animals/{number}", produces = APPLICATION_JSON_VALUE)
    Optional<AnimalDto> findOne(@PathVariable long number);

    @GetMapping(value = "/animals/random")
    Optional<AnimalDto> random();
}
