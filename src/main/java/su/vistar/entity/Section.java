package su.vistar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="sections")
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonIgnore
    protected long id;
    @Column
    private float factor;
    @OneToMany
    private List<Hole> holes;

    public long getID(){return this.id;}

    public float getFactor(){return this.factor;}
    public void setFactor(float factor){this.factor = factor;}

    public List<Hole> getHoles(){return this.holes;}
    public void setHoles(List<Hole> holes){this.holes = holes;}
}
