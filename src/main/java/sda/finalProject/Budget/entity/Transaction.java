package sda.finalProject.Budget.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Transaction {
    private String description;
    private BigDecimal value;
    private LocalDateTime transactionDate;
    private Categories category;
}
