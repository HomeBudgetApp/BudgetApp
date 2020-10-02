package sda.finalProject.Budget.service;

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

    public UserService(UserRepository userRepository, AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
    }

    public void createUser(NewUserDTO newUserDTO) {
        UserEntity newUserEntity = new UserEntity(newUserDTO.getLogin(), newUserDTO.getPassword(), newUserDTO.getFirstName(), newUserDTO.getLastName(), newUserDTO.getEmail(), newUserDTO.getPhone());
        userRepository.save(newUserEntity);
        accountService.createAccount(newUserEntity.getId());
    }
}
