package su.vistar.model.request;

import java.io.Serializable;
import java.util.List;

public class BrandRequest implements Serializable {
    private String name;

    private List<ModelRequest> models;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelRequest> getModels() {
        return this.models;
    }

    public void setModels(List<ModelRequest> models) {
        this.models = models;
    }
}
