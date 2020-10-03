package sda.finalProject.Budget.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sda.finalProject.Budget.dto.TransactionDTO;
import sda.finalProject.Budget.entity.AccountEntity;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.repository.AccountRepository;
import sda.finalProject.Budget.repository.TransactionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public void createTransaction(TransactionDTO transactionDTO, Long userId) {
        TransactionEntity newTransactionEntity = new TransactionEntity(transactionDTO.getDescription(),
                transactionDTO.getValue(),
                transactionDTO.getTransactionDate(),
                transactionDTO.getCategory());
        transactionRepository.save(newTransactionEntity);
        AccountEntity accountEntity = accountRepository.findByUserId(userId).get();
        accountEntity.getTransactionEntityList().add(newTransactionEntity);
        accountRepository.save(accountEntity);

    }
}