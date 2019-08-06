package su.vistar.model.response;

import su.vistar.model.entity.Model;

import java.io.Serializable;

public class ModelResponse implements Serializable {
    private long id;
    private String name;

    public ModelResponse(Model model) {
        this.id = model.getID();
        this.name = model.getName();
    }
}
