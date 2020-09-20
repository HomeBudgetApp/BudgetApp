package sda.finalProject.Budget.service;

import org.springframework.stereotype.Service;
import sda.finalProject.Budget.dto.NewUserDTO;
import sda.finalProject.Budget.repository.UserRepository;
import sda.finalProject.Budget.entity.UserEntity;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(NewUserDTO newUserDTO){
UserEntity newUserEntity = new UserEntity(newUserDTO.getLogin(), newUserDTO.getPassword(), newUserDTO.getFirstName(), newUserDTO.getLastName(), newUserDTO.getEmail(), newUserDTO.getPhone());
userRepository.save(newUserEntity);
    }
}
