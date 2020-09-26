package sda.finalProject.Budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.dto.LoginDTO;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    ModelAndView loginPage() {
        return new ModelAndView("index");
    }
}
