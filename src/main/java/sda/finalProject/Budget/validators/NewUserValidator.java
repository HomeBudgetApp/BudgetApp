package sda.finalProject.Budget.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sda.finalProject.Budget.dto.NewUserDTO;

@Component
public class NewUserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return NewUserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NewUserDTO newUserDTO = (NewUserDTO) o;
        if (StringUtils.isBlank(newUserDTO.getLogin())) {
            errors.rejectValue("login", "validator.field.blank");
        }
        if (StringUtils.isBlank(newUserDTO.getPassword())) {
            errors.rejectValue("password", "validator.field.blank");
        }
        if (StringUtils.isBlank(newUserDTO.getRepeatedPassword())) {
            errors.rejectValue("repeatedPassword", "validator.field.blank");
        }
    }
}
