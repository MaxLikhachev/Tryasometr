package su.vistar.model.dto;

import su.vistar.model.dao.ModelDAO;

public class ModelDTO {

    private long id;
    private String name;

    public ModelDTO(){}
    public ModelDTO(long id, ModelDAO model){setID(id); setName(model.getName()); }

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public long getID(){return this.id;}
    public void setID(long id){this.id = id;}
}
