package vega.com.backend.security;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import vega.com.backend.common.HttpTag;
import vega.com.backend.common.RoleTag;
import vega.com.backend.dto.requests.AuthenticationRequest;
import vega.com.backend.dto.requests.RegisterRequest;
import vega.com.backend.dto.responses.AuthResponse;
import vega.com.backend.dto.responses.NakedPersonDTO;
import vega.com.backend.dto.responses.errors.ValidationErrorResponse;
import vega.com.backend.models.Person;
import vega.com.backend.repositories.PeopleRepository;
import vega.com.backend.util.exception.NotFoundException;
import vega.com.backend.util.exception.NotValidException;
import vega.com.backend.util.validation.RegisterUsernameValidation;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper mapper;
    private final RegisterUsernameValidation registerUsernameValidation;

    public AuthResponse register(RegisterRequest request, BindingResult bindingResult) {
        registerUsernameValidation.validate(request,bindingResult);
        validation(bindingResult);

        var person = Person.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleTag.ROLE_USER)
                .build();

        peopleRepository.save(person);
        var jwtToken=jwtService.generateToken(new PersonDetails(person));

        return AuthResponse.builder()
                .status(HttpTag.AUTHENTICATED)
                .token(jwtToken)
                .user(convertToNakedPersonDTO(person))
                .build();
    }

    public AuthResponse auth(AuthenticationRequest request, BindingResult bindingResult) {
        validation(bindingResult);

        var person=peopleRepository.findByUsername(request.getUsername())
                .orElseThrow(()-> new NotFoundException("user with username '"+request.getUsername()+"' not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );

        var jwtToken=jwtService.generateToken(new PersonDetails(person));

        return AuthResponse.builder()
                .status(HttpTag.AUTHENTICATED)
                .token(jwtToken)
                .user(convertToNakedPersonDTO(person))
                .build();
    }

    private NakedPersonDTO convertToNakedPersonDTO(Person person){
        return mapper.map(person, NakedPersonDTO.class);
    }

    private void validation(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ValidationErrorResponse> errorsOfValid=new ArrayList<>();
            List<FieldError>errors=bindingResult.getFieldErrors();
            for(FieldError error:errors)
                errorsOfValid.add(new ValidationErrorResponse(error.getField(),error.getDefaultMessage()));
            throw new NotValidException(errorsOfValid);
        }
    }
}
