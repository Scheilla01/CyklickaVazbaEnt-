package sk.slavo.cyklickaVazbaEntit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.slavo.cyklickaVazbaEntit.Entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
