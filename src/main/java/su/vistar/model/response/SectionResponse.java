package su.vistar.model.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SectionResponse implements Serializable {
    private float factor;
    private List<HoleResponse> holes = new ArrayList<>();

    public float getFactor() {
        return this.factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public List<HoleResponse> getHoles() {
        return this.holes;
    }

    public void setHoles(List<HoleResponse> holes) {
        this.holes = holes;
    }
}
