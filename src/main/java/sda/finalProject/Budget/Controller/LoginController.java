package sda.finalProject.Budget.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mnv = new ModelAndView("login");
        mnv.addObject("login",new Login());

        return mnv;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse respone, @ModelAttribute("login", Login login)){
    ModelAndView mnv = null;

    User user = userService.validateUser(login);
     if(null != null){
         mnv = new ModelAndView("welcome");
         mnv.addObject("firstname", user.getFirstname());
     }else{
         mnv = new ModelAndView("login");
         mnv.addObject("message", "User or passwors is wrong!");
     }
     return mnv;
    }
}
