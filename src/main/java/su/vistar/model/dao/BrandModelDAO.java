package su.vistar.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brand_model")
public class BrandModelDAO {
    @Id
    @JsonIgnore
    private long model_id;
    @Column
    @JsonIgnore
    private long mark_id;

    public long getMarkID(){return this.mark_id;}
    public void setMarkID(long user_id){this.mark_id = user_id;}

    public long getModelID(){return this.model_id;}
    public void setModelID(long model_id){this.model_id = model_id;}
}
