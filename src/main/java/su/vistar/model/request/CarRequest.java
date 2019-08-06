package su.vistar.model.request;

import java.io.Serializable;


public class CarRequest implements Serializable {
    private float min;
    private float max;
    private int year;

    private ModelRequest model;

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

    public ModelRequest getModel() {
        return this.model;
    }

    public void setModel(ModelRequest model) {
        this.model = model;
    }
}
