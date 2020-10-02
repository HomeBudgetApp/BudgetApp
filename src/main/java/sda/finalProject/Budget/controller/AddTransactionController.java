package sda.finalProject.Budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.dto.NewTransactionDTO;
import sda.finalProject.Budget.exception.UserLoginExistException;
import sda.finalProject.Budget.service.TransactionService;
import sda.finalProject.Budget.validators.NewTransactionValidator;

@Controller
@RequestMapping("/addTransaction")
public class AddTransactionController {
    private final TransactionService transactionService;
    private final NewTransactionValidator newTransactionValidator;

    public AddTransactionController(TransactionService transactionService, NewTransactionValidator newTransactionValidator) {
        this.transactionService = transactionService;
        this.newTransactionValidator = newTransactionValidator;
    }

    @InitBinder
    void init(WebDataBinder binder) {
        binder.setValidator(newTransactionValidator);
    }


    @GetMapping
    ModelAndView addTransactionPage() {
        ModelAndView mnv = new ModelAndView("addTransaction");
        mnv.addObject("addTransaction", new NewTransactionDTO());
        return mnv;
    }

    @PostMapping
    ModelAndView createNewTransaction(@ModelAttribute("addTransaction") @Validated NewTransactionDTO newTransactionDTO,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("addTransaction");
        }
        try {
            transactionService.createTransaction(newTransactionDTO);
        } catch (UserLoginExistException e) {
            ModelAndView mnv = new ModelAndView("addTransaction");
            mnv.addObject("error", e.getMessage());
            return mnv;
        }
        return new ModelAndView("redirect:/addTransaction");
    }
}
