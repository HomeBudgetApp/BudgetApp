package sda.finalProject.Budget.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sda.finalProject.Budget.categories.Categories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime transactionDate;
    private Categories category;

    public TransactionEntity(String description, BigDecimal value, LocalDateTime transactionDate, Categories category) {
        this.description = description;
        this.value = value;
        this.transactionDate = transactionDate;
        this.category = category;
    }
}
