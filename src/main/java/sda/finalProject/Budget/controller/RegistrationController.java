package sda.finalProject.Budget.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sda.finalProject.Budget.dto.NewUserDTO;
import sda.finalProject.Budget.service.UserService;


@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse respone) {
        ModelAndView mnv = new ModelAndView("register");
        mnv.addObject("user", new NewUserDTO());

        return mnv;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse respone, @ModelAttribute("user") NewUserDTO user) {
        userService.createUser(user);
        return new ModelAndView("welcome", "firstname", user.getFirstName());
    }
}
