package sda.finalProject.Budget.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.entity.TransactionEntity;
import sda.finalProject.Budget.repository.TransactionRepository;
import sda.finalProject.Budget.service.TransactionService;

@RequestMapping("/")
public class AccountController {

    private final TransactionService transactionService;

    public AccountController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public String transactionTable(Model model) {
        model.addAttribute("transaction", transactionService.getTransactionList());
        return "transaction/allTransaction";
    }
}



