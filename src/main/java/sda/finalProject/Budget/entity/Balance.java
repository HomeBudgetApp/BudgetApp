package sda.finalProject.Budget.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Balance {
    private BigDecimal accountBalance;
    private List<Transaction> transactionList = new ArrayList<>();
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Balance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
