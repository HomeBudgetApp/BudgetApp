package sda.finalProject.Budget.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sda.finalProject.Budget.dto.NewTransactionDTO;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.repository.TransactionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionEntity> getTransactionList() {
        List<TransactionEntity> transactionEntityList2 = transactionRepository.findAll().stream().collect(Collectors.toList());
        return transactionEntityList2;
    }

    public void createTransaction(NewTransactionDTO newTransactionDTO) {
        TransactionEntity newTransactionEntity = new TransactionEntity(newTransactionDTO.getDescription(),
                newTransactionDTO.getValue(),
                newTransactionDTO.getTransactionDate(),
                newTransactionDTO.getCategory());
        transactionRepository.save(newTransactionEntity);
    }
}