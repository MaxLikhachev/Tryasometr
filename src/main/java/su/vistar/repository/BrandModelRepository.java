package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import su.vistar.model.dao.BrandModelDAO;

import java.util.List;
@Repository
public interface BrandModelRepository extends JpaRepository<BrandModelDAO, Long> {
    @Query(value = "select * from brand_model where mark_id=:mark_id", nativeQuery = true)
    List<BrandModelDAO> findAllById(long mark_id);

    //@Query(value = "select * from mark_model where model_id=:model_id", nativeQuery = true)
    //BrandModelDAO findById(long mark_id);
}
