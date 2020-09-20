package sda.finalProject.Budget.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sda.finalProject.Budget.categories.Categories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Transaction {
    @Id
    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime transactionDate;
    private Categories category;

}
