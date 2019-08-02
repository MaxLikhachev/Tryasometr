package su.vistar.entity;

import javax.persistence.*;

@Entity
@Table(name="vibration")
public class Vibration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Section section;
    @Column
    private float factor;
    @Column
    private float latitude;
    @Column
    private float longitude;

    public long getID(){return this.id;}

    public float getFactor(){return this.factor;}
    public void setFactor(float factor){this.factor = factor;}

    public float getLatitude(){return this.latitude;}
    public void setLatitude(float latitude){this.latitude = latitude;}

    public float getLongitude(){return this.longitude;}
    public void setLongitude(float longitude){this.longitude = longitude;}

    public Section getSection(){return this.section;}
    public void setSection(Section section){this.section = section;}
}
