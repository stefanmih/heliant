package rs.heliant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.heliant.entity.FormularDO;

public interface FormularRepository extends JpaRepository<FormularDO, Integer> {
}
