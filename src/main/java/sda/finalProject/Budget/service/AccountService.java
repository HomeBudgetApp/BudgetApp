package sda.finalProject.Budget.service;

import org.springframework.stereotype.Service;
import sda.finalProject.Budget.entity.AccountEntity;
import sda.finalProject.Budget.repository.AccountRepository;

import javax.transaction.Transactional;

@Transactional
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public void createAccount(Long userId){
        AccountEntity accountEntity = new AccountEntity(userId);
    accountRepository.save(accountEntity);
    }
}
