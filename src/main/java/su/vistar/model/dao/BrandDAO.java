package su.vistar.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="brand")
public class BrandDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long mark_id;
    @NotBlank
    private String name;

    public long getID(){return this.mark_id;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
