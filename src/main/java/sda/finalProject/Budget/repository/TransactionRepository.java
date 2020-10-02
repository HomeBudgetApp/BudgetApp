package sda.finalProject.Budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.finalProject.Budget.entity.TransactionEntity;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    Optional<TransactionEntity> findById(Long userId);
//    Optional <Set<TransactionEntity>> findAllByTransactionDate_MonthValue(int monthValue);

}
