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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class TransactionService{



    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionEntity> getTransactionList() {
        List<TransactionEntity> transactionEntityList2 = transactionRepository.findAll().stream().collect(Collectors.toList());
        return transactionEntityList2;
    }
}