package at.spengergasse.holzer.MicroserviceWisdom.service;

import at.spengergasse.holzer.MicroserviceWisdom.models.Quote;
import at.spengergasse.holzer.MicroserviceWisdom.persistence.QuoteRepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;
    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;

        List<Quote> quotes = List.of(
                Quote.builder().number(1).text("The early bird caches the worm").build(),
                Quote.builder().number(2).text("Even the chicken in the pan gets crazy").build(),
                Quote.builder().number(3).text("Live is like a box of chocolates, you are screwed if you have diabetes").build()
        );
        for ( int i=0; i<quotes.size(); i++){
            insert(QuoteDto.fromQuote(quotes.get(i)));
        }
    }



    public List<QuoteDto> findAll(){
        return StreamSupport.stream(quoteRepository.findAll().spliterator(), false)
                .map(QuoteDto::fromQuote)
                .collect(Collectors.toList());
    }

    public QuoteDto findOne(long number){
        return quoteRepository.findByNumber(number)
                .map(QuoteDto::fromQuote)
                .orElse(null);
    }

    public QuoteDto insert(QuoteDto quoteDto){
        return Optional.ofNullable(quoteDto)
                .map(QuoteDto::toQuote)
                .map(quoteRepository::save)
                .map(QuoteDto::fromQuote)
                .orElse(null);
    }

    public QuoteDto replace(long number, QuoteDto quoteDto){
        return Optional.ofNullable(number)
                .flatMap(it -> quoteRepository.findByNumber(number))
                .map(quote -> quoteDto.mergeWith(quote))
                .map(quoteRepository::save)
                .map(QuoteDto::fromQuote)
                .orElse(null);
    }

    public void delete(long number){
        quoteRepository.deleteByNumber(number);
    }

    public QuoteDto random(){
        QuoteDto quoteDto = null;
        while (quoteDto == null){
            long am = quoteRepository.countQuoteByTextIsNotNull();
            int number = (int) (Math.random() * am);
            quoteDto =  quoteRepository.findByNumber(number)
                    .map(QuoteDto::fromQuote)
                    .orElse(null);
        }
        return quoteDto;
    }
}
