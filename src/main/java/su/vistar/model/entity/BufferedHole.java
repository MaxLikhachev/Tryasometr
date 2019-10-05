package su.vistar.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="holes_buffer")
public class BufferedHole implements Serializable {
    @Id
    @Setter(AccessLevel.NONE)
    private long timestamp;
    @Column
    private long sectionId;
    @Column
    private float distance;
}
