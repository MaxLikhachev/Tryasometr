package su.vistar.service;


import su.vistar.model.dao.BrandModelDAO;

import java.util.List;

public interface BrandModelService {
    BrandModelDAO add(BrandModelDAO brandModel);
    BrandModelDAO getByModelID(long model_id);
    List<BrandModelDAO> getAllByID(long model_id);
    void remove();
}
