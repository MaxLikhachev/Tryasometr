package su.vistar.model.request;

import java.io.Serializable;

public class ModelRequest implements Serializable {
    private String name;
    private float min;
    private float max;
    private int yearFrom;
    private int yearTo;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
