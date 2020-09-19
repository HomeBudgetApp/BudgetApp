package sda.finalProject.Budget.Entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Saldo {
    private BigDecimal balance;
    private List<Transaction> transactionList;
}
