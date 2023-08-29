package vega.com.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vega.com.backend.common.JobTag;
import vega.com.backend.models.Person;
import vega.com.backend.service.PeopleService;

import java.util.List;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    private final PeopleService peopleService;

    public BackendApplication(PeopleService peopleService){
        this.peopleService=peopleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        peopleService.setPeople(List.of(
                new Person(1,"Archie", JobTag.BACKEND),
                new Person(2,"Tony",JobTag.FRONTEND)));
    }
}
