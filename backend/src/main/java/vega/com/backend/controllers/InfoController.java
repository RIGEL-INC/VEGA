package vega.com.backend.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vega.com.backend.common.RoleTag;
import vega.com.backend.security.PersonDetails;

@RestController
@RequestMapping("/api/v1.0/info")
@Tag(name = "info",description = "allows users to get information about themselves")
public class InfoController {

    @GetMapping
    public ResponseEntity<UserDetails>info(@AuthenticationPrincipal UserDetails userDetails){
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
}
