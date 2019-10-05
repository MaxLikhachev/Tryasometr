package su.vistar.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sections_buffer")
public class BufferedSection {
    @Id
    @Setter(AccessLevel.NONE)
    private long timestamp;
    @Column
    private long sectionId;
    @Column
    private float factor;
}
