package sda.finalProject.Budget.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Entity
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String username;
    private BigDecimal balance;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public User(String username, BigDecimal balance, String password, String firstname, String lastname, String email, String phone) {
        this.username = username;
        this.balance = balance;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
}