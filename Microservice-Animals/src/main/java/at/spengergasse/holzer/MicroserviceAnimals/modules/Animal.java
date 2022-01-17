package at.spengergasse.holzer.MicroserviceAnimals.modules;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
@Getter
public class Animal extends AbstractPersistable<Long> {

    @Column(unique = true)
    private long number;
    @Column(length = 128)
    private String name;
    @Column(length = 1000)
    private String art;
    @Builder
    public Animal(Long id, long number, String name, String art) {
        setId(id);
        this.number = number;
        this.name = name;
        this.art = art;
    }
}
