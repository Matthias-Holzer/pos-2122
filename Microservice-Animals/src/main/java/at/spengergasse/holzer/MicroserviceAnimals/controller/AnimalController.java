package at.spengergasse.holzer.MicroserviceAnimals.controller;

import at.spengergasse.holzer.MicroserviceAnimals.service.AnimalDto;
import at.spengergasse.holzer.MicroserviceAnimals.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController extends AbstractPersistable<Long> {

    private final AnimalService animalService;
    
    @Autowired
    public AnimalController(AnimalService animalService){ this.animalService = animalService; }

    @GetMapping
    public List<AnimalDto> findAll(){ return animalService.findAll(); }

    @GetMapping("/{number}")
    public AnimalDto findOne(@PathVariable long number){ return animalService.findOne(number); }

    @PostMapping
    public AnimalDto insert(@RequestBody AnimalDto animalDto){ return animalService.insert(animalDto); }

    @PutMapping(path="/{number}")
    public AnimalDto replace(@PathVariable long number, @RequestBody AnimalDto animalDto){ return animalService.replace(number, animalDto); }

    @DeleteMapping(path="/{number}")
    public void delete(@PathVariable long number){ animalService.delete(number); }

    @GetMapping("/random")
    public AnimalDto findRandom(){ return animalService.random(); }
}
