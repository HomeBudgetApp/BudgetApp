package sda.finalProject.Budget.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Balance {
    private BigDecimal balance;
    private List<Transaction> transactionList;
}
