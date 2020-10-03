package sda.finalProject.Budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.dto.TransactionDTO;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.repository.UserRepository;
import sda.finalProject.Budget.service.AccountService;
import sda.finalProject.Budget.service.TransactionService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Set;

@Controller
@RequestMapping("/addTransaction")
public class AddTransactionController {
    private final TransactionService transactionService;
    private final AccountService accountService;
    private final UserRepository userRepository;

    public AddTransactionController(TransactionService transactionService, AccountService accountService, UserRepository userRepository) {
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.userRepository = userRepository;
    }

    @GetMapping
    ModelAndView addTransactionPage(Principal principal) {
        if ( principal != null) {
            ModelAndView mnv = new ModelAndView("addTransaction");
            mnv.addObject("addTransaction", new TransactionDTO());
            BigDecimal balance = accountService.getBalance(userRepository.findByLogin(principal.getName()).get().getId());
            Set<TransactionEntity> reportOfIncome = accountService.getReportOfIncome(userRepository.findByLogin(principal.getName()).get().getId());
            Set<TransactionEntity> reportOfMoneySpend = accountService.getReportOfMoneySpend(userRepository.findByLogin(principal.getName()).get().getId());
            mnv.addObject("balance", balance);
            mnv.addObject("income", reportOfIncome);
            mnv.addObject("spend", reportOfMoneySpend);
            return mnv;
        } else {
            ModelAndView mnv = new ModelAndView("login");
            return mnv;
        }
    }

    @PostMapping
    ModelAndView createNewTransaction(TransactionDTO transactionDTO, Principal principal) {
        if (transactionDTO.getValue().compareTo(BigDecimal.valueOf(0L)) > 0) {
            String username = principal.getName();
            Long userId = userRepository.findByLogin(username).get().getId();
            transactionService.createTransaction(transactionDTO, userId);
        } else {
            ModelAndView mnv = new ModelAndView("addTransaction");
            mnv.addObject("error", "Value must be higher than zero.");
            return mnv;
        }
        return new ModelAndView("redirect:/addTransaction");
    }
}
