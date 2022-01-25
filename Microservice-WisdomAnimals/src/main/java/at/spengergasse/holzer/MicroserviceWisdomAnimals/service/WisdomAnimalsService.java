package at.spengergasse.holzer.MicroserviceWisdomAnimals.service;


import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client.AnimalClient;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client.AnimalDto;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client.QuoteClient;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client.QuoteDto;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.WisdomAnimalDto;
import feign.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WisdomAnimalsService {

    private final QuoteClient quoteClient;
    private final AnimalClient animalClient;

    private static final String RESILIENCE4J_INSTANCE_NAME = "wa-circut_breaker";
    private static final String FALLBACK_METHOD = "fallback";

    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public WisdomAnimalDto generateWAFor(long animalNumber, long quoteNumber){
        Optional<AnimalDto> animalDto = animalClient.findOne(animalNumber);
        Optional<QuoteDto> quoteDto = quoteClient.findOne(quoteNumber);

        Optional<WisdomAnimalDto> wisdomAnimalDto = Optional.ofNullable(WisdomAnimalDto.builder()
                //.numberAnimal(animalDto.get().getNumber())
                //.nameAnimal(animalDto.get().getName())
                .artAnimal(animalDto.get().getArt())
                //.numberQuote(quoteDto.get().getNumber())
                .textQuote(quoteDto.get().getText())
                .build());
        return wisdomAnimalDto.get();
    }

    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public WisdomAnimalDto generateWAForRandom(){
        Optional<AnimalDto> animalDto = animalClient.random();
        Optional<QuoteDto> quoteDto = quoteClient.random();
        Optional<WisdomAnimalDto> wisdomAnimalDto = Optional.ofNullable(WisdomAnimalDto.builder()
                //.numberAnimal(animalDto.get().getNumber())
                //.nameAnimal(animalDto.get().getName())
                .artAnimal(animalDto.get().getArt())
                //.numberQuote(quoteDto.get().getNumber())
                .textQuote(quoteDto.get().getText())
                .build());
        return wisdomAnimalDto.get();
    }

    public WisdomAnimalDto fallback(Exception ex) {
        return WisdomAnimalDto.builder()
                .artAnimal("Envoyer par email \t\n" +
                        "\n" +
                        "             ,\n" +
                        "            /|      __\n" +
                        "           / |   ,-~ /\n" +
                        "          Y :|  //  /\n" +
                        "          | jj /( .^\n" +
                        "          >-\"~\"-v\"\n" +
                        "         /       Y\n" +
                        "        jo  o    |\n" +
                        "       ( ~T~     j\n" +
                        "        >._-' _./\n" +
                        "       /   \"~\"  |\n" +
                        "      Y     _,  |\n" +
                        "     /| ;-\"~ _  l\n" +
                        "    / l/ ,-\"~    \\\n" +
                        "    \\//\\/      .- \\\n" +
                        "     Y        /    Y    -Row\n" +
                        "     l       I     !\n" +
                        "     ]\\      _\\    /\"\\\n" +
                        "    (\" ~----( ~   Y.  )\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~")
                .textQuote("Sometimes things do not work out and the reason has nothing to do with you, or how good you are")
                .build();
    }
}
