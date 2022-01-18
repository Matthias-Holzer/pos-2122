package at.spengergasse.holzer.MicroserviceWisdomAnimals.services.client;


import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class AnimalDto {

    private long number;
    private String name;
    private String art;

    @Builder
    public AnimalDto(long number, String name, String art) {
        this.number = number;
        this.name = name;
        this.art = art;
    }
}
