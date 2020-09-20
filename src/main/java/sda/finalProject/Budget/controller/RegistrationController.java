package sda.finalProject.Budget.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sda.finalProject.Budget.dto.NewUserDTO;
import sda.finalProject.Budget.exception.UserLoginExistException;
import sda.finalProject.Budget.service.UserService;
import sda.finalProject.Budget.validators.NewUserValidator;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final UserService userService;
    private final NewUserValidator validator;


    public RegistrationController(UserService userService, NewUserValidator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @InitBinder
    void init(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping
    ModelAndView registrationPage() {
        ModelAndView mnv = new ModelAndView("registration");
        mnv.addObject("registration", new NewUserDTO());
        return mnv;
    }

    @PostMapping
    ModelAndView createNewUser(@ModelAttribute("registration") @Validated NewUserDTO newUserDTO,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("registration");
        }
        try {
            userService.createUser(newUserDTO);
        }catch(UserLoginExistException e){
            ModelAndView mnv = new ModelAndView("registration");
            mnv.addObject("error", e.getMessage());
            return mnv;
        }
        return new ModelAndView("redirect:/login");
    }
}
