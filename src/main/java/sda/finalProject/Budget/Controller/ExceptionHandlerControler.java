package sda.finalProject.Budget.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@ControllerAdvice
public class ExceptionHandlerControler {

    @ExceptionHandler(UserNotFoundException.class)
    ModelAndView

}
