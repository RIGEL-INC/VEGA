package vega.com.backend.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vega.com.backend.dto.requests.AuthenticationRequest;
import vega.com.backend.dto.requests.RegisterRequest;
import vega.com.backend.dto.responses.AuthResponse;
import vega.com.backend.dto.responses.PersonDTOResp;
import vega.com.backend.security.AuthService;
import vega.com.backend.services.PeopleService;

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
            @RequestBody RegisterRequest request){

        logger.info("-------------------------------------------------------------------------------------------------------");
        logger.info("POST REQUEST TO REGISTRATION (username:"+request.getUsername()+", password:"+request.getPassword()+")");
        logger.info("-------------------------------------------------------------------------------------------------------");

        HttpHeaders headers=new HttpHeaders();
        headers.set("Content-Type","application/json");

        return ResponseEntity.ok()
                .headers(headers)
                .body(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse>authenticate(
            @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.auth(request));
    }

    //TODO delete this method
    //THIS WORK NOT CORRECT, SO peopleService.get(id) RETURN ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>>
    //AND NOT String
    @GetMapping("/test/{id}")
    public PersonDTOResp test(@PathVariable("id") int id){
        return mapper.map(peopleService.get(id),PersonDTOResp.class);
    }
}
