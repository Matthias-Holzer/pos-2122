package at.spengergasse.holzer.MicroserviceWisdom.controller;

import at.spengergasse.holzer.MicroserviceWisdom.models.Quote;
import at.spengergasse.holzer.MicroserviceWisdom.persistence.QuoteRepository;
import at.spengergasse.holzer.MicroserviceWisdom.service.QuoteDto;
import at.spengergasse.holzer.MicroserviceWisdom.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) { this.quoteService = quoteService; }

    @GetMapping
    public List<QuoteDto> findAll(){ return quoteService.findAll(); }

    @GetMapping("/{number}")
    public QuoteDto findOne(@PathVariable long number){ return quoteService.findOne(number); }

    @PostMapping
    public QuoteDto insert(@RequestBody QuoteDto quoteDto){ return quoteService.insert(quoteDto); }

    @PutMapping(path="/{number}")
    public QuoteDto replace(@PathVariable long number, @RequestBody QuoteDto quoteDto){ return quoteService.replace(number, quoteDto); }

    @DeleteMapping(path="/{number}")
    public void delete(@PathVariable long number){ quoteService.delete(number); }

    @GetMapping(path = "/random")
    public QuoteDto findRandom(){
        return quoteService.random();
    }
}
