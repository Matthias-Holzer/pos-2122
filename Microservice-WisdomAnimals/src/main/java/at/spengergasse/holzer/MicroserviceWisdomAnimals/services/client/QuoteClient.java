package at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@FeignClient(name="wisdom-service")
public interface QuoteClient {

    @GetMapping(value = "/quotes/{number}", produces = APPLICATION_JSON_VALUE)
    Optional<QuoteDto> findOne(@PathVariable("number") long number);

}
