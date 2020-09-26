package sda.finalProject.Budget.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sda.finalProject.Budget.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
Optional<UserEntity> findById(Long id);
Optional<UserEntity> findByPhone(String phone);
Optional<UserEntity> findByEmail(String email);
Optional<UserEntity> findByLogin(String login);
boolean existsByLogin(String login);
void deleteById(Long id);

}
