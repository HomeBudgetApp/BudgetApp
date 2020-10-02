package sda.finalProject.Budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.repository.AccountRepository;
import sda.finalProject.Budget.repository.UserRepository;
import sda.finalProject.Budget.service.TransactionService;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class AccountController {

    private final TransactionService transactionService;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountController(TransactionService transactionService, AccountRepository accountRepository, UserRepository userRepository) {
        this.transactionService = transactionService;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    ModelAndView transactionTable(Principal principal) {
        ModelAndView mnv = new ModelAndView("index");
        if (principal != null) {
            String login = principal.getName();
            Long userId = userRepository.findByLogin(login).get().getId();
            mnv.addObject("login", login);
            mnv.addObject("transactions", accountRepository.findByUserId(userId).get().getTransactionEntityList());
        }
        return mnv;
    }

    @GetMapping("/all")
    public String transactionTable(Model model) {
        model.addAttribute("transaction", transactionService.getTransactionList());
        return "transaction/allTransaction";
    }
}



