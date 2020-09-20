package sda.finalProject.Budget.dto;

import lombok.Data;

@Data
public class NewUserDTO {
    private String login;
    private String password;
    private String repeatPassword;
}
