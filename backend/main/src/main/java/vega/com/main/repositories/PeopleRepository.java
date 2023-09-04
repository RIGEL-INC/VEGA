package vega.com.main.repositories;

import org.springframework.stereotype.Repository;
import vega.com.main.models.Person;
import vega.com.main.repositories.common.CommonRepository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends CommonRepository<Person> {

    Optional<Person> findByUsername(String username);
}
