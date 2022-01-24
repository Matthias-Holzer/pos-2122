package at.spengergasse.holzer.MicroserviceWisdomAnimals.service;


import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client.AnimalClient;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client.AnimalDto;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client.QuoteClient;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client.QuoteDto;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.WisdomAnimalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WisdomAnimalsService {

    private final QuoteClient quoteClient;
    private final AnimalClient animalClient;

    public WisdomAnimalDto generateWAFor(long animalNumber, long quoteNumber){
        Optional<AnimalDto> animalDto = animalClient.findOne(animalNumber);
        Optional<QuoteDto> quoteDto = quoteClient.findOne(quoteNumber);

        System.out.println("HIIIER____________");

        Optional<WisdomAnimalDto> wisdomAnimalDto = Optional.ofNullable(WisdomAnimalDto.builder()
                .numberAnimal(animalDto.get().getNumber())
                .nameAnimal(animalDto.get().getName())
                .artAnimal(animalDto.get().getArt())
                .numberQuote(quoteDto.get().getNumber())
                .textQuote(quoteDto.get().getText())
                .build());
        return wisdomAnimalDto.get();
    }
}
