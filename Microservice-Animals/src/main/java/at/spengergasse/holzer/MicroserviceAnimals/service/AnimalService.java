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
    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;

        List<Animal> animals = List.of(
                Animal.builder().number(1).name("cat").art("  /\\_/\\  (\n" +
                        " ( ^.^ ) _)\n" +
                        "   \\\"/  (\n" +
                        " ( | | )\n" +
                        "(__d b__)").build(),
                Animal.builder().number(2).name("dog").art("   / \\__\n" +
                        "  (    @\\___\n" +
                        "  /         O\n" +
                        " /   (_____/\n" +
                        "/_____/   U").build(),
                Animal.builder().number(3).name("bat").art("       (_    ,_,    _) \n" +
                        "       / `'--) (--'` \\\n" +
                        "      /  _,-'\\_/'-,_  \\\n" +
                        "     /.-'     \"     '-.\\\n" +
                        "   ").build(),
                Animal.builder().number(4).name("whale").art(
                        "                   \\    /\n" +
                        "                    \\  /\n" +
                        "|\\\\  //|             ||\n" +
                        " \\ \\/  /             ||\n" +
                        "  |   |              ||\n" +
                        "  |   |              ||\n" +
                        "   \\   \\------------------------\\\n" +
                        "    \\                       o    \\\n" +
                        "     \\-                           \\\n" +
                        "      \\                 \\__________\\\n" +
                        "       \\-                          /        Adam at Caltech\n" +
                        "         \\________________________/").build()
        );
        for ( int i=0; i<animals.size(); i++){
            insert(AnimalDto.fromAnimal(animals.get(i)));
        }
    }



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

    public AnimalDto random(){
        AnimalDto animalDto = null;
        while (animalDto == null) {
            long qty = animalRepository.countAnimalsByArtIsNotNull();
            int number = (int) (Math.random() * qty);
            animalDto = animalRepository.findByNumber(number)
                    .map(AnimalDto::fromAnimal)
                    .orElse(null);
        }
        return animalDto;
    }
}
