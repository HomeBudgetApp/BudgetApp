package sda.finalProject.Budget.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.service.AccountService;
import sda.finalProject.Budget.service.TransactionService;

public class AccountController {

    private final TransactionService transactionService;

    public AccountController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView transactionTable() {
        ModelAndView mnv = new ModelAndView("index");
        mnv.addObject("transaction.id", transactionService.)
        mnv.addObject("transaction.description", transactionService.)
        mnv.addObject("transaction.value", transactionService.)
        mnv.addObject("transaction.categorie", transactionService.)
        return mnv;
    }
}



