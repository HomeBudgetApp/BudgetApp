package sda.finalProject.Budget.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.repository.UserRepository;
import sda.finalProject.Budget.service.TransactionService;
import java.security.Principal;

@RequestMapping("/")
public class AccountController {

    private final TransactionService transactionService;
    private final UserRepository userRepository;

    public AccountController(TransactionService transactionService, UserRepository userRepository) {
        this.transactionService = transactionService;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView transactionTable(Principal principal) {
        ModelAndView mnv = new ModelAndView("index");
        String login = principal.getName();
        Long userId = userRepository.findByLogin(login).get().getId();
        mnv.addObject("transactions", transactionService.getTransactionList(userId));
        return mnv;
    }
    @GetMapping("/all")
    public String transactionTable(Model model) {
        model.addAttribute("transaction", transactionService.getTransactionList());
        return "transaction/allTransaction";
    }
}



