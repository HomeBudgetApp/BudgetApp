package sda.finalProject.Budget.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sda.finalProject.Budget.dto.NewTransactionDTO;
import sda.finalProject.Budget.dto.NewUserDTO;

import java.math.BigDecimal;

@Component
public class NewTransactionValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return NewUserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NewTransactionDTO newTransactionDTO = (NewTransactionDTO) o;
        if (BigDecimal.valueOf(0L).compareTo(newTransactionDTO.getValue()) != 1) {
            errors.rejectValue("value", "validator.field.ZeroOrLess");
        }
    }

}
