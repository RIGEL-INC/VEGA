package vega.com.backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vega.com.backend.common.RoleTag;
import vega.com.backend.dto.requests.AuthenticationRequest;
import vega.com.backend.dto.requests.RegisterRequest;
import vega.com.backend.dto.responses.AuthResponse;
import vega.com.backend.models.Person;
import vega.com.backend.repositories.PeopleRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest request) {
        var person= Person.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleTag.ROLE_USER)
                .build();

        peopleRepository.save(person);
        var jwtToken=jwtService.generateToken(new PersonDetails(person));

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse auth(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );

        var person=peopleRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(new PersonDetails(person));
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
