package sda.finalProject.Budget.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sda.finalProject.Budget.dto.LoginDTO;
import sda.finalProject.Budget.entity.User;
import sda.finalProject.Budget.repository.UserRepository;
import sda.finalProject.Budget.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserRepository userRepository;
    private final UserService userService;

    public LoginController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    ModelAndView loginPage() {
        ModelAndView mnv = new ModelAndView("login");
        mnv.addObject("form", new LoginDTO());
        return mnv;
    }

    @PostMapping
    String loginToPage() {

        return "redirect:/";
    }
}