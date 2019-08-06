package su.vistar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonIgnore
    protected long id;
    @Column(name = "brand_name")
    private String name;
    @OneToMany
    private List<Model> models = new ArrayList<>();


    public long getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return this.models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
