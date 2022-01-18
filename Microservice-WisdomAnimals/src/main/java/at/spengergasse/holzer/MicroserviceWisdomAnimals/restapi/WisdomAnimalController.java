package at.spengergasse.holzer.MicroserviceWisdomAnimals.restapi;


import at.spengergasse.holzer.MicroserviceWisdomAnimals.service.WisdomAnimalsService;
import at.spengergasse.holzer.MicroserviceWisdomAnimals.services.WisdomAnimalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/wa")
public class WisdomAnimalController {

    private final WisdomAnimalsService wisdomAnimalsService;

    @Autowired
    public WisdomAnimalController(WisdomAnimalsService wisdomAnimalsService) {
        this.wisdomAnimalsService = wisdomAnimalsService;
    }

    @GetMapping("/{number1}/{number2}")
    public Optional<WisdomAnimalDto> generate(@PathVariable("number1") long numberAnimal, @PathVariable("number2") long numberQuote){
        return wisdomAnimalsService.generateWAFor(numberAnimal, numberQuote);
    }
}
