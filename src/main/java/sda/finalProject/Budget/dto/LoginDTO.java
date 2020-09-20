package sda.finalProject.Budget.dto;

import lombok.Data;
import org.apache.tomcat.jni.User;

@Data
public class LoginDTO {

    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername() {
        this.username = username;
    }

    public void setPassword() {
        this.password = password;
    }

}
