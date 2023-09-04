package vega.com.backend.services.db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vega.com.backend.models.Person;
import vega.com.backend.repositories.PeopleRepository;
import vega.com.backend.util.exception.NotFoundException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PeopleDBService {

    private final PeopleRepository peopleRepository;

    public Person get(int id) {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("user with ID " + id + " not found"));
    }

    public Person getByUsername(String username){
        return peopleRepository.findByUsername(username)
                .orElseThrow(()->new NotFoundException("user with username '"+username+"' not found"));
    }
}
