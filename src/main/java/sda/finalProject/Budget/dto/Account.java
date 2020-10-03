package sda.finalProject.Budget.dto;

import lombok.Data;
import sda.finalProject.Budget.entity.AccountEntity;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.repository.AccountRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Account {

    private final AccountRepository accountRepository;

    public Account(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private Long id;
    private Long userId;
    private BigDecimal balance;
    private Set<TransactionEntity> transactionEntityList;

    public Account(AccountRepository accountRepository, Long id, Long userId, BigDecimal balance, Set<TransactionEntity> transactionEntityList) {
        this.accountRepository = accountRepository;
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.transactionEntityList = transactionEntityList;
    }
}
