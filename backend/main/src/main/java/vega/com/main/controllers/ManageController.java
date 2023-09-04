package vega.com.main.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/manage")
@Tag(name = "manage",description = "controller for manage the application (only the admin+ can access this")
public class ManageController {

    @GetMapping
    public String test(){
        return "ADMIN PANEL";
    }
}
