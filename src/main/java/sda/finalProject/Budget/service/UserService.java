package sda.finalProject.Budget.service;

import org.springframework.stereotype.Service;
import sda.finalProject.Budget.repository.UserRepository;
import sda.finalProject.Budget.entity.User;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(NewUserDTO newUserDTO){
User newUser = new User(newUserDTO.getLogin(), newUserDTO.getPassword());
userRepository.save(newUser);
    }
}
