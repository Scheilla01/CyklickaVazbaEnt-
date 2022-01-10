package sk.slavo.cyklickaVazbaEntit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.slavo.cyklickaVazbaEntit.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
