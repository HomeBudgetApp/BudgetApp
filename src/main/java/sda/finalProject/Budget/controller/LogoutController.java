package sda.finalProject.Budget.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    ModelAndView logoutPage() {
        ModelAndView mnv = new ModelAndView("index");
        mnv.clear();
        return mnv;
    }
}
