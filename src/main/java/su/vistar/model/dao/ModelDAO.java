package su.vistar.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="models")
public class ModelDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    protected long id;
    @Column(name="model_name")
    private String name;

    public long getID(){return this.id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
