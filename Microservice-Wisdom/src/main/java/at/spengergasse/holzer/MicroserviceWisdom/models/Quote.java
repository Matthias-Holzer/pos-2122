package at.spengergasse.holzer.MicroserviceWisdom.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
@Getter
public class Quote extends AbstractPersistable<Long> {

    @Column(unique = true)
    private long number;
    @Column(length = 255)
    private String text;
    @Builder
    public Quote(Long id, long number, String text) {
        setId(id);
        this.number = number;
        this.text = text;
    }
}
