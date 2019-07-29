package su.vistar.service;


import su.vistar.model.dao.BrandDAO;

import java.util.List;

public interface BrandService {
    BrandDAO add(BrandDAO mark);
    BrandDAO getById(long id);
    BrandDAO getByName(String name);
    List<BrandDAO> getAll();
    void remove();
}
