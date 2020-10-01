package sda.finalProject.Budget.dto;

import lombok.Data;
import sda.finalProject.Budget.categories.Categories;
import sda.finalProject.Budget.repository.AccountRepository;
import sda.finalProject.Budget.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {

    private TransactionRepository transactionRepository;

    public TransactionDTO(TransactionRepository  transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime transactionDate;
    private Categories category;

    public TransactionDTO(Long id, String description, BigDecimal value, LocalDateTime transactionDate, Categories category) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.transactionDate = transactionDate;
        this.category = category;
    }

    public Long getId() {
        return id;
    }
}
