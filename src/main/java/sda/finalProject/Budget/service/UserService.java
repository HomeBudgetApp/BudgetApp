package sda.finalProject.Budget.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sda.finalProject.Budget.dto.NewUserDTO;
import sda.finalProject.Budget.entity.UserEntity;
import sda.finalProject.Budget.repository.UserRepository;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AccountService accountService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(NewUserDTO newUserDTO) {
        UserEntity newUserEntity = new UserEntity(newUserDTO.getLogin(), passwordEncoder.encode(newUserDTO.getPassword()), newUserDTO.getFirstName(), newUserDTO.getLastName(), newUserDTO.getEmail(), newUserDTO.getPhone());
        userRepository.save(newUserEntity);
        accountService.createAccount(newUserEntity.getId());
    }
}
