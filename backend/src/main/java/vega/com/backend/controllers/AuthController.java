package vega.com.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vega.com.backend.dto.requests.AuthenticationRequest;
import vega.com.backend.dto.requests.RegisterRequest;
import vega.com.backend.dto.responses.AuthResponse;
import vega.com.backend.security.AuthService;

@RestController
@RequestMapping("/api/v1.0/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse>register(
            @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse>authenticate(
            @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.auth(request));
    }
}
