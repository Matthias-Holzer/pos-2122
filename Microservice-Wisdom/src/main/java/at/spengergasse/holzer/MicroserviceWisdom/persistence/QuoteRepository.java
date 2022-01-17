package at.spengergasse.holzer.MicroserviceWisdom.persistence;

import at.spengergasse.holzer.MicroserviceWisdom.models.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
    Optional<Quote> findByNumber(long number);
    void deleteByNumber(long number);
}
