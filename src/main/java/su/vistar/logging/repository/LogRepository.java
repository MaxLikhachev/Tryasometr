package su.vistar.logging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.vistar.logging.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
