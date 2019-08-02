package su.vistar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="models")
public class Model implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@JsonIgnore
    protected long id;
    @Column
    private String name;

    public long getID(){return this.id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
