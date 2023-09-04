package vega.com.main.util.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vega.com.main.dto.requests.RegisterRequest;
import vega.com.main.models.common.IPersonValidation;
import vega.com.main.services.ValidationService;

@Component
@RequiredArgsConstructor
public class RegisterUsernameValidation implements Validator {

    private final ValidationService validationService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(IPersonValidation.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterRequest person=(RegisterRequest) target;

        if(validationService.findByUsername(person.getUsername()).isPresent())
            errors.rejectValue("username","","username should be unique");
    }
}
