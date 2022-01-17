package at.spengergasse.holzer.MicroserviceAnimals.persistance;

import at.spengergasse.holzer.MicroserviceAnimals.modules.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    Optional<Animal> findByNumber(long number);
    void deleteByNumber(long number);
}
