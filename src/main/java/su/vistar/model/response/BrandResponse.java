package su.vistar.model.response;

import su.vistar.model.entity.Brand;

import java.io.Serializable;

public class BrandResponse implements Serializable {
    private long id;
    private String name;

    public BrandResponse(Brand brand) {
        this.id = brand.getID();
        this.name = brand.getName();
    }
}
