package at.spengergasse.holzer.MicroserviceAnimals.service;

import at.spengergasse.holzer.MicroserviceAnimals.modules.Animal;
import at.spengergasse.holzer.MicroserviceAnimals.persistance.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository){ this.animalRepository = animalRepository; }

    private List<Animal> animals = List.of(
            Animal.builder().number(234).name("turtle").art("asdf").build(),
            Animal.builder().number(23).name("turtle").art("asdf").build(),
            Animal.builder().number(4).name("turtle").art("asdf").build(),
            Animal.builder().number(14).name("turtle").art("asdf").build()
    );

    public List<AnimalDto> findAll(){
        return StreamSupport.stream(animalRepository.findAll().spliterator(), false)
                .map(AnimalDto::fromAnimal)
                .collect(Collectors.toList());
    }

    public AnimalDto findOne(long number){
        return animalRepository.findByNumber(number)
                .map(AnimalDto::fromAnimal)
                .orElse(null);
    }
    public AnimalDto insert(AnimalDto animalDto){
        return Optional.ofNullable(animalDto)
                .map(AnimalDto::toAnimal)
                .map(animalRepository::save)
                .map(AnimalDto::fromAnimal)
                .orElse(null);
    }
    public AnimalDto replace(long number, AnimalDto animalDto){
        return Optional.ofNullable(number)
                .flatMap(it -> animalRepository.findByNumber(number))
                .map(animal -> animalDto.mergeWith(animal))
                .map(animalRepository::save)
                .map(AnimalDto::fromAnimal)
                .orElse(null);
    }
    public void delete(long number){animalRepository.deleteByNumber(number);}
}
