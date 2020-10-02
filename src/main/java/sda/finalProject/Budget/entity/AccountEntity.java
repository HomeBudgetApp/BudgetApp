package sda.finalProject.Budget.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Account")
@Getter
@NoArgsConstructor
@ToString
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private BigDecimal balance = BigDecimal.valueOf(0L);
    @OneToMany
    private Set<TransactionEntity> transactionEntityList = new HashSet<>();

    public AccountEntity(Long userId) {
        this.userId = userId;
    }

}
