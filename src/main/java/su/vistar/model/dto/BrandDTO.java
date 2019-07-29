package su.vistar.model.dto;

import su.vistar.model.dao.BrandDAO;

public class BrandDTO {
    private String name;

    public BrandDTO(){}
    public BrandDTO(BrandDAO brand){
        setName(brand.getName());
    }

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
