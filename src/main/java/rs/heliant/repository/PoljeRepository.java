package rs.heliant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.heliant.entity.PoljeDO;

public interface PoljeRepository extends JpaRepository<PoljeDO, Integer> {
}
