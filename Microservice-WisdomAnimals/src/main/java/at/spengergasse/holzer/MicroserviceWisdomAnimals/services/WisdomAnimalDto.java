package at.spengergasse.holzer.MicroserviceWisdomAnimals.services;


import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class WisdomAnimalDto {

    /* V1
    private long numberAnimal;
    private String nameAnimal;
    private String artAnimal;
    private long numberQuote;
    private String textQuote;

    @Builder
    public WisdomAnimalDto(long numberAnimal, String nameAnimal, String artAnimal, long numberQuote, String textQuote) {
        this.numberAnimal = numberAnimal;
        this.nameAnimal = nameAnimal;
        this.artAnimal = artAnimal;
        this.numberQuote = numberQuote;
        this.textQuote = textQuote;
    }
     */
    private String[] art;
    private String textQuote;

    @Builder
    public WisdomAnimalDto(String artAnimal, String textQuote) {
        String[] lines = artAnimal.split("\n");
        this.art = lines;
        this.textQuote = textQuote;
    }
}
