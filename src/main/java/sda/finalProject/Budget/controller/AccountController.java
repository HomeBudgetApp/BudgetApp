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
        mnv.addObject("transaction.id", transactionService.getTransactionList(userId).get().getId());
        mnv.addObject("transaction.description", transactionService.getTransactionList(userId).get().getDescription());
        mnv.addObject("transaction.value", transactionService.getTransactionList(userId).get().getValue());
        mnv.addObject("transaction.categorie", transactionService.getTransactionList(userId).get().getCategory());
        return mnv;
    }
}



