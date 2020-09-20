package sda.finalProject.Budget.Controller;


import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;


@Controller
public class RegistrationController {

    public UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse respone) {
        ModelAndView mnv = new ModelAndView("register");
        mnv.addObject("user", new User());

        return mnv;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse respone, @ModelAttribute("user") User user) {
        userService.register(user);
        return new ModelAndView("welcome", "firstname", user.());
    }
}
