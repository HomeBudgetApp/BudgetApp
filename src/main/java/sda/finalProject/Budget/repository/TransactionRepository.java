package sda.finalProject.Budget.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import sda.finalProject.Budget.categories.Categories;
import sda.finalProject.Budget.entity.AccountEntity;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    Optional <TransactionEntity> findById(Long userId);

}
