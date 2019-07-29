package su.vistar.model.dao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="car")
public class CarDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long car_id;
    @Column
    private float min;
    @Column
    private float max;
    @Column
    private int year;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="model_id")
    ModelDAO model;

    public long getID(){return this.car_id;}

    public float getMin(){return this.min;}
    public void setMin(float min){this.min = min;}

    public float getMax(){return this.min;}
    public void setMax(float max){this.max = max;}

    public int getYear(){return this.year;}
    public void setYear(int year){this.year = year;}

    public ModelDAO getModel(){return this.model;}
    public void setModel(ModelDAO model){this.model=model;}
}
