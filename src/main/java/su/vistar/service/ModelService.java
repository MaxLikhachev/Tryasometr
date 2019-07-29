package su.vistar.service;


import su.vistar.model.dao.ModelDAO;

import java.util.List;

public interface ModelService {
    ModelDAO add(ModelDAO model);
    ModelDAO getById(long id);
    ModelDAO getByName(String name);
    List<ModelDAO> getAll();
    void remove();
}
