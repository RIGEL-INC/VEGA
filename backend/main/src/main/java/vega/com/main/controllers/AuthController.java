package vega.com.main.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vega.com.main.dto.requests.AuthenticationRequest;
import vega.com.main.dto.requests.RegisterRequest;
import vega.com.main.dto.responses.AuthResponse;
import vega.com.main.dto.responses.PersonDTOResp;
import vega.com.main.security.AuthService;
import vega.com.main.services.PeopleService;

@RestController
@RequestMapping("/api/v1.0/auth")
@RequiredArgsConstructor
@Tag(name = "auth",description = "allows users to authenticate and register")
public class AuthController {

    private final AuthService authService;
    private final Logger logger;
    private final ModelMapper mapper;
    private final PeopleService peopleService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse>register(
            @RequestBody @Valid RegisterRequest request, BindingResult bindingResult){

        logger.info("-------------------------------------------------------------------------------------------------------");
        logger.info("POST REQUEST TO REGISTRATION (username:"+request.getUsername()+", password:"+request.getPassword()+")");
        logger.info("-------------------------------------------------------------------------------------------------------");

        HttpHeaders headers=new HttpHeaders();
        headers.set("Content-Type","application/json");

        return ResponseEntity.ok()
                .headers(headers)
                .body(authService.register(request, bindingResult));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse>authenticate(
            @RequestBody @Valid AuthenticationRequest request, BindingResult bindingResult){

        logger.info("-------------------------------------------------------------------------------------------------------");
        logger.info("POST REQUEST TO AUTHENTICATION (username:"+request.getUsername()+", password:"+request.getPassword()+")");
        logger.info("-------------------------------------------------------------------------------------------------------");

        return ResponseEntity.ok(authService.auth(request, bindingResult));
    }

    //TODO delete this method
    //THIS WORK NOT CORRECT, SO peopleService.get(id) RETURN ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>
    //AND NOT String
    @GetMapping("/test/{id}")
    public PersonDTOResp test(@PathVariable("id") int id){
        return mapper.map(peopleService.get(id),PersonDTOResp.class);
    }
}
