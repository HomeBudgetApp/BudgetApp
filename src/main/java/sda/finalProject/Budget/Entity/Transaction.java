package sda.finalProject.Budget.Entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Transaction {
    private String description;
    private BigDecimal value;
    private LocalDateTime transactionDate;
    private Categories category;
}
