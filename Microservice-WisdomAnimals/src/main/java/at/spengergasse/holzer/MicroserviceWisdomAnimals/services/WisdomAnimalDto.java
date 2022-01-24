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
    private String line1 = "";
    private String line2 = "";
    private String line3 = "";
    private String line4 = "";
    private String line5 = "";
    private String textQuote;

    @Builder
    public WisdomAnimalDto(String artAnimal, String textQuote) {
        String[] lines = artAnimal.split("\n");

        this.line1 = lines[0];
        this.line2 = lines[1];
        this.line3 = lines[2];
        this.line4 = lines[3];
        this.line5 = lines[4];
        this.textQuote = textQuote;
    }
}
