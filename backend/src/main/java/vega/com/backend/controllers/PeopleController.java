package vega.com.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vega.com.backend.models.Person;
import vega.com.backend.service.PeopleService;

@RestController
@RequestMapping("api/v1.0/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        return peopleService.getById(id);
    }
}
