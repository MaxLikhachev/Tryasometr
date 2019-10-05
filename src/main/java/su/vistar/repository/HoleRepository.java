package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.vistar.model.entity.Hole;

@Repository
public interface HoleRepository extends JpaRepository<Hole, Long> {
}
