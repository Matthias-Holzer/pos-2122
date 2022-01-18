package at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class QuoteDto {

    private long number;
    private String text;

    @Builder
    public QuoteDto(long number, String text){ setNumber(number); setText(text); }

    @Override
    public String toString(){ return "Quote{" + "number=" +number+ ", text="+text+"}"; }
}
