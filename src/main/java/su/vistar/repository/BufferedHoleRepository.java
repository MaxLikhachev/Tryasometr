package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import su.vistar.model.entity.BufferedHole;

import java.util.List;

@Repository
public interface BufferedHoleRepository extends JpaRepository<BufferedHole, Long> {
    List<BufferedHole> findAllByOrderBySectionId();
    @Query(value="select * from holes_buffer order by section_id, distance", nativeQuery = true)
    List<BufferedHole> findAllByOrderBySectionIdDistance();
}
