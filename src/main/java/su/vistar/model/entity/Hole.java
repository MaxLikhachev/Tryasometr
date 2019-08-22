package su.vistar.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "holes")
public class Hole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private long id;
    @Column
    private float begin;
    @Column
    private float end;

    public Hole(float begin, float end) {
        this.begin = begin;
        this.end = end;
    }
}
