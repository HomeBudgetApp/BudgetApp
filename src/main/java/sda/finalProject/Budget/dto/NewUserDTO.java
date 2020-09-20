package sda.finalProject.Budget.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
  public class NewUserDTO{
    private String login;
    private String password;
    private String repeatedPassword;
}


