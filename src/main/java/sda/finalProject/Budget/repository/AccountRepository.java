package sda.finalProject.Budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.finalProject.Budget.entity.AccountEntity;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByUserId(Long userId);
}
