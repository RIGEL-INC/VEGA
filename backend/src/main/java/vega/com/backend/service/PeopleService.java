package vega.com.backend.service;

import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vega.com.backend.models.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {
    @Setter
    private List<Person> people;

    public ResponseEntity<Person> getById(int id){

        return new ResponseEntity<>(people.get(id), HttpStatus.OK);
    }
}
