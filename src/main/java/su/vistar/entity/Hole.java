package su.vistar.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "holes")
public class Hole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonIgnore
    private long id;
    @Column
    private float factor;
    @Column
    private float latitude;
    @Column
    private float longitude;

    public long getID() {
        return this.id;
    }

    public float getFactor() {
        return this.factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
