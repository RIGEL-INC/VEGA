package vega.com.main.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import vega.com.main.common.HttpTag;
import vega.com.main.dto.responses.PersonDTOResp;
import vega.com.main.models.Person;
import vega.com.main.services.db.PeopleDBService;
import vega.com.main.util.response.ResponseWithStatusAndDate;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final PeopleDBService peopleDBService;
    private final ModelMapper mapper;


    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(UserDetails userDetails) {

        List<PersonDTOResp>user=List.of(
                convertToPersonDTOResp(peopleDBService.getByUsername(userDetails.getUsername()))
        );
        ResponseWithStatusAndDate<PersonDTOResp>response=new ResponseWithStatusAndDate<>(
                HttpStatus.OK,
                LocalDateTime.now(),
                user
        );

        HttpHeaders headers=new HttpHeaders();
        headers.set("Content-Type","application/json");
        return ResponseEntity.ok()
                .headers(headers)
                .body(response);
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
