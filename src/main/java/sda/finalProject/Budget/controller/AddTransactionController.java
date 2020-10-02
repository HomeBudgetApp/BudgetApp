package sda.finalProject.Budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.dto.NewTransactionDTO;
import sda.finalProject.Budget.service.TransactionService;

import java.math.BigDecimal;

@Controller
@RequestMapping("/addTransaction")
public class AddTransactionController {
    private final TransactionService transactionService;

    public AddTransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    ModelAndView addTransactionPage() {
        ModelAndView mnv = new ModelAndView("addTransaction");
        mnv.addObject("addTransaction", new NewTransactionDTO());
        return mnv;
    }

    @PostMapping
    ModelAndView createNewTransaction(NewTransactionDTO newTransactionDTO) {
        if (newTransactionDTO.getValue().compareTo(BigDecimal.valueOf(0L)) > 0) {
            transactionService.createTransaction(newTransactionDTO);
        } else {
            ModelAndView mnv = new ModelAndView("addTransaction");
            mnv.addObject("error", "Value must be higher than zero.");
            return mnv;
        }
        return new ModelAndView("redirect:/addTransaction");
    }
}
