package su.vistar.model.request;

import java.io.Serializable;

public class HoleRequest implements Serializable {
    private float factor;

    private float latitude;

    private float longitude;

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
