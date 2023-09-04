package vega.com.backend.controllers;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import vega.com.backend.controllers.abstracts.ImplPeopleController;
import vega.com.backend.services.PeopleService;

@RestController
@RequestMapping("api/v1.0/people")
public class PeopleController extends ImplPeopleController {

    public PeopleController(PeopleService peopleService, Logger logger) {
        super(peopleService, logger);
    }
}
