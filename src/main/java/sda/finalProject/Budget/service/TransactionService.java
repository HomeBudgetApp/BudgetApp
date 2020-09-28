package sda.finalProject.Budget.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sda.finalProject.Budget.dto.TransactionDTO;
import sda.finalProject.Budget.entity.AccountEntity;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.repository.TransactionRepository;

import java.math.BigDecimal;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class TransactionService{

    private Map<Key,TransactionEntity> transactionMap;

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionEntity> getTransactionList(Long userId) {
        Optional<TransactionEntity> byUserId = transactionRepository.findById(userId);
        List<TransactionEntity> transactionEntityList = byUserId.stream().filter(a->a.getValue().compareTo(BigDecimal.valueOf(0)) == 1).collect(Collectors.toList());
        return transactionEntityList;
    }
}