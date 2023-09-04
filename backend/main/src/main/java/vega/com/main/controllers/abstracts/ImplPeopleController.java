package vega.com.main.controllers.abstracts;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import vega.com.main.controllers.interfaces.IPeopleController;
import vega.com.main.dto.requests.PersonDTOForPatchReqst;
import vega.com.main.dto.requests.PersonDTOReqst;
import vega.com.main.dto.responses.PersonDTOResp;
import vega.com.main.services.PeopleService;
import vega.com.main.util.response.ResponseWithStatusAndDate;

@RequiredArgsConstructor
@Tag(name = "people",description = "a REST controller that allows you to commit with the people of this site")
public abstract class ImplPeopleController implements IPeopleController {

    private final PeopleService peopleService;
    private final Logger logger;

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(UserDetails userDetails) {
        return peopleService.get(userDetails);
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> get(int id) {
        logger.info("---------------------------------------");
        logger.info("GET BY ID METHOD");
        logger.info("---------------------------------------");
        return peopleService.get(id);
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll(int page, int size) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll(String fieldName) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAll(int page, int size, String fieldName) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> getAllWhoseUsernameStaringWith(String search) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> create(PersonDTOReqst personDTOReqst,
                                                                           BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> updatePutMethod(
            int id,
            PersonDTOReqst personDTOReqst,
            BindingResult bindingResult) {

        return null;
    }

    @Override
    public ResponseEntity<ResponseWithStatusAndDate<PersonDTOResp>> updatePatchMethod(
            int id,
            PersonDTOForPatchReqst personDTOForPatchReqst,
            BindingResult bindingResult) {

        return null;
    }

    @Override
    public HttpStatus delete(int id) {
        return null;
    }
}