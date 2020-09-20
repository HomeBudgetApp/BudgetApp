package sda.finalProject.Budget.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;



    @Getter
    @Entity
    @NoArgsConstructor
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String login;
        private String password;
        private LocalDateTime registrationDate = LocalDateTime.now();

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }
    }


