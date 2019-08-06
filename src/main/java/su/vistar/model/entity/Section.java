package su.vistar.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonIgnore
    protected long id;
    @Column
    private float factor;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Hole> holes = new ArrayList<>();

    public long getID() {
        return this.id;
    }

    public float getFactor() {
        return this.factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public List<Hole> getHoles() {
        return this.holes;
    }

    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }
}
