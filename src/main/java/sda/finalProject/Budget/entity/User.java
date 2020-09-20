package sda.finalProject.Budget.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Entity
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String name;
    private BigDecimal balance;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }


}
