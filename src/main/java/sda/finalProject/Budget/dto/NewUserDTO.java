package sda.finalProject.Budget.dto;

import lombok.Data;
import sda.finalProject.Budget.entity.Balance;

import java.math.BigDecimal;

@Data
public class NewUserDTO {
    private String login;
    private String password;
    private String repeatedPassword;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private BigDecimal balance;
}
