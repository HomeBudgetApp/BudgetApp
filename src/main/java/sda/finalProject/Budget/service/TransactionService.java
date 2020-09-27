package sda.finalProject.Budget.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sda.finalProject.Budget.dto.TransactionDTO;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.repository.TransactionRepository;

import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class TransactionService implements TransactionRepository {

    public TransactionService(TransactionRepository transactionRepository) {
    }


    @Override
    public Optional<TransactionEntity> findById(Long Id) {
        return Optional.of(Id).stream().filter(a->a.)
    }
}