package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.vistar.model.entity.BufferedSection;

import java.util.List;

@Repository
public interface BufferedSectionRepository extends JpaRepository<BufferedSection, Long> {
    List<BufferedSection> findAllByOrderBySectionId();
    void deleteAllBySectionId(long id);
    List<BufferedSection> findAllBySectionId(long id);
    long countAllBySectionId(long id);
}
