package su.vistar.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    protected long id;
    @Column
    private float min;
    @Column
    private float max;
    @Column
    private int year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id")
    private Model model;

    public long getID() {
        return this.id;
    }

    public float getMin() {
        return this.min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return this.min;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
