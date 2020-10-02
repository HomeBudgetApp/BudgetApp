package sda.finalProject.Budget.dto;

import lombok.Data;
import sda.finalProject.Budget.categories.Categories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class NewTransactionDTO {
    private String description;
    private BigDecimal value;
    private LocalDateTime transactionDate = LocalDateTime.now();
    private Categories category;
}
