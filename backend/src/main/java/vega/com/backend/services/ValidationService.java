package vega.com.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vega.com.backend.models.Person;
import vega.com.backend.repositories.PeopleRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ValidationService {

    private final PeopleRepository peopleRepository;

    public Optional<Person>findByUsername(String username){
        return peopleRepository.findByUsername(username);
    }
}
