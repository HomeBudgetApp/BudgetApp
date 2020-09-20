package sda.finalProject.Budget.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sda.finalProject.Budget.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findById(Long id);
Optional<User> findByLogin(String login);
boolean existsByLogin(String login);

}
