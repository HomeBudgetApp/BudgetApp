package sda.finalProject.Budget.service;

import org.springframework.stereotype.Service;
import sda.finalProject.Budget.dto.TransactionDTO;
import sda.finalProject.Budget.entity.AccountEntity;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.repository.AccountRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Long userId) {
        AccountEntity accountEntity = new AccountEntity(userId);
        accountRepository.save(accountEntity);
    }

    public void addTransaction(TransactionDTO transactionDTO, Long userId) {
        if (transactionDTO.getCategory() != null && transactionDTO.getDescription() != null && transactionDTO.getTransactionDate() != null) {
            TransactionEntity transactionEntity = new TransactionEntity(transactionDTO.getDescription(),
                    transactionDTO.getValue(),
                    transactionDTO.getTransactionDate(),
                    transactionDTO.getCategory());
            AccountEntity accountEntity = accountRepository.findByUserId(userId).get();
            accountEntity.getTransactionEntityList().add(transactionEntity);
            accountRepository.save(accountEntity);
        }
        throw new RuntimeException("addTransactionIssue");
    }

    public Set<TransactionEntity> getReportByMonth(Long userId, Long monthValue) {
        if (userId != null && monthValue != null) {
            Optional<AccountEntity> accountByUserId = accountRepository.findByUserId(userId);
            Set<TransactionEntity> transactionEntityList = accountByUserId.get().getTransactionEntityList();
            return transactionEntityList.stream()
                    .filter(t -> t.getTransactionDate().getMonthValue() == monthValue)
                    .collect(Collectors.toSet());
        }
        throw new RuntimeException("getReportByMonthIssue");
    }

    public Set<TransactionEntity> getReportSinceAccountCreated(Long userId) {
        AccountEntity byUserId = accountRepository.findByUserId(userId).get();
        return byUserId.getTransactionEntityList();
    }

    public TransactionEntity getTransactionById(Long id, Set<TransactionEntity> transactionEntities) {
        if (id != null && transactionEntities != null) {
            return transactionEntities.stream().filter(t -> t.getId() == id).findAny().get();
        }
        throw new RuntimeException("getTransactionByIdIssue");
    }

    public Set<TransactionEntity> getReportOfIncome(Long userId) {
        Optional<AccountEntity> byUserId = accountRepository.findByUserId(userId);
        Set<TransactionEntity> transactionEntityList = byUserId.get().getTransactionEntityList();
        if (transactionEntityList.size() > 0) {
            return transactionEntityList.stream().filter(t -> BigDecimal.valueOf(0L).compareTo(t.getValue()) == -1)
                    .collect(Collectors.toSet());
        }
        return null;
    }

    public Set<TransactionEntity> getReportOfMoneySpend(Long userId) {
        Optional<AccountEntity> byUserId = accountRepository.findByUserId(userId);
        Set<TransactionEntity> transactionEntityList = byUserId.get().getTransactionEntityList();
        if (transactionEntityList.size() > 0) {
            return transactionEntityList.stream().filter(t -> BigDecimal.valueOf(0L).compareTo(t.getValue()) == 1)
                    .collect(Collectors.toSet());
        }
        return null;
    }

    public BigDecimal getBalance(Long userId) {
        Set<TransactionEntity> transactionEntityList = accountRepository.findByUserId(userId).get().getTransactionEntityList();
        BigDecimal balance = BigDecimal.valueOf(0);
        transactionEntityList.forEach(t -> balance.add(t.getValue()));
        return balance;
    }
}
