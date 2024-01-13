package rs.heliant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.heliant.entity.KorisnikDO;

public interface KorisnikRepository extends JpaRepository<KorisnikDO, Integer> {
}
