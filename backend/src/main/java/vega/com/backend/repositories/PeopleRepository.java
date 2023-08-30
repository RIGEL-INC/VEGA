package vega.com.backend.repositories;

import org.springframework.stereotype.Repository;
import vega.com.backend.models.Person;
import vega.com.backend.repositories.common.CommonRepository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends CommonRepository<Person> {

    Optional<Person> findByUsername(String username);
}
