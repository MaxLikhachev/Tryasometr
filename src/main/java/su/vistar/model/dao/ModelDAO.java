package su.vistar.model.dao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="model")
public class ModelDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long model_id;
    @Column
    private String name;

    public long getID(){return this.model_id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
