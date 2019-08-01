package su.vistar.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="brands")
public class BrandDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    protected long id;
    @Column(name = "brand_name")
    private String name;
    @OneToMany
    List<ModelDAO> models;


    public long getID(){return this.id;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public List<ModelDAO> getModels(){return this.models;}
    public void setModels(List<ModelDAO> models){this.models = models;}
}
