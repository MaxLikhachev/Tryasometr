package su.vistar.model.response;

public class VibrationResponse {
    private SectionResponse section;

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

    public SectionResponse getSection() {
        return this.section;
    }

    public void setSection(SectionResponse section) {
        this.section = section;
    }
}
