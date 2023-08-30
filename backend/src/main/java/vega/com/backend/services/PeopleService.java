package vega.com.backend.services;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vega.com.backend.dto.responses.PersonDTOResp;
import vega.com.backend.models.Person;
import vega.com.backend.services.db.PeopleDBService;
import vega.com.backend.util.response.ResponseWithStatusAndDate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PeopleService {

    private final PeopleDBService peopleDBService;
    private final ModelMapper mapper;

    public PeopleService(PeopleDBService peopleDBService, ModelMapper mapper) {
        this.peopleDBService = peopleDBService;
        this.mapper = mapper;
    }

    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(int id){
        Person person=peopleDBService.get(id);
        PersonDTOResp personDTOResp=convertToPersonDTOResp(person);
        System.out.println();
        ResponseWithStatusAndDate<PersonDTOResp> response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                List.of(personDTOResp)
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private PersonDTOResp convertToPersonDTOResp(Person person){
        return mapper.map(person, PersonDTOResp.class);
    }
}
