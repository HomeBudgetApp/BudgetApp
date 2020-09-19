package sda.finalProject.Budget.user;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class User {
    private int id;
    private String name;
    private BigDecimal balance;
    private String password;

    public User(int id, String name, BigDecimal balance, String password) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }


}
