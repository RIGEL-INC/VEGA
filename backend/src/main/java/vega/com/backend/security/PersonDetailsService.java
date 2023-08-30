package vega.com.backend.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vega.com.backend.models.Person;
import vega.com.backend.repositories.PeopleRepository;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person=peopleRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User with USERNAME "+username+" not found"));
        return new PersonDetails(person);
    }
}
