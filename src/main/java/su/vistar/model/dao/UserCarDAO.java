package su.vistar.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_car")
public class UserCarDAO {
    @Id
    @JsonIgnore
    private long car_id;
    @Column
    @JsonIgnore
    private long user_id;

    public long getUserID(){return this.user_id;}
    public void setUserID(long user_id){this.user_id = user_id;}

    public long getCarID(){return this.car_id;}
    public void setCarID(long car_id){this.car_id = car_id;}
}
