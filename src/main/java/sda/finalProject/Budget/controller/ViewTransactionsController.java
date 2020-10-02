package sda.finalProject.Budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.repository.AccountRepository;
import sda.finalProject.Budget.repository.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/viewTransactions")
public class ViewTransactionsController {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public ViewTransactionsController(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    ModelAndView viewTransactionsPage(Principal principal) {
        ModelAndView mnv = new ModelAndView("viewTransactions");
        if (principal != null) {
            String login = principal.getName();
            Long userId = userRepository.findByLogin(login).get().getId();
            mnv.addObject("login", login);
            mnv.addObject("transactions", accountRepository.findByUserId(userId).get().getTransactionEntityList());
        }
        return mnv;
    }
}
