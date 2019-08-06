package su.vistar.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SectionRequest implements Serializable {
    private float factor;
    private List<HoleRequest> holes = new ArrayList<>();

    public float getFactor() {
        return this.factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public List<HoleRequest> getHoles() {
        return this.holes;
    }

    public void setHoles(List<HoleRequest> holes) {
        this.holes = holes;
    }
}
