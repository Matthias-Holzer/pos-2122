package at.spengergasse.holzer.MicroserviceWisdomAnimals.service;


import at.spengergasse.holzer.MicroserviceWisdomAnimals.wisdomclient.QuoteClient;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.wisdomclient.QuoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WisdomAnimalsService {

    private static final int QUOTES_PER_ANIMAL = 3;

    private final QuoteClient quoteClient;

    public List<String> generateWAFor(long animalNumber, long quoteNumber1, long quoteNumber2, long quoteNumber3){
        Optional<QuoteDto> quoteDto = quoteClient.findOne(quoteNumber1);

        return null;
    }
}
