package su.vistar.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "models")
public class Model implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@JsonIgnore
    private long id;
    @Column
    private String name;
    @Column
    private int yearFrom;
    @Column
    private int yearTo;

    public long getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYears(int yearFrom, int yearTo) {
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    public int getYearFrom() {
        return this.yearFrom;
    }

    public int getYearTo() {
        return this.yearTo;
    }
}
