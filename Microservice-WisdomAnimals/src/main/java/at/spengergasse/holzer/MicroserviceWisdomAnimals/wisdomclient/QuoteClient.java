package at.spengergasse.holzer.MicroserviceWisdomAnimals.wisdomclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name="wisdom-service")
public interface QuoteClient {

    @GetMapping
    public List<QuoteDto> findAll();

    @GetMapping(value = "/quotes/{number}", produces = APPLICATION_JSON_VALUE)
    Optional<QuoteDto> findOne(@PathVariable long number);

}
