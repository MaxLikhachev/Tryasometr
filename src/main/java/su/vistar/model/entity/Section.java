package su.vistar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sections")
public class Section implements Serializable {
    @Id
    private long id;
    @Column
    private float factor;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Hole> holes = new ArrayList<>();
}
