package sda.finalProject.Budget.dto;

import lombok.Data;
import sda.finalProject.Budget.categories.Categories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {
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


}
