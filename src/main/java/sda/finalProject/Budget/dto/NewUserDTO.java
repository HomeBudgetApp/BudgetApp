package sda.finalProject.Budget.dto;

import lombok.Data;

@Data
public class NewUserDTO {
    private String login;
    private String password;
    private String repeatedPassword;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
