package sda.finalProject.Budget.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import sda.finalProject.Budget.categories.Categories;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    @Override
    Optional<TransactionEntity> findById(Long Id);
    Optional<TransactionEntity> findByDescription(String description);
    Optional<TransactionEntity> findByValue(BigDecimal value);
    Optional<TransactionEntity> findByTransactionDate(LocalDateTime transactionDate);
    Optional<TransactionEntity> findByCategory(Categories category);
}
